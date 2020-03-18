package com.example.demo.controller;




import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserDetails;
import com.example.demo.service.UserService;



@RestController
@RequestMapping("/userContoller")
public class UserContoller {

	@Autowired
	private UserService service;
	
	@GetMapping("/fetchUsers")
	  public ResponseEntity<List<UserDetails>> getAllUsers() {
	        List<UserDetails> userDetails = service.getAllUsers();
	        return new ResponseEntity(userDetails,HttpStatus.OK);
	       
	 
	    }
	 
	@PostMapping("/save")
	public ResponseEntity<UserDetails> addUserDetails(@Valid @RequestBody UserDetails userDetails) {
		  UserDetails user = service.addUserDetails(userDetails);
	        return new ResponseEntity(user,HttpStatus.OK);
		
	}
	
	
}
