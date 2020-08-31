package com.dao;

import java.sql.SQLException;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.domain.Product;

//�̳�ģ��
public class ProductDaoImpl extends HibernateDaoSupport{
	
	public void addProduct(Product product) throws SQLException {
		System.out.println("DAO�е�addProuct����ִ����");	
		this.getHibernateTemplate().save(product);
	}

	public void deleteProduct(Integer id) throws SQLException {
		System.out.println("DAO�е�deleteProduct����ִ����");	
		this.getHibernateTemplate().bulkUpdate("delete from Product where id="+id);
	}


	@SuppressWarnings("unchecked")
	public List<Product> getAllProduct() throws SQLException {
		return this.getHibernateTemplate().find("from Product");
	}

	public void update(Product product) throws SQLException {
		this.getHibernateTemplate().update(product);
	}


	public Product findById(Integer id) {
		return this.getHibernateTemplate().get(Product.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Product> findByName(String pname) {
		return this.getHibernateTemplate().find("from Product where pname like ?", pname); 
	}

	
}
