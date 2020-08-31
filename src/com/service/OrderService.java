package com.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.dao.OrderDaoImpl;
import com.domain.Order;

public class OrderService {
	
	
		// ҵ���ע��Dao����
		private OrderDaoImpl orderDaoImpl;

		//spring��set�����Ϳ���ע��
		public void setOrderDao(OrderDaoImpl orderDaoImpl) {
			this.orderDaoImpl = orderDaoImpl;
		}

		public void save(Order order) throws SQLException {
			orderDaoImpl.addOrder(order);
		}
		public void delete(int oid) throws SQLException {
			orderDaoImpl.deleteOrder(oid);
		}
		public List<Order> getAllOrder() throws SQLException {
			return orderDaoImpl.getAllOrder();
		}
		public Order findById(int oid) throws SQLException{
			return orderDaoImpl.findById(oid);
		}
		public List<Order> findByName(String buyer) throws SQLException{
			buyer="%"+buyer+"%";
			return orderDaoImpl.findByName(buyer);
		}
		
		public void update(Order order) throws SQLException{
			orderDaoImpl.update(order);
		}


}
