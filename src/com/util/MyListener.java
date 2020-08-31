package com.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */
@WebListener
public class MyListener implements ServletContextAttributeListener{
    
    public MyListener() {
        // TODO Auto-generated constructor stub
    }
    @Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		ServletContext application=event.getServletContext();
		//获取添加的属性名和属性值
		String name=event.getName();
		if(name.equals("productList")) {
			Object value=event.getValue();
			System.out.println(application+"范围内添加了名为"+name+"值为"+value+"的属性");
		}
		
	}
	
	//把一个属性从application范围删除时触发该方法
	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
 
		ServletContext application=event.getServletContext();
		//获取被删除的属性名和属性值
		String name=event.getName();
		if(name.equals("productList")) {
			Object value=event.getValue();
			System.out.println(application+"范围内名为"+name+"值为"+value+"的属性被删除了");
		}
	}
	
	//替换application范围内的属性时触发该方法
	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		ServletContext application=event.getServletContext();
		//获取被替换的属性名和属性值
		String name=event.getName();
		if(name.equals("productList")) {
			Object value=event.getValue();
			System.out.println(application+"范围内"+name+"值为"+value+"的属性被替换了");
		}
	}

}
