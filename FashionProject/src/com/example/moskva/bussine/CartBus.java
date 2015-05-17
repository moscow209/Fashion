package com.example.moskva.bussine;

import java.util.ArrayList;
import java.util.List;

import com.example.moskva.model.CartItem;
import com.example.moskva.model.Product;

/**
 *@version 1.0 May 15, 2015.
 *@author Moscow209
 */
public class CartBus {
	private List<CartItem> cart;
	private double totalCart;
	private int numberDelete;
	
	public CartBus(){
		cart = new ArrayList<CartItem>();
	}
	
	public List<CartItem> getCart() {
		return cart;
	}
	
	public double getTotalCart() {
		totalCart = 0;
		for(int i = 0; i < cart.size(); i++){
			totalCart = totalCart + cart.get(i).getTotal();
		}
		return totalCart;
	}
	
	public void addCart(CartItem item){
		cart.add(item);
		numberDelete = 0;
	}
	
	public void removeCart(int index){
		cart.remove(index);
		numberDelete = numberDelete + 1;
	}
	
	public void updateCart(int index, int number){
		cart.get(index).setNumber(number);
		cart.get(index).setTotal(number*cart.get(index).getPrice());
	}
	
	public CartItem initCartItem(Product product, String color, String size, int number){
		CartItem item = new CartItem();
		item.setId(product.getId());
		item.setImage(product.getImage().substring(0, product.getImage().length() - 8) + "cart.jpg");
		item.setName(product.getName());
		item.setNumber(number);
		item.setProducer(product.getProducer());
		item.setColor(color);
		item.setSize(size);
		item.setPrice(product.getPrice());
		item.setTotal(number*product.getPrice());
		return item;
	}

	public int getNumberDelete() {
		return numberDelete;
	}
	
	
	
	
}
