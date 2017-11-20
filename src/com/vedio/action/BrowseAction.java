



package com.vedio.action;


import java.awt.List;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.catalina.Session;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.vedio.Imp.VedioService;

public class BrowseAction extends ActionSupport{
	
	public String execute() throws Exception{
		ActionContext ac = ActionContext.getContext();
		Map session=ac.getSession();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
//		session.put("user", "admin");
//		String directory = ServletActionContext.getServletContext().getRealPath("/vedio");
//		String[] path=directory.split("\\\\");
//		String newpath="";
//		for(int i =0;i<3;i++)
//		{
//			newpath+=path[i]+"\\";
//		}
//		newpath+="VedioManager\\WebContent\\vedio\\";
		ArrayList<String> fileName=new ArrayList<String>();
		VedioService vs=new VedioService();
		fileName=vs.getName();
		
//		PrintWriter out;
//		out=response.getWriter();
//		out.print(Json);
//		out.flush();
//		out.close();
//		System.out.println("hello");
//		JSONArray js= new JSONArray().fromObject(fileName);
//		System.out.println(js);
//		System.out.println("hello");
		session.put("vedioList", fileName);
		return SUCCESS;
		
	}
	
	
	
	public String SplitPath(String path)
	{
		String[] arrPath=path.split("\\\\");
		
		int length=arrPath.length;
		return arrPath[length-1];
	}
}
