package daoOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionI;
import connection.OracleConnection;

public class LoginDao implements LoginDaoI
{
	Connection conn=null;
	ConnectionI c=null;
	public boolean fetchUser(String u,String p) throws SQLException
	{
		c=new OracleConnection();
		conn=c.myConnection();
		
		PreparedStatement ps=conn.prepareStatement("select username,userpassword from auser where username=? and userpassword=?");  
		ps.setString(1,u);  
		ps.setString(2,p);  
	      
		ResultSet rs=ps.executeQuery();  
		boolean status=rs.next();
		return status;  
		
	}
	
	public String fetchRole(String u) throws SQLException
	{
		c=new OracleConnection();
		conn=c.myConnection();
		String role="maker";
		PreparedStatement ps=conn.prepareStatement("select arole.rolename from arole,auser where auser.roleid=arole.roleid AND username=?");  
		ps.setString(1,u);  
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			role=rs.getString(1);
		}
		return role;
		
	}
	
}
