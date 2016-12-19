package pers.zhentao.exam.dao;

import java.util.List;

import pers.zhentao.exam.vo.Film;
import pers.zhentao.exam.vo.Language;

public interface IFilmDAO {
	public int getFilmCount()throws Exception;
	public List<Film> getFilm(int pageSize,int pageNow) throws Exception;
	public boolean addFilm(Film film,int languageId)throws Exception;
	public List<Language> getLanguage()throws Exception;
	public Film getFilmById(int filmId)throws Exception;
	public boolean updateFilm(Film film,int languageId)throws Exception;
	public boolean deleteFilm(int filmId)throws Exception;
}
