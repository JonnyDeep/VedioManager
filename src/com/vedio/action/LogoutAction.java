package com.vedio.action;

import java.util.Map;



import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport{
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext ac=ActionContext.getContext();
		Map session = ac.getSession();
		session.clear();
		return SUCCESS;
	}
}
