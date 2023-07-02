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

import com.rms.dtos.TablesDTO;
import com.rms.services.TableServiceImpl;
import com.rms.utils.ResponseUtil;

@RestController
@RequestMapping("/tables")
@CrossOrigin
public class TablesControllerImpl {
	
	@Autowired
	private TableServiceImpl serviceImpl;
	
	@GetMapping("")
	public ResponseEntity<?> getAllTables(){
		return ResponseUtil.success(serviceImpl.getAllTables());
	}
	@GetMapping("/active")
	public ResponseEntity<?> getAllTablesByStatus(){
		return ResponseUtil.success(serviceImpl.getAllTablesByStatus());
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getTableByWaiterId(@PathVariable("id") Integer id){
		return ResponseUtil.success(serviceImpl.getTablesByWaiter(id));	
	}
	@PostMapping("")
	public ResponseEntity<?> addTable(@RequestBody TablesDTO tablesDTO){
		System.out.println(tablesDTO);
		return ResponseUtil.success(serviceImpl.addTable(tablesDTO));
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateTable(@PathVariable("id") Integer id,@RequestBody TablesDTO tablesDTO){
		return ResponseUtil.success(serviceImpl.updateTable(id, tablesDTO));	
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTable(@PathVariable("id") Integer id){
		return ResponseUtil.success(serviceImpl.deleteTableById(id));	
	}
	@PutMapping("/assign/{id}")
	public ResponseEntity<?> assignWaiter(@RequestBody TablesDTO tablesDTO, @PathVariable("id") Integer id){
		return ResponseUtil.success(serviceImpl.assignTableWaiter(id, tablesDTO));
	}
}
