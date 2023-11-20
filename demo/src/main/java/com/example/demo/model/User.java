package com.example.demo.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * User Model
 * 
 * @author Szymon Koprek
 * TODO FIX ROLE
 */

 @Entity
 @Table(name="users")
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;
    @Column(name="username", unique = true, nullable = false)
    private String username;
    @Column(name="password", nullable = false)
    private String password;
    @Column(name="account_non_expired", nullable = false, columnDefinition = "BOOLEAN")
    private boolean accountNonExpired;
    @Column(name="account_non_locked", nullable = false, columnDefinition = "BOOLEAN")
    private boolean accountNonLocked;
    @Column(name="credentials_non_expired", nullable = false, columnDefinition = "BOOLEAN")
    private boolean credentialsNonExpired;
    @Column(name="enabled", nullable = false, columnDefinition = "BOOLEAN")
    private boolean enabled;
    // @Transient
    // private Set<Role> roles = new HashSet<Role>();
    //add all fields to the database
    @Enumerated(EnumType.STRING)
    private RoleTest role;

    public User(){

    }
    public User(Long id, String username, String password, boolean accountNonExpired, boolean accountNonLocked,
            boolean credentialsNonExpired, boolean enabled, RoleTest role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
        this.role = role;
    }
    public RoleTest getRole() {
        return role;
    }
    public void setRole(RoleTest role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    // Add Role
    // public Set<Role> getRoles() {
	// 	return roles;
	// }

	// public void setRoles(Set<Role> roles) {
	// 	this.roles = roles;
	// }
    //

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }
    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }
    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }
    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }
    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // return roles;
        return List.of(new SimpleGrantedAuthority(role.name()));
    }
}
