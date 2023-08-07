package com.example.springbootthymeleafwebApp.service;

import com.example.springbootthymeleafwebApp.exception.ResourceNotFoundException;
import com.example.springbootthymeleafwebApp.model.Employee;
import com.example.springbootthymeleafwebApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;



    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }


    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void updateEmployee(Long id,Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Employee","id",id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setSalary(employee.getSalary());

        employeeRepository.save(existingEmployee);
    }







    @Override
    public void deleteEmployee(long id) {
        employeeRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Employee","id",id));

        employeeRepository.deleteById(id);

    }
}
