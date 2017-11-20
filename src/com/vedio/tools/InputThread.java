package com.vedio.tools;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class InputThread extends Thread{
	private File file;
	private File savefile;
	public InputThread(File file,File savefile)
	{
		super();
		this.file=file;
		this.savefile=savefile;
	}
	
	public void run()
	{
		try {
			FileUtils.copyFile(file, savefile);
			sleep(100);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
