package com.example.moskva.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.moskva.bussine.CartBus;
import com.example.moskva.bussine.ProductBus;
import com.example.moskva.model.CartItem;
import com.example.moskva.model.Product;

/**
 * Servlet implementation class CartController
 */

public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = (String) request.getParameter("action");
		switch (action) {
		case "viewcart":
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("cart.jsp");
			dispatcher.forward(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = (String) request.getParameter("action");
		String id = (String) request.getParameter("id");
		HttpSession session = request.getSession();
		CartBus cart = (CartBus) session.getAttribute("cart");
		PrintWriter out = response.getWriter();
		if (cart == null) {
			cart = new CartBus();
			session.setAttribute("cart", cart);
		}

		switch (action) {
		case "addcart":
			String color = (String) request.getParameter("color");
			String size = (String) request.getParameter("size");
			ProductBus bus = new ProductBus();
			Product product = bus.getProduct(id);
			if (color == null && size == null) {
				color = product.getColor().split(",")[0];
				size = product.getSize().split(",")[0];
			}
			int number = (String) request.getParameter("number") == null ? 1
					: Integer.parseInt((String) request.getParameter("number"));
			CartItem item = cart.initCartItem(product, color, size, number);
			cart.addCart(item);
			out.println("<tr>");
			out.println("<td class=\"c6299\"><img alt=\"IMAGE\" src=\""
					+ item.getImage() + "\"></td>");
			out.println("<td class=\"c6368\"><a href=\"product.html\">"
					+ item.getName() + "</a></td>");
			out.println("<td class=\"c6301\">x&nbsp;" + item.getNumber()
					+ "</td>");
			out.println("<td class=\"c6302\">" + item.getTotal() + " VND</td>");
			out.println("</tr>");
			break;
		case "removecart":
			int index = Integer.parseInt((String) request.getParameter("id"));
			if(index > cart.getNumberDelete())
				index = index - cart.getNumberDelete();
			cart.removeCart(index);
			out.println(cart.getTotalCart());
			break;
		case "updatecart":
			int idex = Integer.parseInt((String) request.getParameter("id"));
			int num = Integer.parseInt((String) request
					.getParameter("quantity"));
			if(idex > cart.getNumberDelete())
				idex = idex - cart.getNumberDelete();
			cart.updateCart(idex, num);
			out.println(cart.getCart().get(idex).getTotal() + "-"
					+ cart.getTotalCart());
			break;
		}

	}

}
