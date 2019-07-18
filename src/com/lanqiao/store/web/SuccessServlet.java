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

import com.lanqiao.store.model.Computer;
import com.lanqiao.store.model.Order;
import com.lanqiao.store.model.Shopcart;
import com.lanqiao.store.service.ComputerService;
import com.lanqiao.store.service.OrderService;

/**
 * Servlet implementation class SuccessServlet
 */
@WebServlet("/success")
public class SuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuccessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ComputerService computerService = new ComputerService();
		/*List<Computer>list = computerService.findAllComputer();
		request.setAttribute("list", list);*/
		ServletContext application=request.getSession().getServletContext();
		String orderNum=(String)application.getAttribute("orderNum");
		List<Shopcart> list1=(List)application.getAttribute("list1");
		for(Shopcart shopcart : list1){
			int num=shopcart.getNum();
			int cid=shopcart.getCid();
			Computer computer=	computerService.findComputerById(cid+"");
			int inventory=computer.getInventory();
			int sell=computer.getSell();
			inventory=inventory-num;
			sell=sell+num;
			List params=new ArrayList();
			params.add(inventory);
			params.add(sell);
			params.add(cid);
			
			computerService.update(params);
		}
	    OrderService orderservice=new OrderService();
	    orderservice.updateOrder(orderNum);
	    //application.removeAttribute("list1");
	    //	    response.sendRedirect("search");
		
	    /*List<Order> orders=orderservice.selectAllOrder();
	    request.setAttribute("orders", orders);
	    request.getRequestDispatcher("showOrder.jsp").forward(request, response);*/
	  /*  request.getRequestDispatcher("search").forward(request, response);*/
	    response.sendRedirect("search");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
