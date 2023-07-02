package com.rms.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rms.entities.Tables;

public interface TablesDao extends JpaRepository<Tables, Integer> {
	List<Tables> findByWaiter_UserId(int waiterId);
	List<Tables> findByTableStatus(String status);
	Tables findByTableId(int tableId);
}
