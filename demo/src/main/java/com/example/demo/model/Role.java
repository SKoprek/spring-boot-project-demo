package com.example.demo.model;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/**
 * Role Model
 * 
 * @author Szymon Koprek
 */
@Entity
@Table(name="roles")
public class Role implements GrantedAuthority{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Integer id;
    @Column(name= "name", unique = true, nullable = true)
    private String name;

    @Override
	public String getAuthority() {
		return name;
	}
}
