package com.rms.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rms.dtos.Credential;
import com.rms.dtos.UserDTO;
import com.rms.dtos.UserDTOSend;
import com.rms.services.UserServiceImpl;
import com.rms.utils.ResponseUtil;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserControllerImpl {
	
	@Autowired
	private UserServiceImpl serviceImpl;
	
	@GetMapping("")
	public ResponseEntity<?> getAllUser(){
		return ResponseUtil.success(serviceImpl.getAllUser());
	}
	@GetMapping("/active")
	public ResponseEntity<?> getAllUserByStatus(){
		return ResponseUtil.success(serviceImpl.getAllUserByStatus());
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") Integer id){
		return ResponseUtil.success(serviceImpl.getUserById(id));
	}
	@GetMapping("/role/{role}")
	public ResponseEntity<?> getUsersByRole(@PathVariable("role") String role){
		return ResponseUtil.success(serviceImpl.getAllWaiter(role));
	}
	@PostMapping("")
	public ResponseEntity<?> addUser(@RequestBody UserDTO userDTO){
		System.out.println(userDTO);
		Map<String, Object> uData = serviceImpl.addUser(userDTO);
		if(uData!=null)
			return ResponseUtil.success(uData);
		return ResponseUtil.success("Email Already Exists");
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO,@PathVariable("id") Integer id){
		return ResponseUtil.success(serviceImpl.updateUser(id, userDTO));
	}
	@PatchMapping("/{id}")
	public ResponseEntity<?> updateUserStatus(@RequestBody UserDTO userDTO, @PathVariable("id") Integer id){
		return ResponseUtil.success(serviceImpl.updateUserStatus(id, userDTO));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable("id") Integer id){
		return ResponseUtil.success(serviceImpl.deleteUserById(id));
	}
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody Credential credential){
		System.out.println(credential);
		UserDTOSend dtoSend = serviceImpl.findUserByEmailAndPassword(credential);
		if(dtoSend!=null) {
			if(dtoSend.getCurrentStatus().equals("Enabled")) {
				return ResponseUtil.success(dtoSend);
			}
			return ResponseUtil.error("User is Disabled");
		}
		return ResponseUtil.error("User Not Found");	
	}
}
