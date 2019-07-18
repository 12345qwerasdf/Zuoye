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



@WebServlet("/login1")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
	    String password = request.getParameter("password"); 
	    System.out.println(username +"  "+password);
	    try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","scott","admin");
			PreparedStatement psmt = conn.prepareStatement("select * from tab_user where username=? and password=?");			
			psmt.setObject(1, username);			
			psmt.setObject(2, password);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()){
				 System.out.println("11");
//				Integer U_id = rs.getInt(1);
				String name = rs.getString(1);
//				String sex  = rs.getString(3);
				String pass = rs.getString(2);
				User user = new User();
//				user.setU_id(U_id);
				user.setUsername(name);
//				user.setSex(sex);
				user.setPassword(pass);
				request.getSession().setAttribute("user", user);					
				request.getRequestDispatcher("Index1.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("default.jsp").forward(request, response);	
			}
			
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}

