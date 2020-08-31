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

	// ҵ���ע��Dao����
	private UserDaoImpl userDaoImpl;

	// spring��set�����Ϳ���ע��
	public void setUserDao(UserDaoImpl userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}
	public List<User> getAll() throws SQLException{
		return userDaoImpl.getAll();
	}
	public boolean findByName(String username) {
		//0 ����
		return this.userDaoImpl.findByName(username).size()==0;
	}
	
	public boolean searchUser(String uname,String pword) {
		//��ѯ�������� true
		return userDaoImpl.searchUser(uname, pword).size()==0;
	}
	public boolean searchAdmin(String uname,String pword) {
		//��ѯ�������� true
		return userDaoImpl.searchAdmin(uname, pword).size()==0;
	}
	public void addUser(User user) {
		userDaoImpl.addUser(user);
	}
}
