package com.example.moskva.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.moskva.model.Bill;

/**
 *@version 1.0 May 15, 2015.
 *@author Moscow209
 */
public class BillDAO {
	public void insertBill(Bill bill){
		Connection con = ConnectionUtils.openConnection();
		try {
			PreparedStatement pre = con.prepareStatement("insert into bill values(?, ?, ?, ?, ?, ?, ?)");
			pre.setString(1, bill.getId());
			pre.setString(2, bill.getUsername());
			pre.setDate(3, new Date(bill.getDate().getTime()));
			pre.setString(4, bill.getName());
			pre.setString(5, bill.getAddress());
			pre.setString(6, bill.getPhone());
			pre.setDouble(7, bill.getTotal());
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
	
	public List<Bill> getBill(String username){
		Connection con = ConnectionUtils.openConnection();
		List<Bill> list = new ArrayList<Bill>();
		try {
			PreparedStatement pre = con.prepareStatement("select* from bill where username_bill = ?");
			pre.setString(1, username);
			ResultSet result = pre.executeQuery();
			Bill bill = null;
			while(result.next()){
				bill = new Bill();
				bill.setId(result.getString(1));
				bill.setName(result.getString(2));
				bill.setDate(result.getDate(3));
				bill.setName(result.getString(4));
				bill.setAddress(result.getString(5));
				bill.setPhone(result.getString(6));
				bill.setTotal(result.getDouble(7));
				list.add(bill);
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
		return list;
	}
	
	
}
