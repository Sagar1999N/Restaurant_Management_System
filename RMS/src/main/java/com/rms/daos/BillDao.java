package com.rms.daos;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rms.entities.Bill;

@Repository
public interface BillDao extends JpaRepository<Bill, Integer>{
	Bill findByBillId(Integer id);
	List<Bill> findByBillDateAndBillStatus(Date date, String status);
}
