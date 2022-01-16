package com.example.ablakozo.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.ablakozo.model.User;
import com.example.ablakozo.repo.UserRepo;
import com.example.ablakozo.service.UserService;

@Service
public class UserServiceImplementation implements UserService{
	public final UserRepo repo;

	@Autowired
	public UserServiceImplementation(UserRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public User createUser(User user) {
		return repo.save(user);
	}

	@Override
	public User getUser(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public User editUser(User user) {
		return repo.save(user);
	}

	@Override
	public Boolean deleteUser(Long id) {
		repo.deleteById(id);
		return true;
	}

	@Override
	public List<User> getAllUser(int limit) {
		return repo.findAll(PageRequest.of(0, limit)).toList();
	}
	
	
}
