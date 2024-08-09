package com.jspiders.hibernate.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.hibernate.dto.UserDTO;

public class UserSelect2 {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static Query query;
	
	public static void main(String[] args) {
		openConnection();
		query=entityManager.createQuery("SELECT user from UserDTO user");
	    
		@SuppressWarnings("unchecked")
		List<UserDTO> users = (List<UserDTO>)query.getResultList();
		if(users.size() >0) {
			for (UserDTO user: users) {
				System.out.println(user);
				
			}
		}
		closeConnection();
	}
	
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("hibernate");
		entityManager=entityManagerFactory.createEntityManager();
	}
	private static void closeConnection() {
		if(entityManagerFactory!=null) {
			entityManagerFactory.close();
		}
		if(entityManager!= null) {
			entityManager.close();
		}
	}

}
