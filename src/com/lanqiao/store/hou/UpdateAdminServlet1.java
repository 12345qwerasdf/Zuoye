package com.lanqiao.store.hou;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lanqiao.store.model.User;


/**
 * Servlet implementation class UpdateAdminServlet1
 */
@WebServlet("/updateadmin1")
public class UpdateAdminServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdminServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u_id1 =request.getParameter("u_id");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","scott","admin");
			String sql = "select * from TB_USER where u_id=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			psmt.setObject(1, u_id1);
			 ResultSet rs=  psmt.executeQuery();
			 
			 if(rs.next()){
				
					int  u_id = rs.getInt(1);
					String username = rs.getString(2);
					String sex = rs.getString(3);
					String password   = rs.getString(4);
					String phone   = rs.getString(5);
					String address   = rs.getString(6);
					
					
					User user = new User();
					user.setId(u_id);
					user.setUsername(username);
					user.setSex(sex);
					user.setPassword(password);
					user.setPhone(phone);
					user.setAddress(address);
					
				
					request.setAttribute("user", user);
					
					
					request.getRequestDispatcher("updateadmin001.jsp").forward(request, response);
			 }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
