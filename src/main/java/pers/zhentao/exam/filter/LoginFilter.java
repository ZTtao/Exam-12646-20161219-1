package pers.zhentao.exam.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{
	private String page;
	private String pageList[];
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String str1 = ((HttpServletRequest)request).getServletPath();
		boolean flag = true;
		for(String str:pageList){
			if(((HttpServletRequest)request).getServletPath().equals(str))
				flag = false;
		}
		if(flag){
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		if(session.getAttribute("customer")!=null){
			chain.doFilter(request, response);
		}else{
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		}else{
			chain.doFilter(request, response);
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		page = arg0.getInitParameter("page");
		pageList = page.split(",");
	}

		
}
