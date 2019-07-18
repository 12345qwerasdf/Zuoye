package com.lanqiao.store.dao.impljdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lanqiao.store.dao.OrderDao;
import com.lanqiao.store.model.Order;
import com.lanqiao.store.util.JdbcUtil;
import com.lanqiao.store.util.JdbcUtils;

public class OrderDaoImpl implements OrderDao{
	private final static String driver = "oracle.jdbc.driver.OracleDriver";
	private final static String conn = "jdbc:oracle:thin:@localhost:1521/orcl";
	private final static String name ="scott";
	private final static String password ="admin";
   JdbcUtil jd=new JdbcUtil();
	@Override
	public void addOrder(Order order) {
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(conn, name,password);
			String sql ="insert into tb_order2(orderNum,u_id ,totalmoney,address,status) "
					+ "values(?, ?, ?, ?,?) ";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setObject(1, order.getOrdernum());
			ps.setObject(2, order.getU_id());
			ps.setObject(3, order.getTotalmoney());
			ps.setObject(4, order.getAddress());
			ps.setObject(5, order.getStatus());
		
			ps.execute();
			
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	}
	@Override
	public void updateOrder(String orderNum) {
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(conn, name,password);
			String sql="update tb_order2 set status=2 where orderNum =?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setObject(1, orderNum);
			ps.execute();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<Order> selectAllOrder(String id) {
		JdbcUtil jdbcUtil = new JdbcUtil();
		String sql="select ordernum, u_id , totalmoney, address, status from tb_order2 where u_id="+id;
	   /* List<Order> orders=JdbcUtils.query(sql,Order.class,null);*/
		List<Order> orders=jdbcUtil.queryPreparedStatement(sql, null, Order.class);
	   
		return orders;
		
	}
	/*public static void main(String[] args) {
		 OrderDao oo=new OrderDaoImpl();
		 oo.selectAllOrder();
	}
	*/

}
