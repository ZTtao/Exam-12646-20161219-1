package pers.zhentao.exam.dao.proxy;

import java.util.ArrayList;
import java.util.List;

import pers.zhentao.exam.dao.IFilmDAO;
import pers.zhentao.exam.dao.impl.FilmDAOImpl;
import pers.zhentao.exam.dbc.DatabaseConnection;
import pers.zhentao.exam.vo.Film;
import pers.zhentao.exam.vo.Language;

public class FilmDAOProxy implements IFilmDAO{

	private DatabaseConnection dbc = null;
	private IFilmDAO filmDAO = null;
	
	public FilmDAOProxy(){
		try{
			this.dbc = new DatabaseConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		this.filmDAO = new FilmDAOImpl(this.dbc.getConnection());
	}
	public int getFilmCount() throws Exception {
		int count = 0;
		try{
			count = filmDAO.getFilmCount();
		}catch(Exception e){
			throw e;
		}
		return count;
	}
	public List<Film> getFilm(int pageSize, int pageNow) throws Exception {
		List<Film> list = new ArrayList<Film>();
		try{
			list = filmDAO.getFilm(pageSize, pageNow);
		}catch(Exception e){
			throw e;
		}
		return list;
	}
	public List<Language> getLanguage() throws Exception {
		// TODO Auto-generated method stub
		List<Language> list = new ArrayList<Language>();
		try{
			list = filmDAO.getLanguage();
		}catch(Exception e){
			throw e;
		}
		return list;
	}
	public boolean addFilm(Film film,int languageId) throws Exception {
		boolean flag = false;
		try{
			flag = filmDAO.addFilm(film,languageId);
		}catch(Exception e){
			throw e;
		}
		return flag;
	}
	public Film getFilmById(int filmId) throws Exception {
		Film film = new Film();
		try{
			film = filmDAO.getFilmById(filmId);
		}catch(Exception e){
			throw e;
		}
		return film;
	}
	public boolean updateFilm(Film film, int languageId) throws Exception {
		boolean flag = false;
		try{
			flag = filmDAO.updateFilm(film,languageId);
		}catch(Exception e){
			throw e;
		}
		return flag;
	}
	public boolean deleteFilm(int filmId) throws Exception {
		boolean flag = false;
		try{
			flag = filmDAO.deleteFilm(filmId);
		}catch(Exception e){
			throw e;
		}
		return flag;
	}

}
