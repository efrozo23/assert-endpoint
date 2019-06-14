package com.assertsolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assertsolution.model.User;

public interface UserRepository  extends JpaRepository<User, Long>{

}
