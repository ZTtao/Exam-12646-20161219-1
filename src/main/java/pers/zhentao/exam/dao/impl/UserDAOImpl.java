package pers.zhentao.exam.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pers.zhentao.exam.dao.IUserDAO;
import pers.zhentao.exam.vo.Customer;

public class UserDAOImpl implements IUserDAO{

	private Connection conn = null;
	private PreparedStatement statement = null;
	
	public UserDAOImpl(Connection conn){
		this.conn = conn;
	}
	public Customer login(String firstName) throws Exception{
		Customer cus = null;
		try{
		String sql = "select * from customer where first_name=?";
		this.statement = this.conn.prepareStatement(sql);
		this.statement.setString(1, firstName);
		ResultSet set = this.statement.executeQuery();
		if(set.next()){
			cus = new Customer();
			cus.setCustomerId(set.getInt(1));
			cus.setStoreId(set.getInt(2));
			cus.setFirstName(set.getString(3));
			cus.setLastName(set.getString(4));
			cus.setEmail(set.getString(5));
			cus.setAddressId(set.getInt(6));
			cus.setActive(set.getBoolean(7));
			cus.setCreateDate(set.getDate(8));
			cus.setLastUpdate(set.getTimestamp(9));
		}
		}catch(Exception e){
			throw e;
		}finally{
			if(this.statement != null){
				try {
					this.statement.close();
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return cus;
	}

}
