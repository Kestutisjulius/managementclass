package com.example.management.config;

import com.example.management.model.Department;
import com.example.management.model.Employee;
import com.example.management.repository.DepartmentRepository;
import com.example.management.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class ManagementConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        return args -> {

            Department departmentIt = new Department(1L,"IT", "OZO. st. 6");
            departmentRepository.save(departmentIt);

            Department departmentOther = new Department(2L,"Other", "Gedimino. av. 9");
            departmentRepository.save(departmentOther);

            employeeRepository.saveAll(Arrays.asList(
                    new Employee("Will", "Smith", 1200, 4,departmentIt),
                    new Employee("Vidas", "Masionis", 1900, 7,departmentOther),
                    new Employee("Igoris", "kofas", 800, 1,departmentIt),
                    new Employee("Larry", "Brown", 1500, 5,departmentOther),
                    new Employee("Tadas", "Blinda", 2100, 10,departmentIt)
            ));
        };
    }
}
