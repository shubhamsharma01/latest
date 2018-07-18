package service;

import java.sql.SQLException;

import daoOperation.LoginDao;

public class LoginService 
{

	public String fetchrole(String username)
	{
		LoginDao dao=new LoginDao();
		String role="maker";
		try {
			role = dao.fetchRole(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return role;
	}
	
}
