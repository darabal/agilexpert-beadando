package com.example.ablakozo.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.ablakozo.model.Application;
import com.example.ablakozo.repo.AppRepo;
import com.example.ablakozo.service.AppService;

@Service
public class AppServiceImplementation implements AppService{

	private final AppRepo repo;
	
	
	@Override
	public List<Application> getAllAppByUserId(Long userId) {
		return repo.findByUserId(userId);
	}

	@Autowired
	public AppServiceImplementation(AppRepo repo) {
		super();
		this.repo = repo;
	}
	
	@Override
	public Application getApp(Long id) {
		return repo.getById(id);
	}

	@Override
	public Application createApp(Application app) {
		return repo.save(app);
	}

	@Override
	public Application editApp(Application app) {
		return repo.save(app);
	}

	@Override
	public Boolean deleteApp(Long id) {
		repo.deleteById(id);
		return true;
	}

	@Override
	public List<Application> getAllApp(int limit) {
		return repo.findAll(PageRequest.of(0, limit)).toList();
	}
	
	
}
