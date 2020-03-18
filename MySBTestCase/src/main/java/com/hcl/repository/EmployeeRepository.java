package com.hcl.repository;

import com.hcl.model.Employe;

public interface EmployeeRepository{

	
	int count();

    int empsave(Employe emp);
    
   int getempById(Long id);
	
}
