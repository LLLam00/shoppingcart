package com.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(urlPatterns={"/*"},initParams= {@WebInitParam(name="encoding",value="UTF-8")})
public class EncodingFilter implements Filter {
	protected String encoding=null;
	protected FilterConfig config;
	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(request.getCharacterEncoding()==null) {
			String encode=getEncoding();
			if(encode!=null) {
				request.setCharacterEncoding(encode);
				response.setCharacterEncoding(encode);
			}
		}
		chain.doFilter(request, response);
	}

	
	private String getEncoding() {
		return encoding;
	}


	public void init(FilterConfig filterConfig) throws ServletException {
		this.config=filterConfig;
		this.encoding=filterConfig.getInitParameter("encoding");
	}

}
