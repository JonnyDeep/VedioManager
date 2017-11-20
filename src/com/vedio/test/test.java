package com.vedio.test;

import java.sql.Connection;

import com.vedio.Imp.UserService;
import com.vedio.dao.UserDAO;
import com.vedio.tools.DBHelper;

public class test {
	
public static void main(String[] args) {
	final Person person;
	person=new Person("tom");
	System.out.println(person);

	
//	Connection con=DBHelper.getConnection();
//	UserDAO user=new UserDAO();
//	user.setName("admin");
//	user.setPassword("admin");
//	user.setUserName("admin");
//	UserService us=new UserService();
//	String info=us.login(user);
//	System.out.println(info);
//	VedioService vs=new VedioService();
//	String json="[{\"0\":true,\"date\":\"2017-02-03\",\"id\":13,\"url\":\"生活大爆炸.The.Big.Bang.Theory.S10E02.中英字幕.HDTVrip.1024X576.mp4\",\"url_host\":\"fyaycvvqewqddvkuwfyom3ewbsnpzv.mp4\"},{\"0\":true,\"date\":\"2017-02-03\",\"id\":14,\"url\":\"生活大爆炸.The.Big.Bang.Theory.S10E03.中英字幕.HDTVrip.1024X576.mp4\",\"url_host\":\"arqradkzehf0u9pkngeiqzuiceliw2.mp4\"}]";
//	
//	JSONArray jsonarray=JSONArray.fromObject(json);
//	
//	ArrayList<VedioDAO> arr=new ArrayList<VedioDAO>();
//	for(int i=0;i<jsonarray.size();i++)
//	{
//		
//		JSONObject obj=jsonarray.getJSONObject(i);
//		obj.remove("0");
//		VedioDAO vd=(VedioDAO)JSONObject.toBean(obj,VedioDAO.class);
//		arr.add(vd);
//	}
	
//	for(int i=0;i<arr.size();i++)
//	{
//		System.out.println(arr.get(i).getUrl());
//	}
}
}

class Person{
	public Person(String name){
		this.name=name;
	}
	
	String name;
}
