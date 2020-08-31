package com.domain;
import java.io.Serializable;
public class GoodsItem implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Product product;    // ��Ʒ��Ϣ
     private int quantity;       // ��Ʒ����
     
     public GoodsItem(Product product) {
         this.product = product;
         quantity = 1;
     }
     public GoodsItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
     }
     // ���Ե�getter������setter����
     public Product getProduct() {
		return product;
	   }
     public void setProduct(Product product) {
		 this.product = product;
	 }
	   public int getQuantity() {
		return quantity;
     }
    public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}

