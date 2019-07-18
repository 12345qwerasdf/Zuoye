package com.lanqiao.store.service;

import java.util.List;

import com.lanqiao.store.dao.BuyTodayDao;
import com.lanqiao.store.dao.impljdbc.BuyTodayDaoImpl;
import com.lanqiao.store.model.Computer;

public class BuyTodayService {
	BuyTodayDao buyTodayDao = new BuyTodayDaoImpl();
	public List<Computer> findAllComputer(int cp) {
		// TODO Auto-generated method stub
		return buyTodayDao.findAllComputer(cp);
	}
	public int getTotalPage() {
		// TODO Auto-generated method stub
		return buyTodayDao.getTotalPage();
	}
	public List<Computer> findListRank() {
		// TODO Auto-generated method stub
		List<Computer> list = buyTodayDao.findListRank();
		return list.subList(0, 3);
	}
	

}
