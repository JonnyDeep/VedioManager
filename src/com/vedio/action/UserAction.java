package com.vedio.action;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.vedio.Imp.UserService;
import com.vedio.Imp.VedioService;
import com.vedio.dao.UserDAO;

public class UserAction extends ActionSupport {
	private UserDAO user;

	public UserDAO getUser() {
		return user;
	}

	public void setUser(UserDAO user) {
		this.user = user;
	}
	
	public String execute() throws Exception{
		UserService us =new UserService();
		String result = us.login(user);
		ActionContext context=ActionContext.getContext();
		Map session=context.getSession();
		
		if(result.equals("0"))
		{
			session.put("user",user.getUserName());
	
			return SUCCESS;
		}else if(result.equals("failed")){
			return ERROR;
		}else{
			ArrayList<String> fileName=new ArrayList<String>();
			VedioService vs=new VedioService();
			fileName=vs.getName();
			session.put("user",user.getUserName());
			session.put("vedioList", fileName);
			return INPUT;
		}
	}
}
