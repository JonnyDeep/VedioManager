package com.vedio.tools;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {
	 public static final String URL = "jdbc:mysql://localhost:3306/vediomanager";  
	    public static final String  DRIVE_CLASS= "com.mysql.jdbc.Driver";  
	    public static final String USER = "root";  
	    public static final String PASSWORD = "123456";  
	  
	    public Connection conn = null;  
	    public PreparedStatement pst = null;  
	  
	    public static Connection getConnection(){
			Connection con=null;
			try{
				Class.forName(DRIVE_CLASS);
			}catch(ClassNotFoundException e){
				System.out.println("驱动加载出错");
				e.printStackTrace();
			}
			
			try {
				con=DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println("数据库连接出错");
				e.printStackTrace();
			}
			return con;
		}
		
		public static void closeConnection(Connection con,PreparedStatement pStmt){
			if(pStmt!=null)
			{
				try{
					pStmt.close();
					pStmt=null;
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			
			try{
				if(con!=null&&con.isClosed()==false){
					con.close();
					con=null;
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		
		public void closeConnection(Connection con,Statement stmt)
		{	
			if(stmt!=null)
			{
				try
				{
					stmt.close();
					stmt=null;
				} catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				if(con!=null && con.isClosed()==false)
				{
					con.close();
					con=null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		public static void closeConnection(Connection con,Statement stmt,ResultSet res)
		{
			if(res!=null)
			{
				try
				{
					res.close();
					res=null;
				} catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(stmt!=null)
			{
				try
				{
					stmt.close();
					stmt=null;
				} catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				if(con!=null && con.isClosed()==false)
				{
					con.close();
					con=null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public static void closeConnection(Connection con,PreparedStatement pStmt,ResultSet res)
		{
			if(res!=null)
				try {
					res.close();
					res=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(pStmt!=null)
				try {
					pStmt.close();
					pStmt=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			try {
				if(con!=null && con.isClosed()==false)
				{
					con.close();
					con=null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
