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

public class ShowFilmServlet extends HttpServlet{
	private int pageSize = 10;
	private int pageNow = 1;
	private int pageCount = 0;
	private int rowCount = 0;
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String sPageNow = request.getParameter("pageNow");
		if(sPageNow != null){
			pageNow = Integer.parseInt(sPageNow);
		}
		List<Film> list = new ArrayList<Film>();
		try{
			rowCount = DAOFactory.getIFilmDAOInstance().getFilmCount();
			if(rowCount%pageSize == 0){
				pageCount = rowCount/pageSize;
			}else{
				pageCount = rowCount/pageSize + 1;
			}
			list = DAOFactory.getIFilmDAOInstance().getFilm(pageSize, pageNow);
		}catch(Exception e){
			List<String> info = new ArrayList<String>();
			info.add("Exception:"+e.getMessage());
			request.setAttribute("info", info);
		}
		request.setAttribute("list", list);
		request.setAttribute("pageNow", pageNow);
		request.setAttribute("pageCount", pageCount);
		request.getRequestDispatcher("showFilm.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		this.doGet(request, response);
	}
}
