package edu.java.web.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClientExample {
	public static void main(String[] args) throws IOException {
		try {
			URL url = new URL("http://google.com");//???????????????????????? http://google.com thi ok
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			
			int responseCode = con.getResponseCode();
			System.out.println("Response Code :"+ responseCode);
			
			BufferedReader reader =new  BufferedReader(new InputStreamReader(con.getInputStream()));
			String line;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();// ????????????????????????
		} finally {
		}
	}
}
