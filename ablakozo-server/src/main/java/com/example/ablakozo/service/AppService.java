package com.example.ablakozo.service;

import java.util.List;

import com.example.ablakozo.model.Application;

public interface AppService {
	Application createApp(Application app);
	Application editApp(Application app);
	Boolean deleteApp(Long id);
	Application getApp(Long id);
	List<Application> getAllApp(int limit);
	List<Application> getAllAppByUserId(Long id);
	
}
