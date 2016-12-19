package pers.zhentao.exam.dao;

import pers.zhentao.exam.vo.Customer;

public interface IUserDAO {
	public Customer login(String firstName) throws Exception;
}
