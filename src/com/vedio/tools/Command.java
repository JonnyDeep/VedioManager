package com.vedio.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Command {
	public static int exeCmd(String commandStr) {  
        BufferedReader br = null;
        BufferedReader err =null;
        int code=1;
        try {  
            Process p = Runtime.getRuntime().exec(commandStr);  
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));  
            err = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String line = null;  
            StringBuilder sb = new StringBuilder();  
            while ((line = br.readLine()) != null) {  
                sb.append(line + "\n"); 
                System.out.println(sb.toString());
            }
            String data = null;
            while ((data = br.readLine()) != null) {  
                sb.append(data + "\n");  
                System.out.println(sb.toString());
            } 
            code=p.waitFor();
            
            
        } catch (Exception e) {  
            e.printStackTrace();  
        }   
        finally  
        {  
            if (br != null)  
            {  
                try {  
                    br.close();  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
        } 
        return code;
    }  
	public static void main(String[] args) throws IOException {
		String command="cmd.exe /C start mp4box.exe -isma "+"F:\\Downloads\\movie\\FLash\\01.mp4";

		int code=Command.exeCmd(command);
		System.out.println(code);
	}
}
