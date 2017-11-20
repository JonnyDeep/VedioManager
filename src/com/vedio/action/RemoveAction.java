package com.vedio.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.vedio.Imp.VedioService;
import com.vedio.dao.VedioDAO;

public class RemoveAction extends ActionSupport{
	
	private String vedioList;
	
	public String getVedioList() {
		return vedioList;
	}

	public void setVedioList(String vedioList) {
		this.vedioList = vedioList;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		
		JSONArray jsonarray=JSONArray.fromObject(vedioList);
		
		
		ArrayList<VedioDAO> arr=new ArrayList<VedioDAO>();
		for(int i=0;i<jsonarray.size();i++)
		{
			
			JSONObject obj=jsonarray.getJSONObject(i);
			obj.remove("0");
			VedioDAO vd=(VedioDAO)JSONObject.toBean(obj,VedioDAO.class);
			arr.add(vd);
		}
		
		VedioService vs=new VedioService();
		if(vs.delete(arr).equals("failed"))
		{
			return ERROR;
		}
		
		arr=vs.getNameList();
		PrintWriter out;
		try {
			out=response.getWriter();
			JSONArray json=JSONArray.fromObject(arr);
			
			out.print(json.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
