package com.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDaoImpl;
import com.domain.User;


@Transactional
public class UserService {

	public UserService() {
		// TODO Auto-generated constructor stub
	}

	// 业务层注入Dao的类
	private UserDaoImpl userDaoImpl;

	// spring有set方法就可以注入
	public void setUserDao(UserDaoImpl userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}
	public List<User> getAll() throws SQLException{
		return userDaoImpl.getAll();
	}
	public boolean findByName(String username) {
		//0 可用
		return this.userDaoImpl.findByName(username).size()==0;
	}
	
	public boolean searchUser(String uname,String pword) {
		//查询不到返回 true
		return userDaoImpl.searchUser(uname, pword).size()==0;
	}
	public boolean searchAdmin(String uname,String pword) {
		//查询不到返回 true
		return userDaoImpl.searchAdmin(uname, pword).size()==0;
	}
	public void addUser(User user) {
		userDaoImpl.addUser(user);
	}
}
