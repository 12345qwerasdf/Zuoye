package com.lanqiao.store.hou;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adminadds
 */
@WebServlet("/adminadds")
public class adminadds extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminadds() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {
			
			
			
			String u_id = request.getParameter("u_id");
			String username = request.getParameter("username");
			String sex = request.getParameter("sex");
			String password = request.getParameter("password");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			
			
			String sql="insert into tb_user(u_id, username, sex, password, phone, address)values(?, ?, ?, ?, ?, ?)";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","scott","admin");
			PreparedStatement psmt1 = conn.prepareStatement(sql);
			
			psmt1.setObject(1, u_id);
			psmt1.setObject(2, username);
			psmt1.setObject(3, sex);
			psmt1.setObject(4, password);
			psmt1.setObject(5, phone);			
			psmt1.setObject(6, address);
			
			psmt1.execute();
			
			request.getRequestDispatcher("adminsearch").forward(request, response);
			 
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
