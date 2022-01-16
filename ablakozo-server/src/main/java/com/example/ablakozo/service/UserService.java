package com.example.ablakozo.service;

import java.util.List;
import com.example.ablakozo.model.User;

public interface UserService {
	User createUser(User user);
	User getUser(Long id);
	User editUser(User user);
	Boolean deleteUser(Long id);
	List<User> getAllUser(int limit);
}