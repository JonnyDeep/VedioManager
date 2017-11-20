package com.vedio.Imp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vedio.dao.*;
import com.vedio.inter.UserInterface;
import com.vedio.tools.DBHelper;
public class UserService implements UserInterface {
	public String login(UserDAO user)
	{
		Connection con = DBHelper.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;

		
		String sql="select * from tb_user where userName="+"\'"+user.getUserName()+"\'";
		try {

			ps=con.prepareStatement(sql);
			rs= ps.executeQuery();
			if(!rs.next()){
	
				return "failed";
			}
			rs.previous();
			while(rs.next())
			{
				if(user.getPassword().equals(rs.getString(4)))
				{
					
					return rs.getString(5);
				}else{
					return "failed";
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.closeConnection(con, ps,rs);
		}
		return null;
	}
	

}
