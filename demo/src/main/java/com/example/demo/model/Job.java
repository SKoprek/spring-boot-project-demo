package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "hire_date", columnDefinition = "DATE")
    private Date hireDate;
    @Column(name = "current_position")
    private String currentPosition;
    @Column(name = "department")
    private String department;
    @Column(name = "epmloyment_type")
    private String employmentType;
    @Column(name = "salary", columnDefinition = "numeric(10,2)")
    private Double salary;
}
