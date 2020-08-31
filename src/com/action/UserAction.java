package com.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;

	public UserAction() {
		// TODO Auto-generated constructor stub
	}

	private User user = new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getModel() {
		return user;
	}

	// struts��spring���Ϲ����а������Զ�ע���ҵ�����
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String getAll() throws SQLException {
		List<User> userList = userService.getAll();
		ActionContext.getContext().getApplication().put("userList", userList);
		return SUCCESS;
	}

	private String myname;
	public String getMyname() {
		return myname;
	}

	public void setMyname(String myname) {
		this.myname = myname;
	}

	public void get() throws IOException{
		String message="�û����ѱ�ռ��";
		if(!myname.trim().equals("")&&userService.findByName(myname.trim())) {
			message="�û�������";
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out=response.getWriter();
		out.println("<response>");
		out.println("<message>"+message+"</message>");
		out.println("</response>");
	}
	
	public String regist() {
		String uname = user.getUsername().trim();
		if(!userService.findByName(uname)) {
			this.addActionError("�û����ѱ�ע�ᣬ�����ԣ�");
			return NONE;
		}else {
			userService.addUser(user);
			return "toLogin";
		}
	}
	
	//login()��Ҫ�õ��Ĳ�������jsp�в�����nameͬ��
	public Boolean check;
	public Boolean getCheck() {
		return check;
	}
	public void setCheck(Boolean check) {
		this.check = check;
	}
	
	public String userType;
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String login() throws UnsupportedEncodingException, SQLException {
		String uname = user.getUsername();
		String pword = user.getPassword();
		//0����Ա1��ͨ�û�
		if(userType.equals("0")) {
			if(userService.searchAdmin(uname, pword)) {
				this.addActionError("�û������������");
				return INPUT;
			}else {
				ActionContext.getContext().getSession().put("HiAdmin", true);
				if (check) {
					Cookie nameCookie = new Cookie("adminName", URLEncoder.encode(uname, "UTF-8"));
					nameCookie.setMaxAge(60 * 60);
					HttpServletResponse response = ServletActionContext.getResponse();
					response.addCookie(nameCookie);
				}
				return "admin";
			}
		}else{
			if(userService.searchUser(uname, pword)) {
				this.addActionError("�û������������");
				return INPUT;
			}else{
				ActionContext.getContext().getSession().put("loggedIn", true);
				if (check) {
					System.out.println("����cookies");
					Cookie nameCookie = new Cookie("username", URLEncoder.encode(uname, "UTF-8"));
					nameCookie.setMaxAge(60 * 60);
					HttpServletResponse response = ServletActionContext.getResponse();
					response.addCookie(nameCookie);
				}
				return SUCCESS;
			}
		}
	}

	public String logout() {
		ActionContext.getContext().getSession().remove("loggedIn");
		ActionContext.getContext().getApplication().remove("productList");
		HttpServletRequest request=ServletActionContext.getRequest();
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("username")) {
				cookie.setMaxAge(0);
				HttpServletResponse response = ServletActionContext.getResponse();
				response.addCookie(cookie);
			}
		}
		//6.13Ҳ���Ըĳ�success���������������
		//6.14�õ��Ѿ��ĳ�success��
		return SUCCESS;
	}
	public String adminout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		ActionContext.getContext().getSession().remove("HiAdmin");
		ActionContext.getContext().getApplication().remove("productList");
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("adminName")) {
				cookie.setMaxAge(0);
				HttpServletResponse response = ServletActionContext.getResponse();
				response.addCookie(cookie);
			}
		}
		return "admin";
	}
}
