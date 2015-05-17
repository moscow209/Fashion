package com.example.moskva.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.moskva.model.Bill;
import com.example.moskva.model.DetailBill;

/**
 *@version 1.0 May 15, 2015.
 *@author Moscow209
 */
public class DetailBillDAO {
	public void insertDetailBill(DetailBill detail){
		Connection con = ConnectionUtils.openConnection();
		try {
			PreparedStatement pre = con.prepareStatement("insert into detail_bill values(?, ?, ?, ?, ?)");
			pre.setString(1, detail.getId());
			pre.setString(2, detail.getProduct());
			pre.setString(3, detail.getColor());
			pre.setString(4, detail.getSize());
			pre.setInt(5, detail.getNumber());
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
	
	public List<DetailBill> getDetailBill(String id){
		Connection con = ConnectionUtils.openConnection();
		List<DetailBill> list = new ArrayList<DetailBill>();
		try {
			PreparedStatement pre = con.prepareStatement("select* from detail_bill where id_bill = ?");
			pre.setString(1, id);
			ResultSet result = pre.executeQuery();
			DetailBill detail = null;
			while(result.next()){
				detail = new DetailBill();
				detail.setId(result.getString(1));
				detail.setProduct(result.getString(2));
				detail.setColor(result.getString(3));
				detail.setSize(result.getString(4));
				detail.setNumber(result.getInt(5));
				list.add(detail);
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
