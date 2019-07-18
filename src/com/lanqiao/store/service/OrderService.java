package com.lanqiao.store.service;

import java.util.List;

import com.lanqiao.store.dao.OrderDao;
import com.lanqiao.store.dao.impljdbc.OrderDaoImpl;
import com.lanqiao.store.model.Order;

public class OrderService {
	OrderDao orderdao=new OrderDaoImpl();
	public void addOrder(Order order) {
		orderdao.addOrder(order);
		
		
	}
	public void updateOrder(String orderNum){
		orderdao.updateOrder(orderNum);
		}
	public List<Order> selectAllOrder(String id) {
		return orderdao.selectAllOrder(id);
	}
	
}
