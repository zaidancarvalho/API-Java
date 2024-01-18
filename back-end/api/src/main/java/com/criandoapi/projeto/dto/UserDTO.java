package com.criandoapi.projeto.dto;

import com.criandoapi.projeto.entities.User;

public class UserDTO {

	private Integer id;
	private String name;
	private String username;
	private String email;
	private String password;
	private String telephone;
	
	public UserDTO(Integer id, String name, String username, String email, String password, String telephone) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
	}
	
	public UserDTO(User entity) {
		id = entity.getId();
		name = entity.getName();
		username = entity.getUsername();
		email = entity.getEmail();
		password = entity.getPassword();
		telephone = entity.getTelephone();
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getTelephone() {
		return telephone;
	}
}
