package com.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.ProductDaoImpl;
import com.domain.Product;
/**
 * ҵ�����
 */
@Transactional
public class ProductService {
	// ҵ���ע��Dao����
	private ProductDaoImpl productDaoImpl;

	//spring��set�����Ϳ���ע��
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
	 * ��������Ĺ����ǻ�ȡ��ǰʱ�����1970��ļ������
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
	 * ��������Ĺ����ǵõ��µ���Ƭ����
	 */
	public String getPhotoNewName() {
		Date date = new Date();
		int second = getSecondTimestamp(date);
		String fileName = String.valueOf(second);
		return fileName;
	}
}