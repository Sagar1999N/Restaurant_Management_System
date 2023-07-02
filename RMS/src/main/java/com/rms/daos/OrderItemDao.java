package com.rms.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rms.entities.OrderItem;

@Repository
public interface OrderItemDao extends JpaRepository<OrderItem, Integer> {
	List<OrderItem> findByOrderItemOrder_OrderId(Integer id);
	OrderItem findByOrderItemId(Integer id);
}
