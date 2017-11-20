package com.vedio.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.vedio.Imp.VedioService;
import com.vedio.dao.VedioDAO;

public class DeleteAction extends ActionSupport {
	private String num;
	
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
//		String json="{"+"\"no\":\"1\",\"name\":\"dasd\"}";
//		System.out.println(json);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		VedioService vs = new VedioService();
		ArrayList<VedioDAO> arr = new ArrayList<VedioDAO>();
		arr=vs.getNameList();
		if(arr==null)
		{
			return ERROR;
		}
		PrintWriter out;
		try{
			JSONArray json = new JSONArray();
			String jsonStr= json.fromObject(arr).toString();
			out=response.getWriter();
			out.print(jsonStr);
			out.flush();
			out.close();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
