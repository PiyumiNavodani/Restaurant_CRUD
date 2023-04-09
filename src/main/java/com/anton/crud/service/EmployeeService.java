package com.anton.crud.service;

import com.anton.crud.model.Employee;
import com.anton.crud.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    //Create Employee
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    //Read Employee
    public List<Employee> getEmployee(){
        return employeeRepository.findAll();
    }

    //Update Employee
    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    //Delete Employee
    public void deleteEmployee(long id){
        employeeRepository.deleteById(id);
    }

    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).get();
    }
}
