package com.lanqiao.store.dao;

import java.util.List;

import com.lanqiao.store.model.Computer;

public interface BuyTodayDao {

	List<Computer> findAllComputer(int cp);

	int getTotalPage();

	List<Computer> findListRank();

}
