package com.example.management.controller;

import com.example.management.model.Department;
import com.example.management.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/department")
public class DepartmentController {
    private final DepartmentService departmentService;
    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }
    @GetMapping("/{departmentName}")
    public Department getDepartmentByName(@PathVariable String departmentName) {
        return departmentService.getDepartmentByName(departmentName);
    }
}
