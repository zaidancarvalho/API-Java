package com.criandoapi.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.criandoapi.projeto.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
