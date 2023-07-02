package com.rms.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.daos.OrdersDao;
import com.rms.dtos.OrdersDTO;
import com.rms.entities.Orders;
import com.rms.utils.DtoEntityConverter;

@Service
public class OrdersServiceImpl {
	
	@Autowired
	private OrdersDao ordersDao;
	@Autowired
	private DtoEntityConverter converter;
	
	public Map<String, Object> addOrder(OrdersDTO orderDTO){
		Orders orders = ordersDao.save(converter.toOrderEntity(orderDTO));
		return Collections.singletonMap("orderId", orders.getOrderId());
	}
	
	public Map<String, Object> updateOrderStatus(Integer id, OrdersDTO ordersDTO){
		Orders orders = ordersDao.findByOrderId(id);
		orders.setOrderStatus(ordersDTO.getOrderStatus());
		orders = ordersDao.save(orders);
		return Collections.singletonMap("orderId", orders.getOrderId());
	}
	
	public List<OrdersDTO> getOrderByStatus(String status){
		List<Orders> orderList = ordersDao.findByOrderStatus(status);
		List<OrdersDTO> ordersDTO = new ArrayList<OrdersDTO>();
		for(Orders orders : orderList) {
			ordersDTO.add(converter.toOrderDTO(orders));	
		}
		return ordersDTO;
	}
	
	public OrdersDTO getOrderById(Integer tableId) {
		Orders orders = ordersDao.findByOrderTable_TableIdAndOrderStatus(tableId, "pending");
		return converter.toOrderDTO(orders);
	}
}
