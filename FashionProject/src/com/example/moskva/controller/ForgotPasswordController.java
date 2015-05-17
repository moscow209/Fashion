package com.example.moskva.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.moskva.bussine.AccountBus;
import com.example.moskva.bussine.SendMail;
import com.example.moskva.dao.AccountDAO;
import com.example.moskva.model.User;

/**
 * Servlet implementation class ForgotPassword
 */

public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("forgot-password.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = (String)request.getParameter("email");
		AccountBus bus = new AccountBus();
		if(bus.forgotPassword(email)){
			request.setAttribute("information", "Mật khẩu đã đươc gửi vào e-mail!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		else{
			request.setAttribute("failed", "failed");
			RequestDispatcher dispatcher = request.getRequestDispatcher("forgot-password.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
