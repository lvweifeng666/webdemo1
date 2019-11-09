package com.util1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class AJAXUtils {
  public static  void printString(HttpServletResponse response,String s){
	  response.setCharacterEncoding("utf-8");
	  try {
		PrintWriter out=response.getWriter();
		System.out.println("json:"+s);
		out.print(s);
		
		out.flush();
		out.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}
