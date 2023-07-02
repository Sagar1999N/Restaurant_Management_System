package com.rms.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.daos.OrderItemDao;
import com.rms.daos.ProductDao;
import com.rms.dtos.OrderItemDTO;
import com.rms.entities.OrderItem;
import com.rms.utils.DtoEntityConverter;

@Service
public class OrderItemServiceImpl {
	@Autowired
	private OrderItemDao orderItemDao;
	@Autowired
	private DtoEntityConverter converter;
	@Autowired
	private ProductDao pDao;

	public Map<String, Object> addOrderItem(OrderItemDTO orderItemDTO){
		OrderItem orderItem = converter.toOrderItemEntity(orderItemDTO);
		float price = pDao.findByProductId(orderItemDTO.getOrderItemProductId()).getProductPrice();
		orderItem.setOrderItemAmount(price*orderItemDTO.getOrderItemQuantity());
		orderItem = orderItemDao.save(orderItem);
		return Collections.singletonMap("InsertedId", orderItem.getOrderItemId());
	}
	
	public Map<String, Object> updateOrderItem(Integer id, OrderItemDTO orderItemDTO){
		OrderItem item = orderItemDao.findByOrderItemId(id);
		if(orderItemDTO.getOrderItemQuantity()!=0)
		{
		item.setOrderItemQuantity(orderItemDTO.getOrderItemQuantity());
		float price=pDao.findByProductId(item.getOrderItemProduct().getProductId()).getProductPrice();
		item.setOrderItemAmount(price*orderItemDTO.getOrderItemQuantity());
		item=orderItemDao.save(item);
		}
		return Collections.singletonMap("updatedId", item.getOrderItemId());
	}
	
	public List<OrderItemDTO> getOrderItemByOrder(Integer orderId){
		List<OrderItem> orderItems = orderItemDao.findByOrderItemOrder_OrderId(orderId);
		List<OrderItemDTO> itemDTOS = new ArrayList<OrderItemDTO>();
		for(OrderItem orderItem : orderItems) {
			itemDTOS.add(converter.toOrderItemDTO(orderItem));
		}
		return itemDTOS;
	}
	
	public int deleteItemByItemId(int id) {
		// TODO Auto-generated method stub
		if(orderItemDao.existsById(id))
		{
			orderItemDao.deleteById(id);
			return 1;
		}	
		return 0;
	}
}
