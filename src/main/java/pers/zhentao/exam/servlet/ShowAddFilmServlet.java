package pers.zhentao.exam.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.zhentao.exam.factory.DAOFactory;
import pers.zhentao.exam.vo.Film;
import pers.zhentao.exam.vo.Language;

public class ShowAddFilmServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		List<Language> list = new ArrayList<Language>();
		try{
			list = DAOFactory.getIFilmDAOInstance().getLanguage();
		}catch(Exception e){
			List<String> info = new ArrayList<String>();
			info.add("Exception:"+e.getMessage());
			request.setAttribute("info", info);
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("addFilm.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		this.doGet(request, response);
	}
}
