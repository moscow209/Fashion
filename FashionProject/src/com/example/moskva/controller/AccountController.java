package com.example.moskva.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.moskva.bussine.AccountBus;
import com.example.moskva.dao.AccountDAO;
import com.example.moskva.model.User;

/**
 * Servlet implementation class AccountController
 */

public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String action = (String)request.getParameter("action");
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		User user = (User)session.getAttribute("user");
		AccountBus bus = new AccountBus();
		if("changepassword".equals(action)){
			String oldPass = (String)request.getParameter("oldpassword");
			String newPass = (String)request.getParameter("newpassword");
			String confirm = (String)request.getParameter("confirmpassword");
			if(oldPass == "" || newPass == "" || confirm == ""){
				request.setAttribute("failed", "* Bạn đã bỏ trống trường nào đó không nhập!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
				dispatcher.forward(request, response);
			}
			else{
				if(!confirm.equals(newPass)){
					request.setAttribute("failed", "* Hai mật khẩu nhập vào không trùng nhau!");
					RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
					dispatcher.forward(request, response);
				}
				else{
					if(oldPass.equals(user.getPassword())){
						bus.changePassword(username, newPass);
						request.setAttribute("information", "Đã đổi mật khẩu thành công!");
						RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
						dispatcher.forward(request, response);
					}
					else{
						request.setAttribute("failed", "* Mật khẩu cũ không đúng!");
						RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
						dispatcher.forward(request, response);
					}
				}
			}
			
		}
		else{
			String email = (String)request.getParameter("email");
			AccountDAO dao = new AccountDAO();
			User check = dao.getUser(email);
			if(check != null && !(check.getUserName().equalsIgnoreCase(user.getUserName()))){
				request.setAttribute("fail", "Email đã tồn tại trong hệ thống!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
				dispatcher.forward(request, response);
			}
			else{
				user.setBirthday((String)request.getParameter("birthday"));
				user.setSex((String)request.getParameter("sex"));
				user.setEmail(email);
				user.setPhone((String)request.getParameter("phone"));
				user.setAddress((String)request.getParameter("address"));
				bus.changeUser(user);
				request.setAttribute("information", "Đã đổi thông tin tài khoản thành công!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
				dispatcher.forward(request, response);
			}
			
		}
	}
}
