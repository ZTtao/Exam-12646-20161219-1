package pers.zhentao.exam.dao.proxy;

import pers.zhentao.exam.dao.IUserDAO;
import pers.zhentao.exam.dao.impl.UserDAOImpl;
import pers.zhentao.exam.dbc.DatabaseConnection;
import pers.zhentao.exam.vo.Customer;

public class UserDAOProxy implements IUserDAO{
	private DatabaseConnection dbc = null;
	private IUserDAO userDAO = null;
	
	public UserDAOProxy(){
		try{
			this.dbc = new DatabaseConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		this.userDAO = new UserDAOImpl(this.dbc.getConnection());
	}
	public Customer login(String firstName) throws Exception {
		Customer cus = null;
		try{
			cus = this.userDAO.login(firstName);
		}catch(Exception e){
			throw e;
		}
		return cus;
	}

}
