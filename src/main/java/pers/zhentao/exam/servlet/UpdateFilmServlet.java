package pers.zhentao.exam.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.zhentao.exam.factory.DAOFactory;
import pers.zhentao.exam.vo.Film;

public class UpdateFilmServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String sLanguageId = request.getParameter("language");
		String filmId = request.getParameter("filmId");
		String info = null;
		try{
			if(!title.equals("") && !description.equals("")){
				Film film = new Film();
				film.setTitle(title);
				film.setDescription(description);
				film.setFilmId(Integer.parseInt(filmId));
				film.setLanguageId(Integer.parseInt(sLanguageId));
				if(DAOFactory.getIFilmDAOInstance().updateFilm(film,Integer.parseInt(sLanguageId))){
					request.getRequestDispatcher("showFilm").forward(request, response);
				}else{
					info = "添加失败";
					request.setAttribute("info", info);
					request.setAttribute("id", filmId);
					request.getRequestDispatcher("showUpdateFilm").forward(request, response);
				}
			}else{
				info = "字段为空";
				request.setAttribute("info", info);
				request.setAttribute("id", filmId);
				request.getRequestDispatcher("showUpdateFilm").forward(request, response);
			}
		}catch(Exception e){
			info = "Exception:"+e.getMessage();
			request.setAttribute("info", info);
			request.setAttribute("id", filmId);
			request.getRequestDispatcher("showUpdateFilm").forward(request, response);
				
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		this.doGet(request, response);
	}
}
