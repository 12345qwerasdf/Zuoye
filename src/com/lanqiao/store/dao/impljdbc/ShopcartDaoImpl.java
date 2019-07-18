package com.lanqiao.store.dao.impljdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.lanqiao.store.dao.ShopcartDao;

import com.lanqiao.store.model.Shopcart;

import com.lanqiao.store.util.JdbcUtil;

public class ShopcartDaoImpl implements ShopcartDao {
	private final static String driver = "oracle.jdbc.driver.OracleDriver";
	private final static String conn = "jdbc:oracle:thin:@localhost:1521/orcl";
	private final static String name ="scott";
	private final static String password ="admin";
	@Override
	public List<Shopcart> findAllShopcart() {
		List<Shopcart> list = new ArrayList<>();
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(conn, name,password);
			
			String sql = "select s_id, cname, price, num, gif, state, address, u_id, c_id from tb_order where state=1 ";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Shopcart shopcart = new Shopcart();
				shopcart.setId(rs.getInt(1));
				shopcart.setCname(rs.getString(2));
				shopcart.setPrice(rs.getString(3));
				shopcart.setNum(rs.getInt(4));
				shopcart.setGif(rs.getString(5));
				list.add(shopcart);
				
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		
		return list;
	}
	@Override
	public List<Shopcart> findAllShopcart(int userId) {
		/*JdbcUtil jdbc = new JdbcUtil();
		String sql = "select s_id id, cname, price, num, gif, u_id userid , c_id cid from tb_order where state=1 and u_id="+userId+" order by s_id desc";
		System.out.println(sql);
		List<Shopcart> list = new ArrayList<>();
		
		list = jdbc.queryPreparedStatement(sql, null, Shopcart.class);
		return list;*/
		
		List<Shopcart> list = new ArrayList<>();
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(conn, name,password);
			
			String sql = "select s_id id, cname, price, num, gif, u_id userid , c_id cid from tb_order where state=1 and u_id="+userId+" order by s_id desc";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Shopcart shopcart = new Shopcart();
				shopcart.setId(rs.getInt(1));
				shopcart.setCname(rs.getString(2));
				shopcart.setPrice(rs.getString(3));
				shopcart.setNum(rs.getInt(4));
				shopcart.setGif(rs.getString(5));
				shopcart.setUserid(rs.getInt(6));
				shopcart.setCid(rs.getInt(7));
				String priceString = rs.getString(3);
				/*int price = Integer.valueOf(priceString);
				int num = rs.getInt(4);
				int count = num * price;*/
				double price = Double.valueOf(priceString);
				int num = rs.getInt(4);
				double count = num * price;
				shopcart.setCount(count);
				list.add(shopcart);
				
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
		
		
		
		
		
		
		
	}
	@Override
	public Shopcart findShopcartByCId(String cid,int userid) {
		
	/*	JdbcUtil jdbc = new JdbcUtil();
		String sql = "select s_id id, cname, price, num, gif, state, address, u_id userid , c_id cid from tb_order where c_id="+cid;
		List<Shopcart> list = new ArrayList<>();
		list = jdbc.queryPreparedStatement(sql, null, Shopcart.class);
		
		//System.out.println(sql);
		//Shopcart shopcart = (Shopcart) jdbc.queryPreparedStatement(sql, null, Shopcart.class).get(0);
		Shopcart shopcart;
		if (list==null) {
			shopcart=null;
		} else {
			shopcart = list.get(0);
		}String sql ="select s_id id, cname, price, num, gif, u_id userid , c_id cid from tb_order where u_id=?,c_id=?";
		return shopcart;*/
		/*User user = null;

		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(conn, name,password);
			String sql = "select u_id id, username, sex, password, phone, address from tb_user where username=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setObject(1, username);
			ResultSet rs =ps.executeQuery();
			while(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setPassword(rs.getString("password"));
				user.setUsername(rs.getString("username"));
				user.setAddress(rs.getString("address"));
				user.setSex(rs.getString("sex"));
			}
			
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		
		*/
		JdbcUtil jdbc = new JdbcUtil();
		String sql ="select s_id id, cname, price, num, gif, u_id userid , c_id cid from tb_order where state=1 and u_id="+userid+" and c_id="+cid;
		//System.out.println(sql);
		List<Shopcart> list = new ArrayList<>();
		list = jdbc.queryPreparedStatement(sql, null, Shopcart.class);
		Shopcart shopcart;
		System.out.println("list" + list);
		if (list.size()==0) {
			shopcart=null;
		} else {
			shopcart=list.get(0);
		}
		
		return shopcart;
		
		
		
	}
	@Override
	public void addShopcart(Shopcart cart) {
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(conn, name,password);
			String sql ="insert into tb_order(cname, price, num, gif, u_id, c_id) "
					+ "values(?, ?, ?, ?,?, ?) ";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setObject(1, cart.getCname());
			ps.setObject(2, cart.getPrice());
			ps.setObject(3, cart.getNum());
			ps.setObject(4, cart.getGif());
			ps.setObject(5, cart.getUserid());
			ps.setObject(6, cart.getCid());
			ps.execute();
			Boolean boolean1 = ps.getUpdateCount() == 1 ? true:false;
			//System.out.println(boolean1);
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	@Override
	public void editShopcart(int sid,int num1) {
		JdbcUtil jdbc = new JdbcUtil();
		String sql = "update tb_order set num="+num1+ " where c_id =" + sid;
		System.out.println(sql);
		jdbc.updatePreparedStatement(sql,null);
	}
	@Override
	public void updateStateById(List<Integer> list) {
		JdbcUtil jdbc = new JdbcUtil();
		
		for (Integer li : list) {
			String sql = "update tb_order set state="+3+ " where s_id =" +li;
			System.out.println(sql);
			jdbc.updatePreparedStatement(sql,null);
		}
		
		
	}
	@Override
	public Shopcart findOrderbyS_id(String sid) {
		// TODO Auto-generated method stub
		JdbcUtil jdbc = new JdbcUtil();
		String sql="select s_id id,cname,price,num,gif,state,u_id userid,c_id cid from tb_order where s_id="+sid;
		Shopcart shopcart=(Shopcart)jdbc.queryPreparedStatement(sql, null, Shopcart.class).get(0);
		return shopcart ;
		
	}
	@Override
	public void updateStateById2(String [] s) {
     JdbcUtil jdbc = new JdbcUtil();
		
		for (String li : s) {
			String sql = "update tb_order set state="+2+ " where s_id =" +li;
			System.out.println(sql);
			jdbc.updatePreparedStatement(sql,null);
		}
		
		
	}
	@Override
	public void subUpdate(String id) {
		 JdbcUtil jdbc = new JdbcUtil();
		 String sql = "update tb_order set num=num-1 where s_id="+id;
		 System.out.println(sql+"ceshi");
		 jdbc.updatePreparedStatement(sql,null);
	}
	@Override
	public void addUpdate(String id) {
		JdbcUtil jdbc = new JdbcUtil();
		 String sql = "update tb_order set num=num+1 where s_id="+id;
		 System.out.println(sql+"ceshi2");
		 jdbc.updatePreparedStatement(sql,null);
		
	}
	
	

}
