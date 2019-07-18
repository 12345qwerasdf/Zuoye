package com.lanqiao.store.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lanqiao.store.model.Computer;
import com.lanqiao.store.service.ComputerService;





/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/details")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("id");
		String price = request.getParameter("price");
		//System.out.println(cid);
		ComputerService computerService = new ComputerService();
		Computer item = computerService.findComputerById(cid);
		//System.out.println("item"+ item);
		if (price!=null) {
			item.setPrice(price);
		}
		request.setAttribute("item", item);
		
		
		HttpSession session = request.getSession();
		Map<String,Computer> details = (Map)session.getAttribute("details");
		if(details==null){
			details = new HashMap<String,Computer>();
			details.put(cid, item);
			session.setAttribute("details", details);
		}else{
			details.put(cid, item);
		}
		request.getRequestDispatcher("details.jsp").forward(request, response);
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
