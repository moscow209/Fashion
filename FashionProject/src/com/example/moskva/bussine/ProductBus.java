package com.example.moskva.bussine;

import java.util.List;

import com.example.moskva.dao.ProductDAO;
import com.example.moskva.model.Product;


/**
 *@version 1.0 May 15, 2015.
 *@author Moscow209
 */
public class ProductBus {
	private ProductDAO dao;
	
	public ProductBus(){
		dao = new ProductDAO();
	}
	
	public List<Product> getProducts(int offset, int number){
		return dao.getProducts(offset, number);
	}
	
	public int getTotalProduct(){
		return dao.getTotalProduct();
	}
	
	public Product getProduct(String id){
		return dao.getProduct(id);
	}
	
	public List<Product> search(String type, String keyword){
		switch (type) {
		case "producer":
			return dao.search("producer", keyword);
		case "color":
			return dao.search("color_product", keyword);
		case "size":
			return dao.search("size_product", keyword);
		default:
			return dao.searchPrice(keyword);
		}
	}
}
