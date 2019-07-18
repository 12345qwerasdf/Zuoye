package com.lanqiao.store.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lanqiao.store.service.ShopcartService;

/**
 * Servlet implementation class ShopCartUpdateServlet
 */
@WebServlet("/shopupdate")
public class ShopCartUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopCartUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String var = request.getParameter("var");
		String id = request.getParameter("id");
		switch(var){
		case "sub":
			subUpdate(id,request,response);
			break;
		case "add":
			addUpdate(id,request,response);
			break;
		}
	}

	private void subUpdate(String id,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShopcartService shopservice=new ShopcartService();
		shopservice.subUpdate(id);
		request.getRequestDispatcher("shopcart?act=look").forward(request, response);
		
	}
	private void addUpdate(String id,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShopcartService shopservice=new ShopcartService();
		shopservice.addUpdate(id);
		request.getRequestDispatcher("shopcart?act=look").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
