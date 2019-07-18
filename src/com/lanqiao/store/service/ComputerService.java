package com.lanqiao.store.service;

import java.util.List;

import com.lanqiao.store.dao.ComputerDao;
import com.lanqiao.store.dao.impljdbc.ComputerDaoImpl;
import com.lanqiao.store.model.Computer;
import com.lanqiao.store.model.Shopcart;

public class ComputerService {
	ComputerDao computerDao = new ComputerDaoImpl();

	public List<Computer> findAllComputer() {
		// TODO Auto-generated method stub
		return computerDao.findAllComputer();
	}

	public List<Computer> findComputerByBrand(String brand) {
		// TODO Auto-generated method stub
		return computerDao.findComputerByBrand(brand);
	}

	public Computer findComputerById(String id) {
		// TODO Auto-generated method stub
		return computerDao.findComputerById(id);
	}

	public List<Computer> findComputerArr(String arr) {
		// TODO Auto-generated method stub
		return computerDao.findComputerArr(arr);
	}

	public List<Computer> findComputerByname(String like) {
		// TODO Auto-generated method stub
		return computerDao.findComputerByname(like);
	}
	public void update(List params) {
		computerDao.update(params);
	}
	
}
