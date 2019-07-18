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
 * Servlet implementation class UpdateAdminServlet2
 */
@WebServlet("/UpdateAdminServlet2")
public class UpdateAdminServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdminServlet2() {
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
			
			
			String sql="update tb_user set username = ?,sex = ?, password = ?,phone = ?,address = ?where u_id = ?";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","scott","admin");
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			psmt.setObject(1, username);
			psmt.setObject(2, sex);
			psmt.setObject(3, password);
			psmt.setObject(4, phone);
			psmt.setObject(5, address);
			psmt.setObject(6, u_id);
		
			psmt.execute();
			
			response.sendRedirect("adminsearch");
			
			 
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
