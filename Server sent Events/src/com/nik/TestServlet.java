package com.nik;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/event-stream"); 
	        //cache must be set to no-cache
	        response.setHeader("Cache-Control", "no-cache");     
	        //encoding is set to UTF-8
	        response.setCharacterEncoding("UTF-8");

	        PrintWriter writer = response.getWriter();

	        for(int i=0; i<10; i++) {
	            System.out.println(i);
	            writer.write("data: "+ i +"\n\n");
	            writer.flush();
	            try {
	                Thread.sleep(3000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	        writer.close(); 
	}

}
