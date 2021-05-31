package com.example.management.service;

import com.example.management.model.Department;
import com.example.management.model.Employee;
import com.example.management.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class EmployeeServiceTest {

    private static final String JIM = "Jim";
    @InjectMocks
    private EmployeeService employeeService;
    @Mock
    private EmployeeRepository employeeRepository;
    @Test
    public void testGetAllEmployees() {
        List<Employee> employees = createEmployees();
        when(employeeRepository.findAll()).thenReturn(employees);
        List<Employee> fetchedEmployees = employeeService.getAllEmployees(); //cia yra mano testuojamas metodas
        assertThat(fetchedEmployees.get(0).getFirstName(), is(JIM));
    }
    private List<Employee> createEmployees() {
        Department department = new Department(1L, "it", "rinktines 5");
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1L, "Jim", "Russel", 1000, 5, department));
        employees.add(new Employee(2L, "Bill", "Jones", 2000, 7,department));
        employees.add(new Employee(3L, "Danny", "Green", 1500, 6,department));
        return employees;
    }
}