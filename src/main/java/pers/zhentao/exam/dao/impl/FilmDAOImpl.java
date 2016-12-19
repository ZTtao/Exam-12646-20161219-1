package pers.zhentao.exam.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pers.zhentao.exam.dao.IFilmDAO;
import pers.zhentao.exam.vo.Film;
import pers.zhentao.exam.vo.Language;

public class FilmDAOImpl implements IFilmDAO {

	private Connection conn = null;
	private PreparedStatement statement = null;
	public FilmDAOImpl(Connection conn){
		this.conn = conn;
	}
	public int getFilmCount() throws Exception {
		int count = 0;
		try{
		String sql = "select count(*) from film";
		this.statement = this.conn.prepareStatement(sql);
		ResultSet set = this.statement.executeQuery();
		if(set.next()){
			count = set.getInt(1);
		}
		}catch(Exception e){
			throw e;
		}finally{
			if(this.statement != null){
				try{
					this.statement.close();
				}catch(Exception e){
					throw e;
				}
			}
		}
		return count;
	}
	public List<Film> getFilm(int pageSize, int pageNow) throws Exception {
		List<Film> list = new ArrayList<Film>();
		try{
		String sql = "select a.film_id,a.title,a.description,a.name from (select f.film_id,f.title,f.description,l.name from film f,language l where f.language_id=l.language_id order by f.last_update desc) a where 1 limit ?,?";
		this.statement = this.conn.prepareStatement(sql);
		this.statement.setInt(1, (pageNow-1)*pageSize);
		this.statement.setInt(2, pageSize);
		ResultSet set = this.statement.executeQuery();
		while(set.next()){
			Film film = new Film();
			film.setFilmId(set.getInt(1));
			film.setTitle(set.getString(2));
			film.setDescription(set.getString(3));
			film.setLanguageName(set.getString(4));
			list.add(film);
		}
		}catch(Exception e){
			throw e;
		}finally{
			if(this.statement != null){
				try{
					this.statement.close();
				}catch(Exception e){
					throw e;
				}
			}
		}
		return list;
	}
	public boolean addFilm(Film film,int languageId) throws Exception {
		boolean flag = false;
		try{
		String sql = "insert into film(title,description,language_id)values(?,?,?)";
		this.statement = this.conn.prepareStatement(sql);
		this.statement.setString(1, film.getTitle());
		this.statement.setString(2, film.getDescription());
		this.statement.setInt(3, languageId);
		int count = this.statement.executeUpdate();
		if(count > 0)flag = true;
		}catch(Exception e){
			throw e;
		}finally{
			if(this.statement != null){
				try{
					this.statement.close();
				}catch(Exception e){
					throw e;
				}
			}
		}
		return flag;
	}
	public List<Language> getLanguage() throws Exception {
		List<Language> list = new ArrayList<Language>();
		try{
		String sql = "select language_id,name from language";
		this.statement = this.conn.prepareStatement(sql);
		ResultSet set = this.statement.executeQuery();
		while(set.next()){
			Language language = new Language();
			language.setLanguageId(set.getInt(1));
			language.setName(set.getString(2));
			list.add(language);
		}
		}catch(Exception e){
			throw e;
		}finally{
			if(this.statement != null){
				try{
					this.statement.close();
				}catch(Exception e){
					throw e;
				}
			}
		}
		return list;
	}
	public Film getFilmById(int filmId) throws Exception {
		Film film = new Film();
		try{
		String sql = "select film_id,title,description,language_id from film where film_id=?";
		this.statement = this.conn.prepareStatement(sql);
		this.statement.setInt(1, filmId);
		ResultSet set = this.statement.executeQuery();
		if(set.next()){
			film.setFilmId(set.getInt(1));
			film.setTitle(set.getString(2));
			film.setDescription(set.getString(3));
			film.setLanguageId(set.getInt(4));
		}
		}catch(Exception e){
			throw e;
		}finally{
			if(this.statement != null){
				try{
					this.statement.close();
				}catch(Exception e){
					throw e;
				}
			}
		}
		return film;
	}
	public boolean updateFilm(Film film, int languageId) throws Exception {
		boolean flag = false;
		try{
		String sql = "update film set title=?,description=?,language_id=? where film_id=?";
		this.statement = this.conn.prepareStatement(sql);
		this.statement.setString(1, film.getTitle());
		this.statement.setString(2, film.getDescription());
		this.statement.setInt(3, languageId);
		this.statement.setInt(4, film.getFilmId());
		int count = this.statement.executeUpdate();
		if(count > 0)flag = true;
		}catch(Exception e){
			throw e;
		}finally{
			if(this.statement != null){
				try{
					this.statement.close();
				}catch(Exception e){
					throw e;
				}
			}
		}
		return flag;
	}
	public boolean deleteFilm(int filmId) throws Exception {
		boolean flag = false;
		try{
		String sql = "delete from film where film_id=?";
		this.statement = this.conn.prepareStatement(sql);
		this.statement.setInt(1, filmId);
		int count = this.statement.executeUpdate();
		if(count > 0)flag = true;
		}catch(Exception e){
			throw e;
		}finally{
			if(this.statement != null){
				try{
					this.statement.close();
				}catch(Exception e){
					throw e;
				}
			}
		}
		return flag;
	}

}
