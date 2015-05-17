package com.example.moskva.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




/**
 *@version 1.0 May 12, 2015.
 *@author Moscow209
 */
public class ConnectionUtils {
	private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=UTF-8";
	private static final String USER = "root";
	private static final String PASS = "123456";
	
	public static Connection openConnection(){
		Connection con = null;
		try {
			Class.forName(DRIVER_CLASS);
			con = DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
