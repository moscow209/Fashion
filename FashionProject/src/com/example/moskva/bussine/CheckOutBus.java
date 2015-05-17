package com.example.moskva.bussine;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.example.moskva.dao.BillDAO;
import com.example.moskva.dao.DetailBillDAO;
import com.example.moskva.model.Bill;
import com.example.moskva.model.CartItem;
import com.example.moskva.model.DetailBill;
import com.mysql.jdbc.exceptions.DeadlockTimeoutRollbackMarker;

/**
 *@version 1.0 May 15, 2015.
 *@author Moscow209
 */
public class CheckOutBus {
	public static void checkOut(Bill bill, List<CartItem> cart, String email){
		DetailBillDAO daoDetail = new DetailBillDAO();
		BillDAO daoBill = new BillDAO();
		daoBill.insertBill(bill);
		DetailBill detail = null;
		for(int i = 0; i < cart.size(); i++){
			detail = new DetailBill();
			detail.setId(bill.getId());
			detail.setColor(cart.get(i).getColor());
			detail.setSize(cart.get(i).getSize());
			detail.setNumber(cart.get(i).getNumber());
			detail.setProduct(cart.get(i).getId());
			daoDetail.insertDetailBill(detail);
		}
		SendMail.sendBill(email, bill);
	}
}
