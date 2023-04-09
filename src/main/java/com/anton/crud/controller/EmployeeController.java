package com.anton.crud.controller;

import com.anton.crud.model.Employee;
import com.anton.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    //Add Employee
    @PostMapping(path="/addEmployee")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    //Get Employee
    @GetMapping (path = "/getEmployee")
    public List<Employee> getEmployee(){
        return employeeService.getEmployee();
    }

    //Update Employee
    @PutMapping (path = "/putEmployee/{id}")
    public ResponseEntity<?>updateEmployee (@RequestBody Employee employee, @PathVariable long id){
        Optional<Employee> findEmployee = Optional.ofNullable(employeeService.getEmployeeById(id));
        if(findEmployee.isPresent()){
            Employee updateEmployee = findEmployee.get();
            updateEmployee.setEmpName(employee.getEmpName());
            updateEmployee.setEmpAge(employee.getEmpAge());
            updateEmployee.setEmpDesignation(employee.getEmpDesignation());
            updateEmployee.setEmpSalary(employee.getEmpSalary());
            return new ResponseEntity<>(employeeService.updateEmployee(updateEmployee), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //Delete Employee
    @DeleteMapping(path = "/deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable long id){
        employeeService.deleteEmployee(id);
    }
}
