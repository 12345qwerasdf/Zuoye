package com.lanqiao.store.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.lanqiao.store.model.Computer;
import com.lanqiao.store.service.BuyTodayService;


/**
 * Servlet implementation class BuyTodayServlet
 */
@WebServlet("/buytoday")
public class BuyTodayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyTodayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BuyTodayService buyTodayService = new BuyTodayService(); 
		int cp = 1;
		String currentPage = request.getParameter("cp");
		//System.out.println("dds");
		if (currentPage!=null) {
			cp = Integer.valueOf(currentPage);
			//cp = Integer.parseInt(currentPage);
		} 
		List<Computer> list = buyTodayService.findAllComputer(cp);
		//System.out.println(list);
		int totalPage = buyTodayService.getTotalPage();
		//System.out.println(cp+"  "+totalPage);
	//	List<Computer> list2 = btd.getSellCount();
		request.setAttribute("cp", cp);
		
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("Computer", list);
		//得到团购销量榜的前三个
		List<Computer> listRank = buyTodayService.findListRank();
		request.setAttribute("ListRank", listRank);
	//	request.setAttribute("sellCount", list2);
		request.getRequestDispatcher("buytoday.jsp").forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
