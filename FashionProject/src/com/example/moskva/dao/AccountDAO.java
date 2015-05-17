package com.example.moskva.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.moskva.model.User;

/**
 * @version 1.0 May 12, 2015.
 * @author Moscow209
 */
public class AccountDAO {

	public User getUser(String username, String password) {
		Connection con = ConnectionUtils.openConnection();
		User user = null;
		try {
			PreparedStatement pre = con
					.prepareStatement("select* from users where username =  ? and password = ?");
			pre.setString(1, username);
			pre.setString(2, password);
			ResultSet result = pre.executeQuery();
			if (result.next()) {
				user = new User();
				user.setUserName(result.getString(1));
				user.setPassword(result.getString(2));
				user.setBirthday(result.getString(3));
				user.setSex(result.getString(4));
				user.setEmail(result.getString(5));
				user.setPhone(result.getString(6));
				user.setAddress(result.getString(7));
			}
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return user;
	}
	
	public User getUser(String email) {
		Connection con = ConnectionUtils.openConnection();
		User user = null;
		try {
			PreparedStatement pre = con
					.prepareStatement("select* from users where email =  ?");
			pre.setString(1, email);
			ResultSet result = pre.executeQuery();
			if (result.next()) {
				user = new User();
				user.setUserName(result.getString(1));
				user.setPassword(result.getString(2));
			}
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return user;
	}
	
	public User getUserName(String usename) {
		Connection con = ConnectionUtils.openConnection();
		User user = null;
		try {
			PreparedStatement pre = con
					.prepareStatement("select* from users where username =  ?");
			pre.setString(1, usename);
			ResultSet result = pre.executeQuery();
			if (result.next()) {
				user = new User();
				user.setUserName(result.getString(1));
				user.setPassword(result.getString(2));
				user.setBirthday(result.getString(3));
				user.setSex(result.getString(4));
				user.setEmail(result.getString(5));
				user.setPhone(result.getString(6));
				user.setAddress(result.getString(7));
			}
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return user;
	}

	public void insert(User user) {
		Connection con = ConnectionUtils.openConnection();
		try {
			PreparedStatement pre = con
					.prepareStatement("insert into users values(?, ?, ?, ?, ?, ?, ?)");
			pre.setString(1, user.getUserName());
			pre.setString(2, user.getPassword());
			pre.setString(3, user.getBirthday());
			pre.setString(4, user.getSex());
			pre.setString(5, user.getEmail());
			pre.setString(6, user.getPhone());
			pre.setString(7, user.getAddress());
			pre.execute();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void updatePassword(String username, String password) {
		Connection con = ConnectionUtils.openConnection();
		try {
			PreparedStatement pre = con
					.prepareStatement("update users set password = ? where username = ?");
			pre.setString(1, password);
			pre.setString(2, username);
			pre.execute();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void updateUser(User user) {
		Connection con = ConnectionUtils.openConnection();
		try {
			PreparedStatement pre = con
					.prepareStatement("update users set birthday = ?, sex = ?, email = ?, phone = ?, address = ? where username = ?");
			pre.setString(1, user.getBirthday());
			pre.setString(2, user.getSex());
			pre.setString(3, user.getEmail());
			pre.setString(4, user.getPhone());
			pre.setString(5, user.getAddress());
			pre.setString(6, user.getUserName());
			pre.execute();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
