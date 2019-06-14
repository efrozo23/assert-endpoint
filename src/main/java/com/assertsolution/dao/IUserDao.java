package com.assertsolution.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assertsolution.model.User;

@Service
public interface IUserDao {
	List<User> getAllUser();
	
	User saveUser(User u);
}
