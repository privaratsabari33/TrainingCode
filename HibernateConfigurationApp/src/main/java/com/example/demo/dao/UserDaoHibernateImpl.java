/*package com.example.demo.dao;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserDetails;

@Transactional
@Repository
public class UserDaoHibernateImpl   {

	@PersistenceContext
	private EntityManager entityManager;
	
  
	public Optional<List<UserDetails>> getAllUsers()
	{
    	Session hibernateSession=entityManager.unwrap(Session.class);
		
		return Optional.of((List<UserDetails>)hibernateSession.createQuery("from User",UserDetails.class).getResultList());
		
		
	}
	

	public Long save(UserDetails newUser) {
		entityManager.persist(newUser);
		return Objects.nonNull(newUser)&&Objects.nonNull(newUser.getId())?newUser.getId():null;
	}


	
	

	
}
*/