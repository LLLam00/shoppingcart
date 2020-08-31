package com.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.ProductDaoImpl;
import com.domain.Product;
/**
 * 业务管理
 */
@Transactional
public class ProductService {
	// 业务层注入Dao的类
	private ProductDaoImpl productDaoImpl;

	//spring有set方法就可以注入
	public void setProductDao(ProductDaoImpl productDaoImpl) {
		this.productDaoImpl = productDaoImpl;
	}

	public void save(Product product) throws SQLException {
		productDaoImpl.addProduct(product);
	}
	public void delete(int id) throws SQLException {
		productDaoImpl.deleteProduct(id);
	}
	public List<Product> getAllProduct() throws SQLException {
		return productDaoImpl.getAllProduct();
	}
	public Product findById(int id) throws SQLException{
		return productDaoImpl.findById(id);
	}
	public List<Product> findByName(String pname) throws SQLException{
		pname="%"+pname+"%";
		return productDaoImpl.findByName(pname);
	}
	
	public void update(Product product) throws SQLException{
		productDaoImpl.update(product);
	}

	/**
	 * 这个函数的功能是获取当前时间点与1970年的间隔秒数
	 */
	public int getSecondTimestamp(Date date) {
		if (null == date) {
			return 0;
		}
		String timestamp = String.valueOf(date.getTime());
		System.out.println(timestamp);
		int length = timestamp.length();
		if (length > 3) {
			return Integer.valueOf(timestamp.substring(0, length - 3));
		} else {
			return 0;
		}
	}
	/**
	 * 这个函数的功能是得到新的照片名称
	 */
	public String getPhotoNewName() {
		Date date = new Date();
		int second = getSecondTimestamp(date);
		String fileName = String.valueOf(second);
		return fileName;
	}
}