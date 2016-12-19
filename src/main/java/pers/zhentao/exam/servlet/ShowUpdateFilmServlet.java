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

public class ShowUpdateFilmServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String sFilmId = request.getParameter("id");
		if(sFilmId == null)sFilmId = (String)request.getAttribute("id");
		String info = null;
		Film film = new Film();
		List<Language> list = new ArrayList<Language>();
		try{
			if(sFilmId != null){
				film = DAOFactory.getIFilmDAOInstance().getFilmById(Integer.parseInt(sFilmId));
				list = DAOFactory.getIFilmDAOInstance().getLanguage();
				request.setAttribute("film", film);
				request.setAttribute("list", list);
			}else{
				info = "id为空";
				request.setAttribute("info", info);
			}
		}catch(Exception e){
			info = "Exception:"+e.getMessage();
			request.setAttribute("info", info);
		}
		request.getRequestDispatcher("updateFilm.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		this.doGet(request, response);
	}
}
