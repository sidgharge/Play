package services;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Base64;

import models.Task;

public class HomeService {
	
	public String imgUrl;

	public String downloadImage(){
		System.out.println("Image thread id: " + Thread.currentThread().getId());
		URL url;
		try {
			url = new URL(imgUrl);
			InputStream in = new BufferedInputStream(url.openStream());
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int n = 0;
			while (-1 != (n = in.read(buf))) {
				out.write(buf, 0, n);
			}
			out.close();
			in.close();
			Task task = new Task();
			task.content = "hello";
			task.image = new String(Base64.getEncoder().encode(out.toByteArray()));
			task.save();
			System.out.println("Image downloaded...");
			return "abc";
		} catch (Exception e) {
			e.printStackTrace();
			return "Failed";
		}
		
	}
	
	public void readFile(){
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("/home/bridgeit/Sid/ToDoWorkSpace/ToDo/src/main/resources/ToDo.log"));
			
			String line = reader.readLine();
			StringBuilder builder = new StringBuilder();
			while(line != null){
				builder.append(line);
				line = reader.readLine();
			}
			System.out.println("Length: " + builder.toString().length());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
