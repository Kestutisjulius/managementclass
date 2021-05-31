package com.example.management.controller;

import com.example.management.model.Employee;
import com.example.management.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Slf4j
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;



    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees from database...");
        return employeeService.getAllEmployees();
    }

//    @GetMapping("/{id}")
//    public Employee getEmployeeById(@PathVariable Long id){
//        log.info("Fetching one employee from database...");
//        return employeeService.getEmployeeById(id);
//    }


    /**
     * https://www.geeksforgeeks.org/optional-ispresent-method-in-java-with-examples/#:~:text=The%20isPresent()%20method%20of,method%20returns%20false%2C%20else%20true
     *
     *
     */


    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (null == employee) {
            log.info("Employee with id " + id + " does not exist.");
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        log.info("Found employee: " + employee);
        return  new ResponseEntity<>(employee, HttpStatus.OK);
    }



    @PostMapping("/")
    public List<Employee> addEmployee(@RequestBody Employee employee) {
        log.info("Adding " + employee + " to database");
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public List<Employee> deleteEmployeeById (@PathVariable Long id) {
        log.info("Deleting employee is id" + id + " from database");
        employeeService.deleteByEmployeeId(id);
        return  employeeService.getAllEmployees();
    }

    @PutMapping("/")
    public Employee updateEmployee (@RequestBody Employee employee) {
        log.info("Updating:" + employee + " from database");
        employeeService.updateEmployee(employee);
        return employeeService.getEmployeeById(employee.getId());
    }

}
