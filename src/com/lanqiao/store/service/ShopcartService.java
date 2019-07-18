package com.lanqiao.store.service;

import java.util.List;

import com.lanqiao.store.dao.ShopcartDao;
import com.lanqiao.store.dao.impljdbc.ShopcartDaoImpl;
import com.lanqiao.store.model.Shopcart;

public class ShopcartService {
	ShopcartDao shopcartDao = new ShopcartDaoImpl();

	public List<Shopcart> findAllShopcart() {
		// TODO Auto-generated method stub
		return shopcartDao.findAllShopcart();
	}

	public List<Shopcart> findAllShopcart(int userId) {
		// TODO Auto-generated method stub
		return shopcartDao.findAllShopcart(userId);
	}

	public Shopcart findShopcartByCId(String cid, int userid) {
		// TODO Auto-generated method stub
		return shopcartDao.findShopcartByCId(cid,userid);
	}

	public void addShopcart(Shopcart cart) {
		shopcartDao.addShopcart(cart);
		
	}

	public void editShopcart(int sid, int num1) {
		shopcartDao.editShopcart(sid,num1);
		
	}

	public void updateStateById(List<Integer> list) {
		shopcartDao.updateStateById(list);
		
	}
	public void updateStateById2(String [] s) {
		shopcartDao.updateStateById2(s);
		
	}
	

	public Shopcart findOrderbyS_id(String sid) {
		// TODO Auto-generated method stub
		return shopcartDao.findOrderbyS_id(sid);
	}
	public void subUpdate(String id) {
		shopcartDao.subUpdate(id);
	}
	public void addUpdate(String id) {
		shopcartDao.addUpdate(id);
	}
}
