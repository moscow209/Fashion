package com.example.moskva.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.moskva.model.Product;

/**
 * @version 1.0 May 15, 2015.
 * @author Moscow209
 */
public class ProductDAO {
	public List<Product> getProducts(int offset, int number) {
		Connection con = ConnectionUtils.openConnection();
		List<Product> list = new ArrayList<Product>();
		String query = "select* from product limit " + offset + ", " + number;
		try {
			Statement sta = con.createStatement();
			ResultSet result = sta.executeQuery(query);
			Product product = null;
			while (result.next()) {
				product = new Product();
				product.setId(result.getString(1));
				product.setName(result.getString(2));
				product.setImage(result.getString(3));
				product.setProducer(result.getString(4));
				product.setColor(result.getString(5));
				product.setSize(result.getString(6));
				product.setPrice(result.getDouble(7));
				list.add(product);
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
	
	public List<Product> search(String type, String keyword){
		Connection con = ConnectionUtils.openConnection();
		List<Product> list = new ArrayList<Product>();
		String query = "select* from product where " + type + " like \"%" + keyword + "%\""; 
		System.out.println(query);
		try {
			Statement pre = con.createStatement();
			ResultSet result = pre.executeQuery(query);
			Product product = null;
			while (result.next()) {
				product = new Product();
				product.setId(result.getString(1));
				product.setName(result.getString(2));
				product.setImage(result.getString(3));
				product.setProducer(result.getString(4));
				product.setColor(result.getString(5));
				product.setSize(result.getString(6));
				product.setPrice(result.getDouble(7));
				list.add(product);
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
	
	public List<Product> searchPrice(String price){
		Connection con = ConnectionUtils.openConnection();
		List<Product> list = new ArrayList<Product>();
		String query = "select* from product where price_product <= ?"; 
		try {
			PreparedStatement pre = con.prepareStatement(query);
			pre.setString(1, price);
			ResultSet result = pre.executeQuery();
			Product product = null;
			while (result.next()) {
				product = new Product();
				product.setId(result.getString(1));
				product.setName(result.getString(2));
				product.setImage(result.getString(3));
				product.setProducer(result.getString(4));
				product.setColor(result.getString(5));
				product.setSize(result.getString(6));
				product.setPrice(result.getDouble(7));
				list.add(product);
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

	public int getTotalProduct() {
		Connection con = ConnectionUtils.openConnection();
		String query = "select count(*) from product";
		int totalProduct = 0;
		try {
			Statement sta = con.createStatement();
			ResultSet result = sta.executeQuery(query);
			if (result.next()) {
				totalProduct = (int) result.getLong(1);
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
		return totalProduct;
	}

	public Product getProduct(String id){
		Connection con = ConnectionUtils.openConnection();
		Product product = new Product();
		try {
			PreparedStatement pre = con.prepareStatement("select* from product where id_product = ?");
			pre.setString(1, id);
			ResultSet result = pre.executeQuery();
			while(result.next()){
				product.setId(result.getString(1));
				product.setName(result.getString(2));
				product.setImage(result.getString(3));
				product.setProducer(result.getString(4));
				product.setColor(result.getString(5));
				product.setSize(result.getString(6));
				product.setPrice(result.getDouble(7));
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
		return product;
	}
}
