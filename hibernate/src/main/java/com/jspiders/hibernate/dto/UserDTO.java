package com.jspiders.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="user_info")


public class UserDTO {
	@Id
	private int id;
	@Column(nullable=false ,unique=false)
	private String name;
	@Column(nullable=false ,unique=true)
	private String email;
	@Column(nullable=false ,unique=false)
	private String password;
	@Column(nullable=false ,unique=true)
	private long mobile;
	
	

}
