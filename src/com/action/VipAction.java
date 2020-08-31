package com.action;

import java.sql.SQLException;
import java.util.List;

import com.domain.Vip;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.VipService;


public class VipAction extends ActionSupport implements ModelDriven<Vip> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 商品管理的action类
	 */
	//模型驱动使用的类
	private Vip vip=new Vip();
	@Override
	public Vip getModel() {
		return vip;
	}
	
	public void refresh() throws SQLException{
		List<Vip> vipList=vipService.getAllVip();
		ActionContext.getContext().getApplication().put("vipList", vipList);
	}
	//struts和spring整合过程中按名称自动注入的业务层类
	private VipService vipService;
	public void setVipService(VipService vipService) {
		this.vipService=vipService;
	}
	public String save() throws SQLException {
		vipService.save(vip);
		return NONE;
	}
	public String getAll() throws SQLException {
		refresh();
		return SUCCESS;
	}
	public String delete() throws SQLException{
		vipService.delete(vip.getVid());
		refresh();
		return SUCCESS;
	}
	public String alter() throws SQLException{
		vip=vipService.findById(vip.getVid());
		ActionContext.getContext().getSession().put("vip", vip);
		return "alter";
	}
	public String update() throws SQLException{
		vipService.update(vip);
		refresh();
		return SUCCESS;
	}
	public String search() throws SQLException{
		List<Vip> vipList=vipService.findByName(vip.getVname());
		ActionContext.getContext().getSession().put("vipList", vipList);
		return SUCCESS;
		
	}
}
