package com.example.springbootthymeleafwebApp.controller;


import com.example.springbootthymeleafwebApp.model.Employee;
import com.example.springbootthymeleafwebApp.repository.EmployeeRepository;
import com.example.springbootthymeleafwebApp.service.EmployeeService;
import com.example.springbootthymeleafwebApp.repository.searchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private searchRepository searchRepository;








    @GetMapping("/index")
    public  ModelAndView viewHomePage(Model model) {

        List<Employee>employees = employeeService.getAllEmployee();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("/index/new")
    public ModelAndView createEmployeeForm(Model model){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("create_employee");

        Employee employee = new Employee();
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @PostMapping("/saveEmployee")
    public ModelAndView saveEmployee(@ModelAttribute("employee") Employee employee) {

        employeeService.saveEmployee(employee);

        return new ModelAndView("redirect:/api/index");

    }


    @GetMapping("/index/edit/{id}")
    public ModelAndView editEmployee(@PathVariable("id") Long id,Model model){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit_employee");

        Employee employee = employeeService.getEmployeeById(id);
        modelAndView.addObject("employee", employee);


        return modelAndView;
    }


    @PostMapping("/updateEmployee/{id}")


    public ModelAndView updateStudent(@PathVariable("id") Long id,@ModelAttribute("employee") Employee employee ){


        employeeService.updateEmployee(id,employee);

        return new ModelAndView("redirect:/api/index");

    }



    @GetMapping("/index/delete/{id}")
    public ModelAndView deleteEmployee(@PathVariable("id") Long id){


         employeeService.deleteEmployee(id);
        return new ModelAndView("redirect:/api/index");
    }


    @GetMapping("/index/search")
    public ModelAndView searchEmployee(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Search_employee");

        List<Employee> employees = employeeService.getAllEmployee();
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }


    @PostMapping("/searchEmployee")


    public ModelAndView searchEmployee(@ModelAttribute("employee") Employee employee) {

        List<Employee> employees = searchRepository.findBy_(employee);

        System.out.println("***************************************");
        System.out.println(employees);


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Search_employee");
        modelAndView.addObject("employees", employees);
        return modelAndView;

    }



}
