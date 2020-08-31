package com.dao;

import java.sql.SQLException;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.domain.Vip;

//继承模板
public class VipDaoImpl extends HibernateDaoSupport{
	
	public void addVip(Vip vip) throws SQLException {
		System.out.println("DAO中的addVip方法执行了");	
		this.getHibernateTemplate().save(vip);
	}

	public void deleteVip(Integer vid) throws SQLException {
		System.out.println("DAO中的deleteVip方法执行了");	
		this.getHibernateTemplate().bulkUpdate("delete from Vip where vid="+vid);
	}


	@SuppressWarnings("unchecked")
	public List<Vip> getAllVip() throws SQLException {
		return this.getHibernateTemplate().find("FROM Vip");
	}

	public void update(Vip vip) throws SQLException {
		this.getHibernateTemplate().update(vip);
	}


	public Vip findById(Integer vid) {
		return this.getHibernateTemplate().get(Vip.class, vid);
	}

	@SuppressWarnings("unchecked")
	public List<Vip> findByName(String vname) {
		return this.getHibernateTemplate().find("from Vip where vname like ?", vname); 
	}

	
}
