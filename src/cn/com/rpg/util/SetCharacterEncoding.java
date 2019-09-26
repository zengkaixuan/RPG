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
 *	����post������������������
 *	1.ʵ��Filter�ӿ�
 *	2.��д����
 *	3.��web.xml���ù���·��
 */
public class SetCharacterEncoding implements Filter{

	public void destroy() {
		System.out.println("Filter����...");
	}

	/**
	 *	�൱���Ƿ��еķ���,���Զ����뵽�÷��� 
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//�����ַ���
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//�����ķ���
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Filter��ʼ��...");
	}
	
}
