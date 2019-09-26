package cn.com.rpg.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
 * @author Administrator
 *	过滤post请求的中文乱码过滤器
 *	1.实现Filter接口
 *	2.重写方法
 *	3.在web.xml配置过滤路径
 */
public class SetCharacterEncoding implements Filter{

	public void destroy() {
		System.out.println("Filter销毁...");
	}

	/**
	 *	相当于是放行的方法,会自动进入到该方法 
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//真正的放行
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Filter初始化...");
	}
	
}
