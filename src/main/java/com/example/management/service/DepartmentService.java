package com.example.management.service;

import com.example.management.model.Department;
import com.example.management.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }
    public Department getDepartmentByName(String name) {
        return departmentRepository.getDepartmentByName(name);
    }
}