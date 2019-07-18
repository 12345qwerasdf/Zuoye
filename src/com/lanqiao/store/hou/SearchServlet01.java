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

import com.lanqiao.store.model.Computer;

/**
 * Servlet implementation class SearchServlet01
 */
@WebServlet("/search01")
public class SearchServlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int pz=3;//每页信息数
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String cid = request.getParameter("cid");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","scott","admin");
			int cp=1;//当前需要展示的页码
			String currentPage = request.getParameter("cp");
			if(currentPage!=null){
				cp=Integer.parseInt(currentPage);				
			}
			String sql="";
			System.out.println(cid);
			
				if(cid==null||cid==""){
					 sql="select * from ("
							+ "select rownum num ,t1.* from ("
							+ "select * from TB_COMPUTER c  order by c_id )t1 "
							+ "where rownum<="+cp*pz+") "
							+ "where num>"+(cp-1)*pz;
				}else{
				 sql="select * from ("
						+ "select rownum num ,t1.* from ("
						+ "select * from TB_COMPUTER c  order by c_id )t1 "
						+ "where rownum<="+cp*pz+") "
						+ "where num>"+(cp-1)*pz +"and c_id="+cid;
				
			
				}
				
			
			//System.out.println(sql);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			List computers = new ArrayList();
			while(rs.next()){
				
				
               /* computer.setCid(rs.getInt(1));
				
				computer.setColor(rs.getString(3));
				computer.setCpu(rs.getString(4));
				computer.setGra(rs.getString(5));
				computer.setGif(rs.getString(6));
				computer.setPrice(rs.getString(7));
				computer.setInventory(rs.getInt(8));
				computer.setSell(rs.getInt(9));
				computer.setMold(rs.getString(10));
				computer.setBrand(rs.getInt(11));
				computer.setCname(rs.getString(12));
				*/
				
				int  c_id = rs.getInt(2);
				String sizes = rs.getString(3);
				String color = rs.getString(4);
				String cpu   = rs.getString(5);
				String gra   = rs.getString(6);
				String gif   = rs.getString(7);
				String  price   = rs.getString(8);
				int invebtory = rs.getInt(9);
				int sell    = rs.getInt(10);
				String mold  = rs.getString(11);
				String cname = rs.getString(13);
				int b_id     = rs.getInt(12);
				
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
				computers.add(computer);
			}
			
			request.setAttribute("cp", cp);
	
			request.setAttribute("computers", computers);
			request.getRequestDispatcher("Product-list.jsp").forward(request, response);
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
