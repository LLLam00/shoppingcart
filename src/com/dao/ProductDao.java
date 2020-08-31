package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.domain.Product;

public interface ProductDao {
	void addProduct(Product product) throws SQLException;
	void deleteProduct(Integer id) throws SQLException;
	public Product findById(Integer id) throws SQLException;
	public List<Product> findByName(String pname) throws SQLException;
	public List<Product> getAllProduct() throws SQLException;
	public void update(Product product)throws SQLException;
}
