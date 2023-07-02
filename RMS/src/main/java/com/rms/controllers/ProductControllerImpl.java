package com.rms.controllers;

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

import com.rms.dtos.ProductDTO;
import com.rms.services.ProductServiceImpl;
import com.rms.utils.ResponseUtil;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductControllerImpl {

	@Autowired
	private ProductServiceImpl serviceImpl;
	
	@GetMapping("")
	public ResponseEntity<?> getAllProducts(){
		return ResponseUtil.success(serviceImpl.getAllProduct());
	}
	@GetMapping("/active")
	public ResponseEntity<?> getAllProductsByStatus(){
		return ResponseUtil.success(serviceImpl.getAllProductByStatus());
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable("id") Integer id){
		return ResponseUtil.success(serviceImpl.getByProductId(id));
	}
	@GetMapping("/byCategory/{id}")
	public ResponseEntity<?> getProductByCatId(@PathVariable("id") Integer id){
		return ResponseUtil.success(serviceImpl.getProductByCat(id));
	}
	@PostMapping("")
	public ResponseEntity<?> addProduct(@RequestBody ProductDTO productDTO){
		System.out.println(productDTO);
		return ResponseUtil.success(serviceImpl.addProduct(productDTO));
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> udpateProduct(@RequestBody ProductDTO productDTO, @PathVariable("id") Integer id){
		return ResponseUtil.success(serviceImpl.updateProduct(id,productDTO));
	}
	@PatchMapping("/{id}")
	public ResponseEntity<?> updateProductStatus(@PathVariable("id") Integer id,@RequestBody ProductDTO productDTO){
		return ResponseUtil.success(serviceImpl.updateProductStatus(productDTO,id));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProductById(@PathVariable("id") int id)
	{
		return ResponseUtil.success(serviceImpl.deleteByProductId(id));
	}
}
