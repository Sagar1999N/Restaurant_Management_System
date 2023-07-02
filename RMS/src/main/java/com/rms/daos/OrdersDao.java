package com.rms.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rms.entities.Orders;

@Repository
public interface OrdersDao extends JpaRepository<Orders, Integer> {
	Orders findByOrderId(int id);
	Orders findByOrderTable_TableIdAndOrderStatus(int id,String status);
	List<Orders> findByOrderStatus(String status);
}
