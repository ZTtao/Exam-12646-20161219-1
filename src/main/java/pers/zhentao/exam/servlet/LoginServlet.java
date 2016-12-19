package pers.zhentao.exam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.zhentao.exam.factory.DAOFactory;
import pers.zhentao.exam.vo.Customer;

public class LoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String firstName = request.getParameter("firstName");
		List<String> info = new ArrayList<String>();
		if(firstName == null || "".equals(firstName)){
			info.add("firstName is null");
		}
		if(info.size() == 0){
				Customer cus;
				try {
					cus = DAOFactory.getIUserDAOInstance().login(firstName);
					if(cus == null){
						info.add("user not exist");
						request.setAttribute("info", info);
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}else{
						request.getSession().setAttribute("customer", cus);
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
				} catch (Exception e) {
					e.printStackTrace();
					info.add("Exception："+e.getMessage());
					request.setAttribute("info", info);
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
		}else{
			request.setAttribute("info", info);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		this.doGet(request, response);
	}
}
