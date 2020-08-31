package com.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.domain.GoodsItem;
import com.domain.Product;
import com.domain.ShoppingCart;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.ProductService;

public class ProductAction extends ActionSupport implements ModelDriven<Product> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ��Ʒ�����action��
	 */
	// ģ������ʹ�õ���
	private Product product = new Product();
	private File upload;  //�ļ�
	private String uploadContext;  //�ļ�����
	private String uploadFileName;//�ļ�������+FileName �ļ�����
	private int flag;

	public void setFlag(int flag) {
		this.flag = flag;
	}

	
	public void setUpload(File upload) {
		this.upload = upload;
	}
 
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
 
	public void setUploadContext(String uploadContext) {
		this.uploadContext = uploadContext;
	}

	@Override
	public Product getModel() {
		return product;
	}

	// struts��spring���Ϲ����а������Զ�ע���ҵ�����
	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public String save() throws SQLException, IOException {
		product.setPname(new String());
		if(upload != null){
			String realPath = ServletActionContext.getServletContext().getRealPath("/products");
			File diskFile = new File(realPath+"//"+uploadFileName);
			FileUtils.copyFile(upload, diskFile);
			product.setPicture("products/"+uploadFileName);
		}
		productService.save(product);
		ActionContext.getContext().getSession().put("product", product);
		return NONE;
	}

	public void reloadList() throws SQLException {
		List<Product> productList = productService.getAllProduct();
		ActionContext.getContext().getApplication().put("productList", productList);
	}

	// ��ȡ������Ʒ
	public String getAll() throws SQLException {
		reloadList();
		if (flag == 0) {
			return SUCCESS;
		} else {
			return "show";
		}
	}

	public String delete() throws SQLException, IOException {
		//deleteFile();
		productService.delete(product.getId());
		reloadList();
		return SUCCESS;
	}

	public void download() throws SQLException, IOException {
		product = productService.findById(product.getId());
		//String name = product.getPicture().substring(3, product.getPicture().length());
		String path = ("E:\\Java\\eclipseworkspace\\ssh-demo\\WebContent\\images\\2.jpg");
		File file=new File(path);
		String fname = path.substring(path.lastIndexOf("\\") + 2, path.length());// �õ�images�µ��ļ���
		HttpServletResponse response = ServletActionContext.getResponse();
		if (file.exists()) {
			response.setContentType("image/jpg");
			response.addHeader("Content-Disposition", "attachment;filename=" + fname);
			byte[] buffer = new byte[1024];
			FileInputStream fis = null;
			BufferedInputStream bis = null;
			try {
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				OutputStream os = response.getOutputStream();
				int i = bis.read(buffer);
				while (i != -1) {
					os.write(buffer, 0, i);
					i = bis.read(buffer);
				}
			} catch (IOException ex) {
				System.out.println(ex.toString());
			} finally {
				if (bis != null) {
					bis.close();
				}
				if (fis != null) {
					fis.close();
				}
			}
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("�ļ������ڣ�");
		}
	}

	// ��ת���޸�ҳ��
	public String alter() throws SQLException {
		product = productService.findById(product.getId());
		ActionContext.getContext().getSession().put("product", product);
		return "alter";
	}

	// �޸���Ʒ��Ϣ
	public String update() throws SQLException, IOException {
		if(upload!=null) {
			save();
		}
		productService.update(product);
		ActionContext.getContext().getSession().put("product", product);
		return NONE;
	}

	public String search() throws SQLException {
		List<Product> productList = productService.findByName(product.getPname());
		ActionContext.getContext().getApplication().put("productList", productList);
		if (flag == 0) {
			return SUCCESS;
		} else {
			return "show";
		}
	}

	public String detail() throws SQLException {
		product = productService.findById(product.getId());
		ActionContext.getContext().getSession().put("product", product);
		return "detail";
	}

	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// ��ӵ����ﳵ
	public String addToCart() throws SQLException {
		product = productService.findById(product.getId());
		GoodsItem goodsItem = new GoodsItem(product, quantity);
		ShoppingCart cart = (ShoppingCart) ActionContext.getContext().getSession().get("cart");
		if (cart == null) {
			cart = new ShoppingCart();
		}
		cart.add(goodsItem);
		ActionContext.getContext().getSession().put("cart", cart);
		return "showcart";

	}

	// �ӹ��ﳵɾ��
	public String deleteItem() {
		ShoppingCart cart = (ShoppingCart) ActionContext.getContext().getSession().get("cart");
		GoodsItem item = null;
		for (GoodsItem shopItem : cart.getItems()) {
			if (shopItem.getProduct().getId() == product.getId()) {
				item = shopItem;
				break;
			}
		}
		cart.remove(item.getProduct().getId());
		ActionContext.getContext().getSession().put("cart", cart);
		return "showcart";
	}
}
