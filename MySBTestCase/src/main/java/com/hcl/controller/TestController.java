package com.hcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.model.Employe;
import com.hcl.model.LoginTimeAudit;
import com.hcl.repository.EmployeeRepository;
import com.hcl.repository.LoginAuditRepository;

@RestController
public class TestController {

	@Autowired
	EmployeeRepository audit;
	
	@Autowired
	LoginAuditRepository loginrepo;
	
	
	@PostMapping("/empsave")
	public int empsavesave(Employe emp) {
		int result=0;
		try {
			result=audit.empsave(emp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	@GetMapping("/getcount")
	public int getempcount() {
		int result=0;
		try {
			result=audit.count();
			System.out.println("Result: "+result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	@PostMapping("/Timesave")
	public int empsavesave(LoginTimeAudit laudit) {
		int result=0;
		try {
			result=loginrepo.auditsave(laudit);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
	
	
	
	
}
