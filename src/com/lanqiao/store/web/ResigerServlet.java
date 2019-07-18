package com.lanqiao.store.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lanqiao.store.model.User;
import com.lanqiao.store.service.UserService;

/**
 * Servlet implementation class ResigerServlet
 */
@WebServlet("/register")
public class ResigerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResigerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		User user = new User();
		UserService userService =new UserService();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		user = userService.findUserByName(username);
		if(user!=null){
			response.getWriter().println("<script>alert('账号已存在，请换个信息注册');window.location.href='register.jsp'</script>");
			
		}else{
			user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setSex(sex);
			user.setPhone(phone);
			user.setAddress(address);
		
		userService.addNewUser(user);
		response.getWriter().println("<script>alert('注册成功');window.location.href='login.jsp'</script>");
		/*response.getWriter().println("<script>alert('注册成功')</script>");
		response.sendRedirect("login.jsp");*/
		
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
