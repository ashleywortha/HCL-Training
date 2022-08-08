package com.ashley.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ashley.model.Employee;
import com.ashley.repo.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository repo; //HAS A
	
	public List<Employee> getAllEmps(){
		return repo.findAll();
	}
	
	public Optional<Employee> getEmpById(int id){
		return repo.findById(id);
	}
	
	public void deleteEmp(Integer id) {
		repo.deleteById(id);
	}
	
	public void addEmp(Employee emp) {
		repo.save(emp);
	}
	
	public void updateEmp(Integer id, Employee emp) {
		Employee userInDB = 
		repo.findById(id).get();
		userInDB.setName(emp.getName());
		userInDB.setDesignation(emp.getDesignation());
		repo.save(userInDB);	
		}

}
