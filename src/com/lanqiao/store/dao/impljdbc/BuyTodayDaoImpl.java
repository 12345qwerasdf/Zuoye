package com.lanqiao.store.dao.impljdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lanqiao.store.dao.BuyTodayDao;
import com.lanqiao.store.model.Computer;

public class BuyTodayDaoImpl implements BuyTodayDao {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String username = "scott";//用户名
	private static final String password = "admin";//密码
	private int pz = 4;
	@Override
	public List<Computer> findAllComputer(int cp) {
		List<Computer> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement st = conn.createStatement();
			String sql = "select * from "
					+ "(select rownum num ,t1.* from "
					+ "(select comp.c_id,gif,price,sell,cname,discount from tb_computer comp , tb_super sup where comp.c_id=sup.c_id) t1 "
					+ "where rownum<="+pz*cp+") "
					+ "where num>" +pz*(cp-1);
			System.err.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Computer computer = new Computer();
				computer.setCid(rs.getInt("c_id"));
				computer.setGif(rs.getString("gif"));
				computer.setPrice(rs.getString("price"));
				computer.setSell(rs.getInt("sell"));
				computer.setCname(rs.getString("cname"));
				computer.setDiscount(rs.getInt("discount"));
				System.out.println(computer);
				list.add(computer);				
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int getTotalPage() {
		int totalPage=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement st = conn.createStatement();
			String sql = "select count(*) from Tb_computer t1,tb_super t3 where  t1.c_id = t3.c_id" ;
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				totalPage = rs.getInt(1);
				
			}
			return totalPage%4==0?totalPage/4:totalPage/4+1 ;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public List<Computer> findListRank() {
		List<Computer> list = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement st = conn.createStatement();
			String sql = "select c_id,gra, gif, price, inventory, sell, mold, b_id, cname "
					+ "from tb_computer order by sell desc ";
			System.err.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Computer computer = new Computer();
				computer.setCid(rs.getInt("c_id"));
				computer.setGif(rs.getString("gif"));
				computer.setPrice(rs.getString("price"));
				computer.setSell(rs.getInt("sell"));
				computer.setCname(rs.getString("cname"));
//				computer.setDiscount(rs.getInt("discount"));
				System.out.println(computer);
				list.add(computer);				
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
