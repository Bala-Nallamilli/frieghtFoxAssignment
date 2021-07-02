package com.FrieghtFox.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FrieghtFox.Entities.User;
import com.FrieghtFox.Service.UserService;

@RestController
public class MeetingsController {
	
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping(path = "/adduser")
	public User saveUser(@RequestBody User user) {
		return this.userService.addUser(user);
	}
	
	@PutMapping(path="/update_usr/{userId}/{status}")
	public User updateuser(@PathVariable Long userId,@PathVariable Integer status) {
		return userService.updateStatus(userId, status);
	}
	
	
	
	

}
