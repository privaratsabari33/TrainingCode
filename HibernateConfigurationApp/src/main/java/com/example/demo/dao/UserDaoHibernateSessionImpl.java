package com.example.demo.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserDetails;

@Repository
public class UserDaoHibernateSessionImpl {

   @Autowired
   private SessionFactory sessionFactory;
	
	public List<UserDetails> getAllUsers()
	{
		Session session = this.sessionFactory.getCurrentSession();
		List<UserDetails>  users = session.createQuery("from UserDetails").list();
		return users;
		//data taken from entity class name not tablename for createQuery method
		//createNativeQuery method for native query without entity class
		
    		
		//return Optional.of(sessionFactory.getCurrentSession().createQuery("from User",UserDetails.class).getResultList());
		
		
	}


	public UserDetails addUserDetails(UserDetails userDetails) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(userDetails);
		return userDetails;

		
	}

	
}

