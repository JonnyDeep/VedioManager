package com.vedio.Imp;

import java.awt.image.DataBufferInt;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;

import com.vedio.dao.VedioDAO;
import com.vedio.inter.VedioInterface;
import com.vedio.tools.DBHelper;

public class VedioService implements VedioInterface {

	@Override
	public String upload(VedioDAO vedio) {
		// TODO Auto-generated method stub
		Connection con = DBHelper.getConnection();
		String sql="insert tb_url(url,url_host,date) values (?,?,?)";
		PreparedStatement prs=null;
		if(check(vedio).equals("failed"))
		{
			return "failed";
		}
		try {
			prs = con.prepareStatement(sql);
			
			prs.setString(1, vedio.getUrl());
			prs.setString(2, vedio.getUrl_host());
			prs.setString(3, vedio.getDate());
			int flag=prs.executeUpdate();
			if(flag>0)
			{
				return "success";
			}else{
				return "failed";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.closeConnection(con,prs);
		}
		return null;
	}



	@Override
	public String check(VedioDAO vedio) {
		// TODO Auto-generated method stub
		Connection con= DBHelper.getConnection();
		PreparedStatement prs=null;
		ResultSet rs=null;
		String sql="select * from tb_url where url="+"\'"+vedio.getUrl()+"\'";
		try {
			prs= con.prepareStatement(sql);
			rs=prs.executeQuery();
			if(rs.next())
			{
				return "failed";
			}else{
				return "success";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.closeConnection(con, prs, rs);
		}
		return null;
	}

	@Override
	public String getName(VedioDAO vedio) {
		// TODO Auto-generated method stub
		Connection con = DBHelper.getConnection();
		PreparedStatement prs=null;
		ResultSet rs= null;
		String sql="select * from tb_url where url=\'"+vedio.getUrl().trim()+"\' and date=\'"+vedio.getDate().trim()+"\'";

		try {
			prs=con.prepareStatement(sql);
			rs=prs.executeQuery();
			if(rs.next())
			{
				return rs.getString(3);
			}else{
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.closeConnection(con, prs,rs);
		}
		return null;
	}

	@Override
	public ArrayList<String> getName() {
		// TODO Auto-generated method stub
		Connection con = DBHelper.getConnection();
		PreparedStatement prs=null;
		ResultSet rs= null;
		String sql="select * from tb_url";
		ArrayList<String> arr=new ArrayList<String>(); 
		try{
			prs=con.prepareStatement(sql);
			rs=prs.executeQuery();
			while(rs.next())
			{
				if(!arr.contains(rs.getString(4)))
				{
					arr.add(rs.getString(4));
				}
				arr.add(rs.getString(2));
				
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBHelper.closeConnection(con, prs,rs);
		}
		return arr;
	}

	@Override
	public ArrayList<VedioDAO> getNameList() {
		// TODO Auto-generated method stub
		Connection con = DBHelper.getConnection();
		PreparedStatement prs=null;
		ResultSet rs= null;
		String sql="select * from tb_url";
		ArrayList<VedioDAO> arr=new ArrayList<VedioDAO>(); 
		try{
			prs=con.prepareStatement(sql);
			rs=prs.executeQuery();
			while(rs.next())
			{
				VedioDAO vd=new VedioDAO();
				vd.setId(rs.getInt(1));
				vd.setUrl(rs.getString(2));
				vd.setUrl_host(rs.getString(3));
				vd.setDate(rs.getString(4));
				arr.add(vd);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBHelper.closeConnection(con, prs,rs);
		}
		return arr;
	}



	@Override
	public String delete(ArrayList<VedioDAO> arr) {
		// TODO Auto-generated method stub
		Connection con=DBHelper.getConnection();
		PreparedStatement prs=null;
		
		String sql1="select * from tb_url where id=?";
		ResultSet rs=null;
		ArrayList<String> fileName=new ArrayList<String>();
		try{
			for(int i=0;i<arr.size();i++)
			{
				prs=con.prepareStatement(sql1);
				prs.setInt(1, arr.get(i).getId());
				rs=prs.executeQuery();
				if(rs.next())
				{
					fileName.add(rs.getString("date")+"\\"+rs.getString("url_host"));
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			String directory = ServletActionContext.getServletContext().getRealPath("/vedio");
			for(int i=0;i<fileName.size();i++)
			{
				
				File file=new File(directory+"\\"+fileName.get(i));
				if(file.isFile()&&file.exists()){
					file.delete();
				}
			}
		}
		
		String sql="delete from tb_url where id=?";
		String flag="failed";
		
		try {
			con.setAutoCommit(false);
			prs=con.prepareStatement(sql);
			for(int i=0;i<arr.size();i++)
			{
				prs.setInt(1, arr.get(i).getId());
				
				prs.addBatch();
			}
			prs.executeBatch();
			con.commit();
			
			flag="success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}finally{
			DBHelper.closeConnection(con, prs,rs);
		}

		return flag;
	}
	
}
