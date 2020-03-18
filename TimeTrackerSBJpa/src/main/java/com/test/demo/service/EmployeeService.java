package com.test.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.test.demo.dao.EmployeeDao;
import com.test.demo.exception.UserNotFoundException;
import com.test.demo.model.Employee;

public class EmployeeService {

	@Autowired
	EmployeeDao dao;
	
	public void saveEmployee(Employee emp)
	{
		dao.save(emp);
	}
	
	public Employee getEmployeeById(Long id) throws UserNotFoundException 
    {
        Optional<Employee> employee = dao.findById(id);
         
        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new UserNotFoundException("No employee record exist for given id");
        }
    }
	
}
