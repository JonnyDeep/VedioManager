package com.vedio.action;

import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.URIDereferencer;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.vedio.Imp.VedioService;
import com.vedio.dao.VedioDAO;

public class ViewAction extends ActionSupport {
	private String date;
	private String param;
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
//		ActionContext context = ActionContext.getContext();
//		Map params = context.getParameters();
//		String date=(String) params.get("date");
//		String name=(String)params.get("param");
		
		ActionContext ac = ActionContext.getContext();
		Map session=ac.getSession();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		
		
		VedioService vs = new VedioService();
		VedioDAO vd=new VedioDAO();
		vd.setUrl(URLDecoder.decode(param,"utf-8"));
		vd.setDate(URLDecoder.decode(date,"utf-8"));
		String url=vs.getName(vd);
		
	
//		path+="VedioManager/WebContent/vedio/"+URLDecoder.decode(date,"utf-8").trim()+"/"+url;
//		System.out.println(path);
		if(url!=null)
		{
			session.put("url","../vedio/"+URLDecoder.decode(date,"utf-8").trim()+"/"+url);

			return SUCCESS;
		}else{
			return ERROR;
		}
//		System.out.println(vs.getName(vd));
		
		
	}
}
