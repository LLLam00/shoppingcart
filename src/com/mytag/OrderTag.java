package com.mytag;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.domain.Order;

public class OrderTag extends SimpleTagSupport{
	
	private ArrayList<Order> orderList;
	  public void setOrderList(ArrayList<Order> orderList){
	     this.orderList = orderList;
	  }
	  public void doTag() throws JspException, IOException{
	     for(Order order:orderList){
	        getJspContext().setAttribute("order", order);
	        getJspBody().invoke(null);
	     }
	  }

}
