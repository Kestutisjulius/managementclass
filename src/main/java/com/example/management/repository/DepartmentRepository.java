package com.example.management.repository;

import com.example.management.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // option1 jpql (java persistence query language) query using method name --> might become complex and long
    // SELECT * FROM Department WHERE name = ?
//    Department getDepartmentByName(String name);
    // option2 custom query su jpql --> most preferred
    @Query("SELECT d FROM Department d WHERE d.name=?1")  //?1 indukuoja pirma parametra (String name).
    Department getDepartmentByName(String name);
    // option3 native queriai --> specific to given database
//    @Query(value = "SELECT * FROM department WHERE name = ?", nativeQuery = true)
//    Department getDepartmentByName(String name);
}


