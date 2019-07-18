package com.lanqiao.store.web;

import java.io.IOException;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lanqiao.store.model.Shopcart;
import com.lanqiao.store.model.User;
import com.lanqiao.store.service.ShopcartService;
import com.lanqiao.store.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserService userService = new UserService();
		User user = userService.findUserByName(username);
		//System.out.println(username);
		
		
		
		if(user == null ){
			HttpSession session = request.getSession();
			session.setAttribute("user", null);
			response.getWriter().println("<script>alert('用户不存在，请先注册');window.location.href='login.jsp'</script>");
			/*response.getWriter().println("<script>alert('用户不存在，请先注册');</script>");
			request.getRequestDispatcher("login.jsp").forward(request, response);*/
		}
		else {
			if (password.equals(user.getPassword())) {
				ShopcartService shopcartService = new ShopcartService();
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				ServletContext application=request.getSession().getServletContext();
				
				application.setAttribute("user", user);
				session.getAttribute("shopcart");
				Map<String, Shopcart> shopcart = (Map) session.getAttribute("shopcart");
				if (shopcart!=null) {
					Set<String> cidSet = shopcart.keySet();
					for (String cid : cidSet) {
						int num = 1;
						Shopcart shopcart1 = shopcartService.findShopcartByCId(cid,user.getId());
						if (shopcart1==null) {
							Shopcart cart = shopcart.get(cid);
							cart.setCid(Integer.valueOf(cid));
							cart.setNum(num);
							cart.setUserid(user.getId());
							shopcartService.addShopcart(cart);
						} else {
							num =shopcart.get(cid).getNum() +shopcart1.getNum();
							shopcartService.editShopcart(Integer.valueOf(cid),num);
						}
						
					}
				}
				
				
				session.removeAttribute("shopcart");
				request.getRequestDispatcher("search").forward(request, response);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("user", null);
				response.getWriter().println("<script>alert('密码错误');window.location.href='login.jsp'</script>");
			}
			
		}
	}

}
