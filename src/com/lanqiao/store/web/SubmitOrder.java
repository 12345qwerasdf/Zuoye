package com.lanqiao.store.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lanqiao.store.dao.ShopcartDao;
import com.lanqiao.store.dao.impljdbc.ShopcartDaoImpl;
import com.lanqiao.store.model.User;

/**
 * Servlet implementation class SubmitOrder
 */
@WebServlet("/submitorder")
public class SubmitOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");	
	String [] s= (String[]) request.getSession().getAttribute("split");
	ShopcartDao sd=new ShopcartDaoImpl();
	//更新购物车信息
    User user=(User)request.getSession().getAttribute("user");
    ServletContext application=request.getSession().getServletContext();
	if (user == null) {
		user=(User) application.getAttribute("user");
	}
    int userid=user.getId();
	List list = sd.findAllShopcart(userid);
	
	sd.updateStateById2(s);
	String totalmoney=request.getParameter("total");
	request.setAttribute("WIDsubject", "电脑");
	request.setAttribute("WIDbody", "电子产品");
	request.setAttribute("totalmoney", totalmoney);
	request.getRequestDispatcher("dingdan/index.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
