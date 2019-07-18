package com.lanqiao.store.dao;

import java.util.List;

import com.lanqiao.store.model.Computer;
import com.lanqiao.store.model.Shopcart;

public interface ComputerDao {

	public List<Computer> findAllComputer();

	public List<Computer> findComputerByBrand(String brand);

	public Computer findComputerById(String id);

	public List<Computer> findComputerArr(String arr);

	public List<Computer> findComputerByname(String like);
    public void update(List params); 
	
	
}
