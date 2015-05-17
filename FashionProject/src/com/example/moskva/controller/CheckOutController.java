package com.example.moskva.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.moskva.bussine.AccountBus;
import com.example.moskva.bussine.CartBus;
import com.example.moskva.bussine.CheckOutBus;
import com.example.moskva.bussine.SendMail;
import com.example.moskva.model.Bill;
import com.example.moskva.model.User;

/**
 * Servlet implementation class CheckOutController
 */

public class CheckOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOutController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("checkout.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		User user = (User)session.getAttribute("user");
		if(username == null){
			response.sendRedirect("login.jsp");
		}
		else{
			String name = (String)request.getParameter("name");
			String address = (String)request.getParameter("address");
			String phone = (String)request.getParameter("phone");
			if(name == "" || address == "" || phone == ""){
				request.setAttribute("failed", "* Bạn đã bỏ trống trường nào đó không nhâp!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("checkout.jsp");
				dispatcher.forward(request, response);
			}
			else{
				SimpleDateFormat format = new SimpleDateFormat("ddmmyyyyhhmmss");
				String id = "HD" + format.format(new Date()).toString().toUpperCase();
				CartBus cart = (CartBus)session.getAttribute("cart");
				Bill bill = initBill(id, address, name, phone, username, cart.getTotalCart());
				CheckOutBus.checkOut(bill, cart.getCart(), user.getEmail());
				session.removeAttribute("cart");
				response.sendRedirect("success-bill.jsp");
			}
			
		}	
	}
	
	private Bill initBill(String id, String address, String name, String phone, String username, double total){
		Bill bill = new Bill();
		bill.setId(id);
		bill.setAddress(address);
		bill.setDate(new Date());
		bill.setName(name);
		bill.setPhone(phone);
		bill.setUsername(username);
		bill.setTotal(total);
		return bill;
	}

}
