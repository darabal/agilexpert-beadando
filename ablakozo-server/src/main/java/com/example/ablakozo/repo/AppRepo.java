package com.example.ablakozo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ablakozo.model.Application;

@Repository
public interface AppRepo extends JpaRepository<Application, Long>{
	List<Application> findByUserId(Long userId);
}
