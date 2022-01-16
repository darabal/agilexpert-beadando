package com.example.ablakozo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ablakozo.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
}
