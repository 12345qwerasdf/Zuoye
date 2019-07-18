package com.lanqiao.store.dao;

import java.util.List;

import com.lanqiao.store.model.Order;

public interface OrderDao {

	
	public void addOrder(Order order);
	public void updateOrder(String orderNum);
	public List<Order> selectAllOrder(String id);
}
