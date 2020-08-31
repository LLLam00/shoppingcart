package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.domain.Order;


public interface OrderDao {
	void addOrder(Order order) throws SQLException;
	void deleteOrder(Integer oid) throws SQLException;
	public Order findById(Integer oid) throws SQLException;
	public List<Order> findByName(String buyer) throws SQLException;
	public List<Order> getAllOrder() throws SQLException;
	public void update(Order order)throws SQLException;
}
