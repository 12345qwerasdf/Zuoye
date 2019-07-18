package com.lanqiao.store.hou;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class productddservlet
 */
@WebServlet("/productadd")
public class productddservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productddservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			
			
			String c_id = request.getParameter("c_id");
			String sizes = request.getParameter("sizes");
			String color = request.getParameter("color");
			String cpu = request.getParameter("cpu");
			String gra = request.getParameter("gra");
			String price = request.getParameter("price");
			String invebtory = request.getParameter("invebtory");
			String sell = request.getParameter("sell");
			String mold = request.getParameter("mold");
			String cname = request.getParameter("cname");
			String b_id = request.getParameter("b_id");
			String img= "res/static/img/huawei.jpg";
			
			String sql="insert into tb_compute"
					+ "r(c_id, sizes, color, cpu, gra, gif, price, inventory, sell, mold, cname, b_id)"
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","scott","admin");
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			psmt.setObject(1, c_id);
			psmt.setObject(2, sizes);
			psmt.setObject(3, color);
			psmt.setObject(4, cpu);
			psmt.setObject(5, gra);
			psmt.setObject(6, img);
			psmt.setObject(7, price);
			psmt.setObject(8, invebtory);
			psmt.setObject(9, sell);
			psmt.setObject(10, mold);
			psmt.setObject(11, cname);
			psmt.setObject(12, b_id);
			
			psmt.execute();
			
			request.getRequestDispatcher("search01").forward(request, response);
			 
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
