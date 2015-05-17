package com.example.moskva.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.moskva.bussine.AccountBus;
import com.example.moskva.model.User;

/**
 * Servlet implementation class Register
 */

public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String username = (String)request.getParameter("username");
		String password = (String)request.getParameter("password");
		String confirmPassword = (String)request.getParameter("confirmPassword");
		String birthday = (String)request.getParameter("birthday");
		String sex = (String)request.getParameter("sex");
		String email = (String)request.getParameter("email");
		String phone = (String)request.getParameter("phone");
		String address = (String)request.getParameter("address");
		if(username == "" || password == "" || birthday == "" || confirmPassword == ""
				|| sex == "" || email == "" || phone == "" || address == "" ){
			request.setAttribute("failed", "* Bạn đã bỏ trống trường nào đó không nhâp!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);
		}
		else{
			User user = new User();
			AccountBus bus = new AccountBus();
			user.setUserName(username);
			user.setPassword(password);
			user.setBirthday(birthday);
			user.setSex(sex);
			user.setEmail(email);
			user.setPhone(phone);
			user.setAddress(address);
			if(!password.equals(confirmPassword)){
				request.setAttribute("failed", "* Hai mật khẩu nhập vào không trùng nhau!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
				dispatcher.forward(request, response);
			}
			else{
				if(bus.checkExists(user.getUserName(), user.getEmail())){
					bus.insert(user);
					request.setAttribute("information", "Đăng kí thành công! Hãy đăng nhập!");
					RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
					dispatcher.forward(request, response);
				}
				else{
					request.setAttribute("failed", "* Tên đăng nhập hoặc email đã tồn tại!");
					RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
					dispatcher.forward(request, response);
				}
			}
			
		}
		
	}

}
