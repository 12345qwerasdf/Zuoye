package com.lanqiao.store.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.lanqiao.store.model.Computer;
import com.lanqiao.store.model.Shopcart;
import com.lanqiao.store.model.User;
import com.lanqiao.store.service.ComputerService;
import com.lanqiao.store.service.ShopcartService;

/**
 * Servlet implementation class ShopcartServlet
 */
@WebServlet("/shopcart")
public class ShopcartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ShopcartService shopcartService = new ShopcartService();
	ComputerService computerService = new ComputerService(); 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopcartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application=request.getSession().getServletContext();
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			user=(User) application.getAttribute("user");
		}
		if (user==null) {
//			System.out.println("未登录");

			String act = request.getParameter("act");//判断从哪进入购物车
		
			switch (act) {
			case "addcart":
				addSession(request,response);
				break;
			case "delete":
				deleteSession(request,response);
				request.getRequestDispatcher("shopcart.jsp").forward(request, response);
				break;
			case "look":
				request.getRequestDispatcher("shopcart.jsp").forward(request, response);
			
				break;
			}
		} else {
			//System.out.println("已登录");
			String act = request.getParameter("act");//判断从哪进入购物车
			//System.out.println(act);
			switch (act) {
			case "addcart":
				addCart(request,response);
				//request.getRequestDispatcher("details").forward(request, response);
				docart(request,response);
				break;
			case "delete":
				deleteCart(request,response);
				docart(request,response);
				break;
			case "look":
				
				docart(request,response);
				break;
			}
		}
		
	/*	
		if("1".equals(state)){
			docart(request,response);
		}else {
			addCart(request,response);
			docart(request,response);
		}*/
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}



	

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cid = request.getParameter("id");
		Computer computer = computerService.findComputerById(cid);
		Shopcart shopcart = null;
		//查computer放入cart
		shopcart.setCname(computer.getCname());
		shopcart.setGif(computer.getGif());
		shopcart.setPrice(computer.getPrice());
		shopcart.setCid(computer.getCid());
		
		
		HttpSession session = request.getSession();
		Map<String, Shopcart> cart = (Map)session.getAttribute("cart");
		
		if (cart==null) {
			cart = new HashMap<String,Shopcart>();
			cart.put(cid, shopcart);
			session.setAttribute("cart", cart);
		} else {
			if (cart.containsKey(cid)) {
				//Shopcart a = cart.get(cid);
				Shopcart shop = cart.get(cid);
				shop.setNum(shop.getNum()+1);			//Shopcart.setNum(shop.getNum()+1);
			} else {
				cart.put(cid, shopcart);
			}
		}
		
		
		
		List<Shopcart> list ;
		
		User user = (User) request.getSession().getAttribute("user");
		
		if (user!=null) {
			int userId = user.getId();
			
			list = shopcartService.findAllShopcart(userId);
		} else {

		}
		
		
		
		
	}
	protected void docart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		User user = (User) request.getSession().getAttribute("user");
		ServletContext application=request.getSession().getServletContext();
		if (user == null) {
			user=(User) application.getAttribute("user");
		}
		int userId = user.getId();
		//System.out.println("userid  "+userId);
		List<Shopcart> list;
		//根据用户名查购物车里商品，并展示
		list = shopcartService.findAllShopcart(userId);
		//System.out.println(list);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("shopcart.jsp").forward(request, response);
		
	}
	protected void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//获取商品ID；
		String cid = request.getParameter("id");
	
		int num = 1;
		
		Map<String,Computer> details = (Map)request.getSession().getAttribute("details");//获取加入购物车的商品信息
		Computer comp = details.get(cid);
		//System.out.println("comp"+comp);
		User user = (User) request.getSession().getAttribute("user");
		ServletContext application=request.getSession().getServletContext();	
		if (user == null) {
			user=(User) application.getAttribute("user");
		}
		int userid = user.getId();
		//System.out.println(userid);
		//根据电脑ID和用户ID来查找商品，没有则添加，有则加1
		Shopcart shopcart = shopcartService.findShopcartByCId(cid,userid);
		//System.out.println("shopcart  "+shopcart);
		if (shopcart==null) {
			System.out.println("购物车无该商品");
			Shopcart cart = new Shopcart() ;
			cart.setCname(comp.getCname());
			cart.setPrice(comp.getPrice());
			cart.setGif(comp.getGif());
			cart.setCid(comp.getCid());
			cart.setNum(num);
			cart.setUserid(userid);
			//System.out.println("cart "+  cart);
			shopcartService.addShopcart(cart);
		} else {
			System.out.println("购物车有该商品");
			int num1 = num + shopcart.getNum();
			int id = shopcart.getCid();
			//System.out.println(" num  "+num1);
			shopcartService.editShopcart(id,num1);
		}
		
	}
	private void deleteCart(HttpServletRequest request, HttpServletResponse response) {
		
		//获取商品ID;
		String idString = request.getParameter("id");
		
		int id = Integer.valueOf(idString);
		List<Integer> list =  new ArrayList<>();
		list.add(id);
		shopcartService.updateStateById(list);
		
	}
	private void addSession(HttpServletRequest request, HttpServletResponse response) {
		String cid = request.getParameter("id");
		Map<String,Computer> details = (Map)request.getSession().getAttribute("details");
		
		Computer comp = details.get(cid);
		HttpSession session  = request.getSession();
		int num = 1;
		Shopcart cart = new Shopcart() ;
		cart.setCname(comp.getCname());
		cart.setPrice(comp.getPrice());
		cart.setGif(comp.getGif());
		cart.setCid(comp.getCid());
		cart.setNum(num);
		//System.out.println(cart);
		Map<String, Shopcart> shopcart = (Map) session.getAttribute("shopcart");
		if (shopcart==null) {
			shopcart = new HashMap<String,Shopcart>();
			shopcart.put(cid, cart );
			session.setAttribute("shopcart", shopcart);
		} else {
			if (shopcart.containsKey(cid)) {
				Shopcart shopcart2 = shopcart.get(cid);//先在session中取出 num+1 
				shopcart2.setNum(shopcart2.getNum()+1);
			} else {
				shopcart.put(cid, cart );
			}
		}
		try {
			request.getRequestDispatcher("shopcart.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private void deleteSession(HttpServletRequest request, HttpServletResponse response) {
		String cid = request.getParameter("id");
		HttpSession session  = request.getSession();
		Map<String, Shopcart> shopcart = (Map) session.getAttribute("shopcart");
		shopcart.remove(cid);
		
		
		
		
		
		
	}

}
