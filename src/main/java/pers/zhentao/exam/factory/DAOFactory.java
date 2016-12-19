package pers.zhentao.exam.factory;

import pers.zhentao.exam.dao.IFilmDAO;
import pers.zhentao.exam.dao.IUserDAO;
import pers.zhentao.exam.dao.proxy.FilmDAOProxy;
import pers.zhentao.exam.dao.proxy.UserDAOProxy;

public class DAOFactory {
	public static IUserDAO getIUserDAOInstance(){
		return new UserDAOProxy();
	}
	public static IFilmDAO getIFilmDAOInstance(){
		return new FilmDAOProxy();
	}
}
