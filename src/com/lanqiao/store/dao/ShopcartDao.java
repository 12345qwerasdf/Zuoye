package com.lanqiao.store.dao;

import java.util.List;

import com.lanqiao.store.model.Shopcart;

public interface ShopcartDao {

	List<Shopcart> findAllShopcart();

	List<Shopcart> findAllShopcart(int userId);

	Shopcart findShopcartByCId(String cid, int userid);

	void addShopcart(Shopcart cart);

	void editShopcart(int sid, int num1);

	void updateStateById(List<Integer> list);
	void updateStateById2(String [] s);
	Shopcart findOrderbyS_id(String sid);
	void subUpdate(String id);
	void addUpdate(String id);
}
