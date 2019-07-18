package com.lanqiao.store.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lanqiao.store.model.Order;
import com.lanqiao.store.model.User;
import com.lanqiao.store.service.OrderService;

/**
 * Servlet implementation class ShowOrder
 */
@WebServlet("/showorder")
public class ShowOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		User user= (User)request.getSession().getAttribute("user");
		ServletContext application=request.getSession().getServletContext();
		if (user == null) {
			user=(User) application.getAttribute("user");
		}
		if(user == null) {
			response.getWriter().println("<script>alert('请先登录');window.location.href='login.jsp'</script>");
		}
		
		
	     String id=user.getId()+"";
		
		/*String id= request.getParameter("id");*/
		OrderService orderservice=new OrderService();	
		 List<Order> orders=orderservice.selectAllOrder(id);
		 request.setAttribute("orders", orders);
		 request.getRequestDispatcher("dingdan/showOrder.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
