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

import com.lanqiao.store.model.Computer;



/**
 * Servlet implementation class toupdate
 */
@WebServlet("/toupdate")
public class ToUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String c_id1 =request.getParameter("c_id");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","scott","admin");
			String sql = "select * from tb_computer where c_id=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			psmt.setObject(1, c_id1);
			 ResultSet rs=  psmt.executeQuery();
			 
			 if(rs.next()){
				
					int  c_id = rs.getInt(1);
					String sizes = rs.getString(2);
					String color = rs.getString(3);
					String cpu   = rs.getString(4);
					String gra   = rs.getString(5);
					String gif   = rs.getString(6);
					String price   = rs.getString(7);
					int invebtory = rs.getInt(8);
					int sell    = rs.getInt(9);
					String mold  = rs.getString(10);
					String cname = rs.getString(12);
					int b_id     = rs.getInt(11);
					
					Computer computer = new Computer();
					computer.setCid(c_id);
					
					computer.setColor(color);
					computer.setCpu(cpu);
					computer.setGra(gra);				
					computer.setPrice(price);
					computer.setInventory(invebtory);
					computer.setSell(sell);
					computer.setMold(mold);
					computer.setBrand(b_id);
					computer.setCname(cname);
				
					request.setAttribute("computer", computer);
					
					
					request.getRequestDispatcher("update.jsp").forward(request, response);
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
