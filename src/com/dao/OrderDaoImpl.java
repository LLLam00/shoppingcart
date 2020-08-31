package com.dao;

import java.sql.SQLException;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.domain.Order;

//�̳�ģ��
public class OrderDaoImpl extends HibernateDaoSupport{
	
	public void addOrder(Order order) throws SQLException {
		System.out.println("DAO�е�addOrder����ִ����");	
		this.getHibernateTemplate().save(order);
	}

	public void deleteOrder(Integer oid) throws SQLException {
		System.out.println("DAO�е�deleteOrder����ִ����");	
		this.getHibernateTemplate().bulkUpdate("delete from Order where oid="+oid);
	}


	@SuppressWarnings("unchecked")
	public List<Order> getAllOrder() throws SQLException {
		return this.getHibernateTemplate().find("FROM Order");
	}

	public void update(Order order) throws SQLException {
		this.getHibernateTemplate().update(order);
	}


	public Order findById(Integer oid) {
		return this.getHibernateTemplate().get(Order.class, oid);
	}

	@SuppressWarnings("unchecked")
	public List<Order> findByName(String buyer) {
		return this.getHibernateTemplate().find("from Order where buyer like ?", buyer); 
	}

	
}
