package com.action;

import java.sql.SQLException;
import java.util.List;

import com.domain.Order;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.OrderService;

public class OrderAction extends ActionSupport implements ModelDriven<Order> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ��Ʒ�����action��
	 */
	//ģ������ʹ�õ���
	private Order order=new Order();
	@Override
	public Order getModel() {
		return order;
	}
	
	public void refresh() throws SQLException{
		List<Order> orderList=orderService.getAllOrder();
		ActionContext.getContext().getApplication().put("orderList", orderList);
	}
	//struts��spring���Ϲ����а������Զ�ע���ҵ�����
	private OrderService orderService;
	public void setOrderService(OrderService orderService) {
		this.orderService=orderService;
	}
	public String save() throws SQLException {
		orderService.save(order);
		return NONE;
	}
	public String getAll() throws SQLException {
		refresh();
		return SUCCESS;
	}
	public String delete() throws SQLException{
		orderService.delete(order.getOid());
		refresh();
		return SUCCESS;
	}
	public String alter() throws SQLException{
		order=orderService.findById(order.getOid());
		ActionContext.getContext().getSession().put("order", order);
		return "alter";
	}
	public String update() throws SQLException{
		orderService.update(order);
		refresh();
		return SUCCESS;
	}
	public String search() throws SQLException{
		List<Order> orderList=orderService.findByName(order.getBuyer());
		ActionContext.getContext().getSession().put("orderList", orderList);
		return SUCCESS;
		
	}
}
