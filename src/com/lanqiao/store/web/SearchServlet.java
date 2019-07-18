package com.lanqiao.store.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.el.fmt.RequestEncodingTag;

import com.lanqiao.store.model.Computer;
import com.lanqiao.store.service.ComputerService;
import com.lanqiao.store.service.UserService;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
		String brand = request.getParameter("brand");
		//System.out.println(brand);
		String arr =request.getParameter("arr");
		String like = request.getParameter("title");
		
		
		List<Computer> list ;
		if (brand==null) {
			list = computerService.findAllComputer();
		} else {
			
			list = computerService.findComputerByBrand(brand);
			//System.out.println(list);
		}
		if(arr!=null){
			list = computerService.findComputerArr(arr);
		}
		if(like != null){
			list = computerService.findComputerByname(like);
		}
//		
//		for (Computer computer : list) {
//			System.out.println(computer);
//		}
		request.setAttribute("list", list);
		//System.out.println(list);
		request.getRequestDispatcher("main.jsp").forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
