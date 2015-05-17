package com.example.moskva.bussine;

import com.example.moskva.dao.AccountDAO;
import com.example.moskva.model.User;

/**
 * @version 1.0 May 12, 2015.
 * @author Moscow209
 */
public class AccountBus {
	private AccountDAO dao;
	
	public AccountBus(){
		dao = new AccountDAO();
	}
	
	public boolean checkLogin(String username, String password) {
		if(username == null || password == null)
			return false;
		User user = dao.getUser(username, password);
		if(user != null && user.getUserName().equalsIgnoreCase(username)){
			return true;
		}
		return false;
	}
	
	public boolean checkExists(String username, String email){
		User user1 = dao.getUserName(username);
		User user2 = dao.getUser(email);
		if(user1 == null && user2 == null)
			return true;
		return false;
	}
	
	public boolean forgotPassword(String email){
		if(email == null)
			return false;
		User user = dao.getUser(email);
		if(user != null){
			SendMail.sendPassword(email, user);
			return true;
		}
		return false;
	}
	
	public void insert(User user){
		dao.insert(user);
	}
	
	public User getUserName(String usename){
		return dao.getUserName(usename);
	}
	
	public void changePassword(String username, String password){
		dao.updatePassword(username, password);
	}
	
	public void changeUser(User user){
		dao.updateUser(user);
	}

	public AccountDAO getDao() {
		return dao;
	}
	
}
