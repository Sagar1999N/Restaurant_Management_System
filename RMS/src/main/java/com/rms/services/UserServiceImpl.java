package com.rms.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rms.daos.UserDao;
import com.rms.dtos.Credential;
import com.rms.dtos.UserDTO;
import com.rms.dtos.UserDTOSend;
import com.rms.entities.User;
import com.rms.utils.DtoEntityConverter;

@Service
public class UserServiceImpl {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private DtoEntityConverter converter;
	
	public Map<String, Object> addUser(UserDTO userDTO){
		User dbUser = userDao.findByEmail(userDTO.getEmail());
		if(dbUser == null) {
			String encPassword = passwordEncoder.encode(userDTO.getPassword());
			userDTO.setPassword(encPassword);
			User user = converter.toUserEntity(userDTO);
			user.setDate(Date.valueOf(java.time.LocalDate.now()));
			user = userDao.save(user);
			return Collections.singletonMap("insertedId", user.getUserId());
		}
		return null;
	}
	
	public Map<String, Object> updateUser(Integer id, UserDTO userDTO){
		if(userDTO.getPassword()!=null)
		{
			String encPassword = passwordEncoder.encode(userDTO.getPassword());
			userDTO.setPassword(encPassword);
		}
		User users = userDao.findByUserId(id);
		users.setName(userDTO.getName());
		users.setEmail(userDTO.getEmail());
		if(userDTO.getPassword()!=null)
		users.setPassword(userDTO.getPassword());
		users.setPhone(userDTO.getPhone());
		if(userDTO.getRole()!=null)
		users.setRole(userDTO.getRole());
		
		users = userDao.save(users);
		return Collections.singletonMap("UpdatedID", users.getUserId());
	}
	
	public Map<String, Object> updateUserStatus(int id, UserDTO userdto) {
		User users = userDao.findByUserId(id);
		users.setCurrentStatus(userdto.getCurrentStatus());
		users = userDao.save(users);
		return Collections.singletonMap("UpdatedID", users.getUserId());
		
	}
	
	public List<UserDTOSend> getAllUser(){
		List<User> users = userDao.findAll();
		List<UserDTOSend> sendList = new ArrayList<UserDTOSend>();
		for(User user : users) {
			sendList.add(converter.toUserDTO(user));
		}
		return sendList;
	}
	
	public List<UserDTOSend> getAllUserByStatus(){
		List<User> users = userDao.findByCurrentStatus("Enabled");
		List<UserDTOSend> userDTOs = new ArrayList<UserDTOSend>();
		for(User user : users) {
			userDTOs.add(converter.toUserDTO(user));
		}
		return userDTOs;
	}
	
	public List<UserDTOSend> getAllWaiter(String role){
		List<User> users = userDao.findByRoleAndCurrentStatus(role,"Enabled");
		List<UserDTOSend> userDTOs = new ArrayList<>();
		for(User user : users) {
			userDTOs.add(converter.toUserDTO(user));
		}
		return userDTOs;
	}
	
	public UserDTOSend getUserById(Integer id) {
		User user = userDao.findByUserId(id);
		return converter.toUserDTO(user);
	}
	
	public UserDTOSend findUserByEmailAndPassword(Credential cred) {
		User dbUser = userDao.findByEmail(cred.getEmail());
		String rawPassword = cred.getPassword();
		if(dbUser != null && passwordEncoder.matches(rawPassword, dbUser.getPassword())) {
			UserDTOSend result = converter.toUserDTO(dbUser);

			return result;
		}
		return null;
	}
	
	public Integer deleteUserById(Integer id) {
		if(userDao.existsById(id)) {
			userDao.deleteById(id);
			return 1;
		}
		return 0;
	}
}
