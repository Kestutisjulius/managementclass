package com.example.management.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Integer salary;
    private Integer experience;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    public Employee(String firstName, String lastName, Integer salary, Integer experience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.experience = experience;
    }

    public Employee(String firstName, String lastName, Integer salary, Integer experience, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.experience = experience;
        this.department = department;
    }
}
