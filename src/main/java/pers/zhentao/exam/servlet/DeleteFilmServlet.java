package pers.zhentao.exam.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.zhentao.exam.factory.DAOFactory;
import pers.zhentao.exam.vo.Film;

public class DeleteFilmServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String filmId = request.getParameter("id");
		String info = null;
		try{
			if(DAOFactory.getIFilmDAOInstance().deleteFilm(Integer.parseInt(filmId))){
				info="删除成功";
				request.setAttribute("info", info);
			}else{
				info = "删除失败";
				request.setAttribute("info", info);
			}
		}catch(Exception e){
			info = "存在外键约束，无法删除";
			request.setAttribute("info", info);
		}
		request.getRequestDispatcher("showFilm").forward(request, response);

	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		this.doGet(request, response);
	}
}
