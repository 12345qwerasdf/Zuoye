package com.lanqiao.store.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lanqiao.store.dao.ShopcartDao;
import com.lanqiao.store.dao.impljdbc.ShopcartDaoImpl;
import com.lanqiao.store.model.Order;
import com.lanqiao.store.model.Shopcart;
import com.lanqiao.store.model.User;
import com.lanqiao.store.service.OrderService;
import com.lanqiao.store.service.ShopcartService;
import com.lanqiao.store.util.GenerateNum;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		ServletContext application=request.getSession().getServletContext();
		User user = (User) request.getSession().getAttribute("user");
		/*User user = (User) request.getAttribute("user");*/
		if (user == null) {
			user=(User) application.getAttribute("user");
		}
		if (user == null) {
			
			response.getWriter().println("<script>alert('请去登录');window.location.href='login.jsp'</script>");
			//response.sendRedirect("login.jsp");
		} else {
			List list1=new ArrayList();
			String zhi=request.getParameter("zhi");
			String[] split = zhi.split(",");
			request.getSession().setAttribute("split", split);
			for (int i = 0; i < split.length; i++) {
			String string = split[i];
		    //int  sid=Integer.parseInt(string);
			ShopcartDao sd=new ShopcartDaoImpl();
			ShopcartService shopservice=new ShopcartService();
			
			Shopcart shopcart= shopservice.findOrderbyS_id(string);
			list1.add(shopcart);
			
			}
			String orderNum=GenerateNum.getOrderCode();
			String totalmoney=request.getParameter("to");
			//System.out.println(totalmoney+"元");
			//User user=(User) request.getSession().getAttribute("user");
			String address=user.getAddress();
			int uid=user.getId();
			//list.add(orderNum);   list.add(uid); list.add(totalmoney);list.add(address);;list.add(1);
			Order order=new Order(orderNum,uid,totalmoney,address,1);
			OrderService orderservice=new OrderService();
			orderservice.addOrder(order);
			//User user=(User)request.getSession().getAttribute("user");
			/*request.getSession().setAttribute("orderNum", orderNum);*/
			//ServletContext application=request.getSession().getServletContext();
			application.setAttribute("orderNum", orderNum);
			//request.setAttribute("user", user);
			request.setAttribute("list1", list1);
			application.setAttribute("list1", list1);
	        request.getRequestDispatcher("dingdan/order.jsp").forward(request, response);
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
