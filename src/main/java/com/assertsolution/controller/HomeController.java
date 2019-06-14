package com.assertsolution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assertsolution.dao.IUserDao;
import com.assertsolution.model.User;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired(required=true)
	private IUserDao iuserdao;
	
	@GetMapping("/test")
	public String test() {
		System.out.println("mensaje ok");
		return "Hello word!";
	}
	
	@GetMapping("/listUser")
	public ResponseEntity<List<User>> prueba() {
		System.out.println("prueba");
		try {
			return new ResponseEntity<List<User>>(iuserdao.getAllUser(),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<List<User>>(null,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("save")
	public ResponseEntity<User> saveUser(@RequestBody User u){
		try {
			User user	 = iuserdao.saveUser(u);
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		} catch (Exception e) {

		}
		
		return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
