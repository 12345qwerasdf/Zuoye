package com.lanqiao.store.dao.impljdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lanqiao.store.dao.UserDao;
import com.lanqiao.store.model.User;
import com.lanqiao.store.util.JdbcUtils;

public class UserDaoImpl implements UserDao {
	private final static String driver = "oracle.jdbc.driver.OracleDriver";
	private final static String conn = "jdbc:oracle:thin:@localhost:1521/orcl";
	private final static String name ="scott";
	private final static String password ="admin";
	@Override
	public User findUserByName(String username) {
		User user = null;

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
					user.setPhone(rs.getString("phone"));
					user.setSex(rs.getString("sex"));
				}
				
				
				
				
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return user;
			
		
		
		
	}
	public static void main(String[] args) {
		String username="admin";
		//String sql = "select u_d id, username, sex, password, phone, address from tb_user where username=?";
		String sql1="update tb_user set username= 'admin1' where u_id = '1'";
		int row = JdbcUtils.update(sql1);
		System.out.println(row);
		
	
	}
	@Override
	public void addNewUser(User user) {
		String sql ="insert into tb_user( username, sex, password, phone, address)values(?,?,?,?,?)";
	     
	    
	   
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(conn, name,password);

			PreparedStatement psmt = connection.prepareStatement(sql);
		
			psmt.setObject(1, user.getUsername());
			psmt.setObject(2, user.getSex());
			psmt.setObject(3, user.getPassword());
			
			psmt.setObject(4,user.getPhone());
			
			psmt.setObject(5,user.getAddress());
		
			psmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
		
		
	}
	

}
