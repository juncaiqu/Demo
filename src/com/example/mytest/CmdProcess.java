package com.example.mytest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import android.util.Log;

public class CmdProcess {

	private StringBuilder inSb;
	private StringBuilder errSb;
	public boolean isInReadEnd;
	public boolean isErrReadEnd;
	private long startTime;
	private long readupdateTime;

	public CmdProcess() {
		inSb = new StringBuilder();
		errSb = new StringBuilder();
		isInReadEnd = false;
		isErrReadEnd = false;
	} 

	public String result() {

		while (!(isInReadEnd && isErrReadEnd) && System.currentTimeMillis() - startTime < 1000) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		String result = inSb.toString() + errSb;
		inSb.setLength(0);
		errSb.setLength(0);
		return result;
	}

	
	public void exceut(String cmd) throws Exception {
		startTime = System.currentTimeMillis();
		readupdateTime = System.currentTimeMillis();
		Process shProcess = null;
		try {
			String[] command = { "/system/bin/sh","-c", (cmd) };
			shProcess = Runtime.getRuntime().exec(command);	
		} catch (Exception e) {
			Log.i("qujc", e.getMessage());
			errSb.append("Cmd Error");
			return;
		}
		shProcess.destroy();
		shProcess = null;
	}
	
	
	public void readToString(InputStream is, StringBuilder sb){
		InputStreamReader isr;
		try {
			isr = new InputStreamReader(is, "gbk");
		
	        BufferedReader br = new BufferedReader(isr);
	        String line = null;
	        while ((line = br.readLine()) != null) {
	        	readupdateTime = System.currentTimeMillis();
	        	if(sb.length() < 20480){
	            	sb.append(line).append('\n');
	        	}else{
	        		break;
	        	}
	        }
	        br.close();
	        isr.close();
	        is.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
