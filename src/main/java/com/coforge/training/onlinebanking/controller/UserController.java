package com.coforge.training.onlinebanking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.training.onlinebanking.model.User;
import com.coforge.training.onlinebanking.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor

public class UserController {
	 private final UserService userService;
	 
	 	

	    /**
	 * @param userService
	 */
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

		@PostMapping("/register")
	    public ResponseEntity<?> register(@RequestBody User user) {
	        return ResponseEntity.ok(userService.register(user));
	    }

	    @GetMapping("/user/{username}")
	    public ResponseEntity<?> getByUsername(@PathVariable String username) {
	        return ResponseEntity.ok(userService.findByUsername(username));
	    }
}
