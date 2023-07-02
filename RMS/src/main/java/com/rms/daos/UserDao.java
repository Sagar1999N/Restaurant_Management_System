package com.rms.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rms.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByUserId(int id);
	List<User> findByRoleAndCurrentStatus(String role,String status);
	List<User> findByCurrentStatus(String status);
	User findByEmail(String email);
}
