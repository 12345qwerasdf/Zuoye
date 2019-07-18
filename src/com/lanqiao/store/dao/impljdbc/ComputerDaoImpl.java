package com.lanqiao.store.dao.impljdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lanqiao.store.dao.ComputerDao;
import com.lanqiao.store.model.Computer;

import com.lanqiao.store.util.JdbcUtil;

public class ComputerDaoImpl implements ComputerDao {
	private final static String driver = "oracle.jdbc.driver.OracleDriver";
	private final static String conn = "jdbc:oracle:thin:@localhost:1521/orcl";
	private final static String name ="scott";
	private final static String password ="admin";
	@Override
	public List<Computer> findAllComputer() {
		List<Computer> list = new ArrayList<>();
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(conn, name,password);
			
			String sql ="select c_id, sizes, color, cpu, gra, gif, price, inventory, sell, mold, t1.b_id, cname "
					+ "from tb_computer t1,tb_brand t2 where t1.b_id = t2.b_id and gra=1";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Computer computer = new Computer();
			
				computer.setCid(rs.getInt(1));
		
				computer.setColor(rs.getString(3));
				computer.setCpu(rs.getString(4));
				computer.setGra(rs.getString(5));
				computer.setGif(rs.getString(6));
				computer.setPrice(rs.getString(7));
				computer.setInventory(rs.getInt(8));
				computer.setSell(rs.getInt(9));
				computer.setMold(rs.getString(10));
				computer.setBrand(rs.getInt(11));
				computer.setCname(rs.getString(12));
				list.add(computer);
				
				
			}
		
		
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	@Override
	public List<Computer> findComputerByBrand(String brand) {
		List<Computer> list = new ArrayList<>();
		try {
			
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(conn, name,password);
			String sql = "select c_id, sizes, color, cpu, gra, gif, price, inventory, sell, mold, t1.b_id, cname "
					+ "from tb_computer t1,tb_brand t2 where t1.b_id = t2.b_id and gra=1 and bname=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setObject(1, brand);
			ResultSet rs =ps.executeQuery();
			while(rs.next()){
				Computer computer = new Computer();
			
				computer.setCid(rs.getInt(1));
				
				computer.setColor(rs.getString(3));
				computer.setCpu(rs.getString(4));
				computer.setGra(rs.getString(5));
				computer.setGif(rs.getString(6));
				computer.setPrice(rs.getString(7));
				computer.setInventory(rs.getInt(8));
				computer.setSell(rs.getInt(9));
				computer.setMold(rs.getString(10));
				computer.setBrand(rs.getInt(11));
				computer.setCname(rs.getString(12));
				list.add(computer);
				System.out.println(sql);
				System.out.println(computer);
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public Computer findComputerById(String id) {
		JdbcUtil jdbc = new JdbcUtil();
		//String sql = "select t1.c_id,t1.gra, t1.gif, t1.price, t1.inventory, t1.sell,t1.b_id, t1.cname, t2.discount\r\n" + 
		//		"from tb_computer t1,tb_super t2 where t1.c_id=t2.c_id and t1.c_id = "+id;
		String sql = "select c_id  cid, color, cpu, gra, gif, price, inventory, sell, mold, b_id brand, cname from tb_computer where c_id="+id;
		
		Computer computer = (Computer)jdbc.queryPreparedStatement(sql, null, Computer.class).get(0);
		System.out.println(computer);
		return computer;
		
	}
	@Override
	public List<Computer> findComputerArr(String arr) {
		JdbcUtil jdbcUtil = new JdbcUtil();

		Connection conn = jdbcUtil.getConn();
		List<Computer> list = new ArrayList<>();
		String sql ="select * from tb_computer order by "+arr+" desc";
		
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				int C_id = rs.getInt(1);
				String size =rs.getString(2);
				String color =rs.getString(3);
				String cpu =rs.getString(4);
				String gra =rs.getString(5);
				String gif = rs.getString(6);
				String price =rs.getString(7);
				int inventory =rs.getInt(8);
				int sell =rs.getInt(9);
				String mold = rs.getString(10);
				int brand = rs.getInt(11);
				String cname =rs.getString(12);
				
				
				Computer computer = new Computer();
				computer.setCid(C_id);
				
				computer.setColor(color);
				computer.setCpu(cpu);
				computer.setGra(gra);
				computer.setGif(gif);
				computer.setPrice(price);
				computer.setInventory(inventory);
				computer.setSell(sell);
				computer.setMold(mold);
				computer.setBrand(brand);
				computer.setCname(cname);
				list.add(computer);
				System.out.println(computer );
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Computer> findComputerByname(String like) {
		JdbcUtil jdbcUtil = new JdbcUtil();
		Connection conn = jdbcUtil.getConn();
		List<Computer> list = new ArrayList<>();
		String sql ="select * from tb_computer where cname like '%"+like+"%'";
		System.out.println(sql);
	
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			//pstm.setObject(1, like);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				
				
				Computer computer = new Computer();
				computer.setCid(rs.getInt(1));
				
				computer.setColor(rs.getString(3));
				computer.setCpu(rs.getString(4));
				computer.setGra(rs.getString(5));
				computer.setGif(rs.getString(6));
				computer.setPrice(rs.getString(7));
				computer.setInventory(rs.getInt(8));
				computer.setSell(rs.getInt(9));
				computer.setMold(rs.getString(10));
				computer.setBrand(rs.getInt(11));
				computer.setCname(rs.getString(12));
				list.add(computer);
				
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public void update(List params) {
		JdbcUtil jdbcUtil = new JdbcUtil();
		String sql="update tb_computer set inventory=?,sell=? where c_id=?";
		jdbcUtil.updatePreparedStatement(sql, params);
		
	}

	

}
