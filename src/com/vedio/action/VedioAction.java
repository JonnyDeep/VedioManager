package com.vedio.action;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.mapping.Array;

import com.opensymphony.xwork2.ActionSupport;
import com.vedio.Imp.VedioService;
import com.vedio.dao.VedioDAO;
import com.vedio.tools.Command;
import com.vedio.tools.FileUtil;
import com.vedio.tools.InputThread;


public class VedioAction extends ActionSupport{
	private List<File> uploadFile;
	private List<String> uploadFileFileName;
	public List<File> getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(List<File> uploadFile) {
		this.uploadFile = uploadFile;
	}
	public List<String> getUploadFileFileName() {
		return uploadFileFileName;
	}
	public void setUploadFileFileName(List<String> uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
	
	public String execute() throws Exception{
		
		String fileName="";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
//		ArrayList<InputThread> arrThread=new ArrayList<InputThread>();
		

		try{
			String directory = ServletActionContext.getServletContext().getRealPath("/vedio");
			String[] dir=directory.split("\\\\");
			String path="";
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			
			String time =sd.format(new Date());
//			System.out.println(directory);
//			for(int i = 0;i<3;i++)
//			{
//				path+=dir[i]+"\\";
//			}
//			path+="VedioManager\\WebContent\\vedio\\"+time;
			path=directory+"\\"+time;
			
			FileUtil.makeDir(path);
			
			for(int i=0;i<uploadFile.size();i++)
			{
				fileName = uploadFileFileName.get(i);
			
				String[] arr=fileName.split("\\.");
				String postfix=fileName.split("\\.")[arr.length-1];
				
				
				String newName =FileUtil.getRandomString(30)+"."+postfix;
				VedioDAO vedio = new VedioDAO();
                vedio.setUrl(fileName);
                vedio.setUrl_host(newName);
                vedio.setDate(time);
                VedioService vs = new VedioService();
                if(vs.upload(vedio).equals("failed"))
                {
                	return ERROR;
                }
				String filePath = path + File.separator + newName;
				
				
//                FileUtil.uploadFIle(uploadFile.get(i), new File(filePath));
//				System.out.println(filePath);
				File saveFile = new File(filePath);
				FileUtils.copyFile(uploadFile.get(i), saveFile);
//				InputThread thread=new InputThread(uploadFile.get(i),saveFile);
//				arrThread.add(thread);
               
                
//                String data="{"+"\"data\""+":"+"\"success\""+"}";
//                try {
//					PrintWriter out;
//					out=response.getWriter();
//					out.print(data);
//
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				System.out.println(filePath);
//				String command="cmd.exe /c start mp4box.exe -isma "+filePath;
//				int code=Command.exeCmd(command);
//				System.out.println(code);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
//		for(int i=0;i<arrThread.size();i++)
//		{
//			arrThread.get(i).start();
//			arrThread.get(i).join();
//		}

		response.setContentType("application/json");
		return SUCCESS;
	}
	
	
}
