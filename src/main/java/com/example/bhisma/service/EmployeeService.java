package com.example.bhisma.service;

import com.example.bhisma.entity.Employee;
import com.example.bhisma.model.EmployeeDto;
import com.example.bhisma.repository.EmployeeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
    @Autowired
    EmployeeRepo employeeRepo;
    public ResponseEntity<Employee> saveEmployee(EmployeeDto emp) {
        Employee employee = new Employee();
        employee.setFirstName(emp.getFirstName());
        employee.setLastName(emp.getLastName());
        employee.setAge(emp.getAge());
        employee.setDesignation(emp.getDesignation());
        employee.setPhoneNumber(emp.getPhoneNumber());
        employee.setId(emp.getId());
         employeeRepo.save(employee);
         return ResponseEntity.ok(employee);
    }
}
