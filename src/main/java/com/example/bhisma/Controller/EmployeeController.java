package com.example.bhisma.Controller;

import com.example.bhisma.entity.Employee;
import com.example.bhisma.model.EmployeeDto;
import com.example.bhisma.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/v1")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/saveEmployee")
    public ResponseEntity<Employee> calculate(
            @RequestBody EmployeeDto emp) {

        logger.info("Creating a employee Object emp: {}", emp);
        return employeeService.saveEmployee(emp);
    }
}