package com.rms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rms.dtos.BillDTO;
import com.rms.services.BillServiceImpl;
import com.rms.utils.ResponseUtil;

@CrossOrigin
@RestController
@RequestMapping("/bill")
public class BillControllerImpl {
	
	@Autowired
	private BillServiceImpl serviceImpl;
	
	@GetMapping("")
	public ResponseEntity<?> getAllBill(){
		return ResponseUtil.success(serviceImpl.findAllBill());
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getBillById(@PathVariable("id") Integer id){
		return ResponseUtil.success(serviceImpl.getBillById(id));
	}
	@GetMapping("/data")
	public ResponseEntity<?> getBillData(){
		System.out.println("Bill Data");
		return ResponseUtil.success(serviceImpl.getAmountData());
	}
	@PostMapping("")
	public ResponseEntity<?> addBill(@RequestBody BillDTO billDTO){
		return ResponseUtil.success(serviceImpl.addBill(billDTO));
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateBill(@PathVariable("id") Integer id,@RequestBody BillDTO billDTO){
		return ResponseUtil.success(serviceImpl.updateBill(id, billDTO));	
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBill(@PathVariable("id") Integer id){
		return ResponseUtil.success(serviceImpl.deleteBillById(id));
	}
}
