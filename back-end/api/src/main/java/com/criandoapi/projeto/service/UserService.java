package com.criandoapi.projeto.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.criandoapi.projeto.dto.UserDTO;
import com.criandoapi.projeto.entities.User;
import com.criandoapi.projeto.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<UserDTO> findAll() {
		List<User> list = repository.findAll();
		return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}

	public UserDTO insert(UserDTO dto) {
		User entity = new User();
		copyDToToEntity(dto, entity);
		entity = repository.save(entity);
		return new UserDTO(entity);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public UserDTO update(Integer id, UserDTO dto) {
		try {
			User entity = repository.getReferenceById(id);
			copyDToToEntity(dto, entity);
			entity = repository.save(entity);
			return new UserDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundException("Resource not found");
		}
	}

	private void copyDToToEntity(UserDTO dto, User entity) {
		entity.setName(dto.getName());
		entity.setUsername(dto.getUsername());
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());
		entity.setTelephone(dto.getTelephone());
	}
}
