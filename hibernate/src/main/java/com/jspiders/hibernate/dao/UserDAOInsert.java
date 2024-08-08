package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.UserDTO;

public class UserDAOInsert {
	
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		openConnection();
		entityTransaction.begin();
		
		UserDTO userDTO =new UserDTO();
		userDTO.setId(4);
		userDTO.setName("Sham");
		userDTO.setEmail("sham@123");
		userDTO.setPassword("Sham@123");
		userDTO.setMobile(8764532176l);
		entityManager.persist(userDTO);
		
		UserDTO userDTO1=new UserDTO();
		userDTO1.setId(2);
		userDTO1.setName("Mukund");
		userDTO1.setEmail("mukund@gmail.com");
		userDTO1.setPassword("mukund@123");
		userDTO1.setMobile(9038323032l);
		entityManager.persist(userDTO1);
		
		
		
		
		entityTransaction.commit();
		closeConnection();
		
	}
	
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("hibernate");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
	}
	private static void closeConnection() {
		if(entityManagerFactory !=null) {
			entityManagerFactory.close();
		}
		if(entityManager != null) {
			entityManager.close();
		}
		if(entityTransaction != null) {
			if(entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}
	

}
