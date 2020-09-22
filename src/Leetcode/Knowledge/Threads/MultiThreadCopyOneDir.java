package Leetcode.Knowledge.Threads;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MultiThreadCopyOneDir implements Runnable{

	File startfile;
	File endfile;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			FileInputStream filein=new FileInputStream(this.startfile);
			FileOutputStream fileout=new FileOutputStream(this.endfile);
			byte[] buffer=new byte[1024*1024];
			int len=filein.read(buffer,0,buffer.length);
			while(len>0)
			{
				fileout.write(buffer, 0, len);
				len=filein.read(buffer, 0, buffer.length);
			}
			filein.close();
			fileout.close();
			// 
			System.out.println(startfile.getName()+"    OK");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void Copy()
	{
		String source="F:\\JAVASource";
		String destination="F:\\JAVATest";
		
		File[] files=new File(source).listFiles();
		Thread[] t=new Thread[files.length];
		
		for(int i=0;i<files.length;i++)
		{
			MultiThreadCopyOneDir current=new MultiThreadCopyOneDir();
			current.startfile=files[i];
			current.endfile=new File(destination+File.separator+files[i].getName()); //Ŀ���ļ�
			t[i]=new Thread(current);
			t[i].start();
		}
		//System.out.println("Directory Copy OK");
	}
	
	public static void main(String[] args) {
		Copy();
	}

}
