package com.example.ablakozo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ablakozo.model.Application;
import com.example.ablakozo.model.User;
import com.example.ablakozo.service.implementation.AppServiceImplementation;
import com.example.ablakozo.service.implementation.UserServiceImplementation;

@RestController
@RequestMapping("/api")
public class AblakozoController {
	
	@Autowired
	private AppServiceImplementation appService;
	@Autowired
	private UserServiceImplementation userService;
	
	
	@GetMapping("user/all")
	public @ResponseBody List<User> getUserAll(){
		return userService.getAllUser(50);
	}
	
	@GetMapping("user={id}")
	public @ResponseBody User getUser(@PathVariable("id") Long id) {
		return userService.getUser(id);
	}
	
	@GetMapping("user={userId}/apps")
	public @ResponseBody List<Application> getAppAllByUserId(@PathVariable("userId") Long userId) {
		return appService.getAllAppByUserId(userId);
	}
	
	@PostMapping("user={userId}/add")
	public String addUser(@PathVariable Long userId, @RequestBody User user) {
		user.setAddedBy(userId);
		userService.createUser(user);
		return "New User added";
	}
	
	@PostMapping("user={userId}/apps/add")
	public String addApplication(@PathVariable Long userId, @RequestBody Application app) {
		app.setUser(userService.getUser(userId));
		appService.createApp(app);
		return "Application added";
	}
	
	@PutMapping("user={userId}/edit")
    public User editUserById(@RequestBody User user, @PathVariable Long userId){
		User editedUser = userService.getUser(userId);
		editedUser.setName(user.getName());
		editedUser.setTheme(user.getTheme());
		editedUser.setBackgroundUrl(user.getBackgroundUrl());
		return userService.editUser(editedUser);
    }
	
	@PutMapping("app={appId}/edit")
    public Application editUserById(@RequestBody Application app, @PathVariable Long appId){
		Application editedApp = appService.getApp(appId);
		if(app.getAppName() != null) {
			editedApp.setAppName(app.getAppName());
		} else if (app.getAppName() != null) {
			editedApp.setAppUrl(app.getAppUrl());
		} else if (app.getStatus() != null) {
			editedApp.setStatus(app.getStatus());
		}
		return appService.editApp(editedApp);
    }
	
	@DeleteMapping("user={userId}/delete")
	public String deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
		return "User deleted";
	}
	
	@DeleteMapping("app={appId}/delete")
	public String deleteApp(@PathVariable Long appId) {
		appService.deleteApp(appId);
		return "App deleted";
	}
	

	
	
}
