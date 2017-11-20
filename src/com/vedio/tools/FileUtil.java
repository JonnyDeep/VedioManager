package com.vedio.tools;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

public class FileUtil {
	private static final int BUFFER_SIZE = 32*1024;
	
	public static void uploadFIle(File src,File dst) throws IOException{
		InputStream in = null;
		OutputStream out = null;
		
		try{
			in = new BufferedInputStream(new FileInputStream(src),BUFFER_SIZE);
			out = new BufferedOutputStream(new FileOutputStream(dst),BUFFER_SIZE);
			
			byte[] buffer =new byte[BUFFER_SIZE];
			while(in.read(buffer)>0);
			{
				out.write(buffer);
			}
			
		}finally{
			if(null!=in)
			{
				in.close();
			}
			if(null!=out)
			{
				out.close();
			}
		}
	}
	
	public static void makeDir(String directory) {   
        File dir = new File(directory);   
  
        if (!dir.isDirectory()) {   
            dir.mkdirs();   
        }   
  
    }
	
	public static String getRandomString(int length) { //length表示生成字符串的长度  
	    String base = "abcdefghijklmnopqrstuvwxyz0123456789";     
	    Random random = new Random();     
	    StringBuffer sb = new StringBuffer();     
	    for (int i = 0; i < length; i++) {     
	        int number = random.nextInt(base.length());     
	        sb.append(base.charAt(number));     
	    }     
	    return sb.toString();     
	 } 
	
}
