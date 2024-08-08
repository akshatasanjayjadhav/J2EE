package com.jspiders.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.UserDTO;

public class UserSelect {
	private static EntityManager entityManager;
	private static EntityManagerFactory entityManagerFactory;
	
	public static void main(String[] args) {
		openConnection();
		UserDTO userDTO =new UserDTO();
		userDTO=entityManager.find(UserDTO.class, 2);
		if(userDTO != null) {
			System.out.println(userDTO.getId());
			System.out.println(userDTO.getName());
			System.out.println(userDTO.getEmail());
			System.out.println(userDTO.getPassword());
			System.out.println(userDTO.getMobile());
		}else
			System.out.println("user does not found");
		closeConnection();
		
	}
	
	private static void openConnection() {
		entityManagerFactory=Persistence.createEntityManagerFactory("hibernate");
		entityManager=entityManagerFactory.createEntityManager();
		
	}
	private static void closeConnection() {
		if(entityManager != null) {
			entityManager.close();
		}
		if(entityManagerFactory !=null) {
			entityManagerFactory.close();
		}
	}

}
