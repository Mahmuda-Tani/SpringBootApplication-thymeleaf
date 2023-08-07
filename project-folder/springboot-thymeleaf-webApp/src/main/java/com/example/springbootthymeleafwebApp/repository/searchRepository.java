package com.example.springbootthymeleafwebApp.repository;

import com.example.springbootthymeleafwebApp.model.Employee;

import java.util.List;



public interface searchRepository {

    List<Employee> findBy_(Employee employee);
}
