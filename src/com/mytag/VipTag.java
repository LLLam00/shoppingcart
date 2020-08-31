package com.mytag;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.domain.Vip;

public class VipTag extends SimpleTagSupport{
	
	private ArrayList<Vip> vipList;
	  public void setVipList(ArrayList<Vip> vipList){
	     this.vipList = vipList;
	  }
	  public void doTag() throws JspException, IOException{
	     for(Vip vip:vipList){
	        getJspContext().setAttribute("vip", vip);
	        getJspBody().invoke(null);
	     }
	  }

}
