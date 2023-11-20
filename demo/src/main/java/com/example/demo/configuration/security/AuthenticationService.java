package com.example.demo.configuration.security;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.RoleTest;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;


@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CustomJWTService customJWTService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder,
            CustomJWTService customJWTService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.customJWTService = customJWTService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(RegisterRequest request) {
        //TO MOZNA BUILDEM ALE
        User user = new User();
        user.setUsername(request.getLogin());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(RoleTest.USER);
        userRepository.save(user);
        var jwtToken = customJWTService.generateToken(user);
        
        // return AuthenticationResponse.builder().token(jwtToken).build();
        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getLogin(), request.getPassword()
                )
        );
        User user = userRepository.findByUsername(request.getLogin()).orElseThrow();
        var jwtToken = customJWTService.generateToken(user);
        
        // AuthenticationResponse authenticationResponse = new AuthenticationResponse(jwtToken);

        return new AuthenticationResponse(jwtToken);
    }
    
}
