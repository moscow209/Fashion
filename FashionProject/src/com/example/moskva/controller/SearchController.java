package com.example.moskva.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.moskva.bussine.ProductBus;
import com.example.moskva.model.Product;

/**
 * Servlet implementation class SearchController
 */

public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final int RECORDS_PER_PAGE = 8;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = (String)request.getParameter("type");
		String keyword = (String)request.getParameter("keyword");
		int page = 1;
		if(request.getParameter("page") != null){
			page = Integer.parseInt((String)request.getParameter("page"));
		}
		ProductBus bus = new ProductBus();
		List<Product> list = bus.search(type, keyword);
		int noOfRecords = list.size();
		if(noOfRecords == 0){
			request.setAttribute("failed", "failed");
			RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
			dispatcher.forward(request, response);
		}
		else{
			int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / RECORDS_PER_PAGE);
			request.setAttribute("productList", list);
			request.setAttribute("noOfPages", noOfPages);
			request.setAttribute("currentPage", page);
			request.setAttribute("url", "&keyword=" + keyword + "&type=" + type);
			RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
