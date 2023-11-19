package com.example.demo.configuration.security;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.demo.Constans;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class CustomJWTService {
    Long now = System.currentTimeMillis();

    public String extractUserLogin(String token) {
        return extractClaim(token, Claims::getSubject);
    }
    public <T> T extractClaim(String token, Function<Claims, T> claimResolver){
        final Claims claims  = extractAllClames(token);
        return claimResolver.apply(claims);
    }
    public String generateToken (UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }
    public String generateToken(Map<String, Object> totalClaims, UserDetails userDetails){
        return Jwts
        .builder()
        .claims(totalClaims)
        .subject(userDetails.getUsername())
        .issuedAt(new Date(System.currentTimeMillis()))
        .expiration(new Date(System.currentTimeMillis()+ Constans.TOKEN_EXPIRED))
        .signWith(getSingInKey(),Jwts.SIG.HS256).compact();
    }
    public boolean isTokenValid(String token, UserDetails userDetails){
        final String userLogin = extractUserLogin(token);
        return (userLogin.equals(userDetails.getUsername())) && ! isTokenExpired(token);
    }
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
    private Claims extractAllClames(String token){
        return Jwts.parser()
        .verifyWith(getSingInKey())
        .build()
        .parseSignedClaims(token)
        .getPayload();
    }
    private SecretKey getSingInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(Constans.SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
