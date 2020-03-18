package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.UserDaoHibernateSessionImpl;
import com.example.demo.model.UserDetails;


@Service
public class UserService {

	@Autowired
	private UserDaoHibernateSessionImpl dao;
	
	@Transactional
	public List<UserDetails> getAllUsers() {
		return dao.getAllUsers();
	}
	
	@Transactional
		public UserDetails addUserDetails(UserDetails userDetails)  {
			UserDetails user=dao.addUserDetails(userDetails);
			
			return user;
		}
}


/*  public List<UserDetails> getAllUsers() {
List<UserDetails> users=new ArrayList<>();

List<UserDetails> list = dao.getAllUsers();
if(list.isPresent()) {
users= list.get();
}
return users;
}
*/  
