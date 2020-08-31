package com.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.domain.Admin;
import com.domain.User;

public class UserDaoImpl extends HibernateDaoSupport{

	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	@SuppressWarnings("unchecked")
	public List<User> getAll()throws SQLException{
		return this.getHibernateTemplate().find("from User");
	}
	@SuppressWarnings("unchecked")
	public List<User> findByName(String username){
		return this.getHibernateTemplate().find("from User where username=?", username);
	}
	@SuppressWarnings("unchecked")
	public List<User>searchUser(String uname,String pword){
		User user=new User();
		user.setUsername(uname);
		user.setPassword(pword);
		return this.getHibernateTemplate().findByExample(user);
	}
	@SuppressWarnings("unchecked")
	public List<Admin>searchAdmin(String uname,String pword){
		Admin admin=new Admin();
		admin.setName(uname);
		admin.setPassword(pword);
		return this.getHibernateTemplate().findByExample(admin);
	}
	
	public void addUser(User user) {
		this.getHibernateTemplate().save(user);
	}
	
	public void deleteUser(Integer id) throws SQLException {
		this.getHibernateTemplate().bulkUpdate("delete from User where userid="+id);
	}
}
