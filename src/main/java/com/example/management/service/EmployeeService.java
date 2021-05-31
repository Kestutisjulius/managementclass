package com.example.management.service;

import com.example.management.model.Employee;
import com.example.management.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {


    private final EmployeeRepository employeeRepository;



    public List<Employee>getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> addEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employeeRepository.findAll();
    }

    public void deleteByEmployeeId(Long id) {
        employeeRepository.deleteById(id);
    }

    public void updateEmployee(Employee employee) {
        //galima validacija. jei yra ? ...
        employeeRepository.save(employee);
    }
}
