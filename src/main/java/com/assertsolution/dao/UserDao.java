package com.assertsolution.dao;

import java.util.List;
import java.util.Random;
import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assertsolution.model.User;
import com.assertsolution.repository.UserRepository;
import com.assertsolution.start.AssertSolutionApplication;

@Repository
public class UserDao implements IUserDao {

	@Autowired
	private UserRepository uRepository;

	@Override
	public List<User> getAllUser() {

		try {
			for (int i = 0; i < 10; i++) {
				User u1 = new User();
				u1.setId(new Random().nextLong());
				u1.setName("user " + i);
				u1.setLastname("ape " + 1);
				uRepository.save(u1);
			}

			return uRepository.findAll();
		} catch (Exception e) {
			AssertSolutionApplication.logger.log(Level.SEVERE, "error ", e);
		}
		return null;
	}

	@Override
	public User saveUser(User u) {
		try {
			return uRepository.save(u);
		} catch (Exception e) {
			AssertSolutionApplication.logger.log(Level.SEVERE, "error ", e);
		}
		return null;
	}

}
