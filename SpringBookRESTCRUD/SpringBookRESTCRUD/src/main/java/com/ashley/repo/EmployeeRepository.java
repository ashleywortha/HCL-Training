package com.ashley.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashley.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
