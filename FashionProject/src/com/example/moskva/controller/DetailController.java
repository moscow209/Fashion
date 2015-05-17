package com.example.moskva.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.moskva.bussine.ProductBus;
import com.example.moskva.model.Product;

/**
 * Servlet implementation class DetailController
 */

public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = (String)request.getParameter("id");
		ProductBus bus = new ProductBus();
		Product product = bus.getProduct(id);
		String zoomImg = product.getImage().substring(0, product.getImage().length() - 8) + ".jpg";
		String[] color = product.getColor().split(",");
		String[] size = product.getSize().split(",");
		request.setAttribute("product", product);
		request.setAttribute("zoomImage", zoomImg);
		request.setAttribute("color", color);
		request.setAttribute("size", size);
		RequestDispatcher dispatcher = request.getRequestDispatcher("detail.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
