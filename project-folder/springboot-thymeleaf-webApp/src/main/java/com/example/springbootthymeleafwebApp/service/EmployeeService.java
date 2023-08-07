package com.example.springbootthymeleafwebApp.service;

import com.example.springbootthymeleafwebApp.model.Employee;

import java.util.List;

public interface EmployeeService {


    List<Employee> getAllEmployee();
    void saveEmployee(Employee employee);

    Employee getEmployeeById(long id);
    void updateEmployee(Long id,Employee employee);
    void deleteEmployee(long id);

}
