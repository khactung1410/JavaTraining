package edu.java.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet( value ="/upload", name="upload-servlet")
@MultipartConfig(maxFileSize = 1024*1024*10)
public class UploadServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		PrintWriter writer = response.getWriter();

		String appPath = request.getServletContext().getRealPath("");
		writer.println("------------" + appPath);
		request.getParts().forEach((Part part) ->{
		String name = extractFileName(part);
		});
		for (Part part : request.getParts()) {
			Collection<String> headers = part.getHeaderNames();
			headers.forEach((header) -> {
				writer.println(header + ":" +part.getHeader(header));
			});
			writer.println("Upload has been done successfully!");
		};
		
		for(Part part : request.getParts()) {
			File folder = new File(appPath, "temp");
			if(!folder.exists()) folder.mkdir();
		}
		
		for(Part part :request.getParts()) {
			String name = extractFileName(part);
			byte[] buff = new byte[4*1204];
			int read = -1;
			FileOutputStream outputStream = new FileOutputStream(new File(name));
			try {
				InputStream inputStream = part.getInputStream();
				while((read = inputStream.read(buff)) != -1) {
					outputStream.write(read);
				}
			} finally {
				outputStream.close();
			}
		}
	}
	
	private String extractFileName(Part part) {
		String content = part.getHeader("content-disposition");
		Pattern pattern = Pattern.compile(".*filename\\=\"(.*)\".*");
		Matcher matcher = pattern.matcher(content);
		return matcher.matches()?matcher.group(1):"unknown";
	}
}