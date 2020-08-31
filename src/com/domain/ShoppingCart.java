package com.domain;

import java.io.Serializable;
import java.util.*;

public class ShoppingCart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ����Map�ļ�����Ʒ��
	HashMap<Integer, GoodsItem> items = null;

	public ShoppingCart() { // ���ﳵ�Ĺ��췽��
		items = new HashMap<Integer, GoodsItem>();
	}

	// ���ﳵ�������Ʒ����
	public void add(GoodsItem goodsItem) {
		// ������ӵ���Ʒ��
		int productid = goodsItem.getProduct().getId();
		// ������ﳵ�а���ָ������Ʒ�����ظ���Ʒ����������
		if (items.containsKey(productid)) {
			GoodsItem scitem = (GoodsItem) items.get(productid);
			// �޸ĸ���Ʒ������
			scitem.setQuantity(scitem.getQuantity() + goodsItem.getQuantity());
		} else {
			// ���򽫸���Ʒ��ӵ����ﳵ��
			items.put(productid, goodsItem);
		}
	}

	// �ӹ��ﳵ��ɾ��һ����Ʒ
	public void remove(Integer productid) {
		if (items.containsKey(productid)) {
			GoodsItem scitem = (GoodsItem) items.get(productid);
			scitem.setQuantity(scitem.getQuantity() - 1);
			if (scitem.getQuantity() <= 0)
				items.remove(productid);
		}
	}

	// ���ع��ﳵ��GoodsItem�ļ���
	public Collection<GoodsItem> getItems() {
		return items.values();
	}

	// ���㹺�ﳵ������Ʒ�۸�
	public double getTotal() {
		double amount = 0.0;
		for (Iterator<GoodsItem> i = getItems().iterator(); i.hasNext();) {
			GoodsItem item = (GoodsItem) i.next();
			Product product = (Product) item.getProduct();
			amount += item.getQuantity() * product.getPrice();
		}
		return roundOff(amount);
	}

	// ����ֵ�����������벢������λС��
	private double roundOff(double x) {
		long val = Math.round(x * 100); // cents
		return val / 100.0;
	}

	// ��չ��ﳵ����
	public void clear() {
		items.clear();
	}
}
