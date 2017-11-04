package edu.java.web;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;

public class GZipServletOutputStream extends ServletOutputStream{
	
	private GZIPOutputStream stream = null;
	
	@Override
	public void write(int b) throws IOException {
		// TODO Auto-generated method stub
	}
	
	public GZipServletOutputStream(OutputStream output) throws IOException {
		GZIPOutputStream stream = new GZIPOutputStream(output);
	}
	
	
}
