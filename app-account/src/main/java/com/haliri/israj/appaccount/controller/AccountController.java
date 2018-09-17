package com.haliri.israj.appaccount.controller;

import com.haliri.israj.appaccount.service.UserService;
import com.haliri.israj.appcommon.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public List<User> save() {
		return userService.find();
	}

	@PostMapping("/save")
	public void save(@RequestBody User user) {
		userService.save(user);
	}
}
