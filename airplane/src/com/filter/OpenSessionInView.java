package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.ibatis.session.SqlSession;

import com.util.MyBatisUtil;

@WebFilter("/*")
public class OpenSessionInView implements Filter {

	@Override
	public void init(FilterConfig filterconfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain filterchain)
			throws IOException, ServletException {
		SqlSession session = MyBatisUtil.getSession();
		try {
			filterchain.doFilter(servletrequest, servletresponse);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSession();
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
