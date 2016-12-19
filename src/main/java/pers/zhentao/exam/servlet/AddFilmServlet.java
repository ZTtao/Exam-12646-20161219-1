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

public class AddFilmServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String sLanguageId = request.getParameter("language");
		String info = null;
		try{
			if(!title.equals("") && !description.equals("")){
				Film film = new Film();
				film.setTitle(title);
				film.setDescription(description);
				if(DAOFactory.getIFilmDAOInstance().addFilm(film,Integer.parseInt(sLanguageId))){
					request.getRequestDispatcher("showFilm").forward(request, response);
				}else{
					info = "添加失败";
					request.setAttribute("info", info);
					request.getRequestDispatcher("showAddFilm").forward(request, response);
				}
			}else{
				info = "字段为空";
				request.setAttribute("info", info);
				request.getRequestDispatcher("showAddFilm").forward(request, response);
			}
		}catch(Exception e){
			info = "Exception:"+e.getMessage();
			request.setAttribute("info", info);
			request.getRequestDispatcher("showAddFilm").forward(request, response);
				
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		this.doGet(request, response);
	}
}
