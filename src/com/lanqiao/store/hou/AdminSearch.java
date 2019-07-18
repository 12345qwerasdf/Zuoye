package com.lanqiao.store.hou;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lanqiao.store.model.User;


/**
 * Servlet implementation class AdminSearch
 */
@WebServlet("/adminsearch")
public class AdminSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int pz=3;//每页信息数
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","scott","admin");
			int cp=1;//当前需要展示的页码
			String currentPage = request.getParameter("cp");
			if(currentPage!=null){
				cp=Integer.parseInt(currentPage);				
			}
			
			
			
				
					String sql="select * from ("
							+ "select rownum num ,t1.* from ("
							+ "select * from tb_user c  order by u_id )t1 "
							+ "where rownum<="+cp*pz+") "
							+ "where num>"+(cp-1)*pz;
				
				
			
			//System.out.println(sql);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			List users = new ArrayList();
			while(rs.next()){
				int  u_id = rs.getInt(2);
				String username = rs.getString(3);
				String sex = rs.getString(4);
				String password   = rs.getString(5);
				String phone   = rs.getString(6);
				String address   = rs.getString(7);
				
				
				User user = new User();
				user.setId(u_id);
				user.setUsername(username);
				user.setSex(sex);
				user.setPassword(password);
				user.setPhone(phone);
				user.setAddress(address);
			
				users.add(user);
			}
			
			request.setAttribute("cp", cp);
	
			request.setAttribute("users", users);
			request.getRequestDispatcher("Admin-role.jsp").forward(request, response);
		}catch (Exception e) {
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
