package com.example.springbootthymeleafwebApp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employees_info")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "salary")
    private String salary;




}
