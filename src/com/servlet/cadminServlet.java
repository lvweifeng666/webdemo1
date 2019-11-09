package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.cadmin;
import com.biz.ISbiz;
import com.biz.Sbiz;


public class cadminServlet extends HttpServlet {
	
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
	//	cadmin st=(cadmin)request.getAttribute("st");
		
		ISbiz ss=new Sbiz();
		int op=Integer.parseInt(request.getParameter("op"));
		cadmin st=(cadmin)request.getAttribute("st");
		switch(op){
		case 1://增加
		  boolean flag=ss.save(st);
		   if(flag){
			 // response.sendRedirect("dosv.jsp?op=5");
			  response.sendRedirect("ok.jsp");
			   return;
		   }else{
			   response.sendRedirect("error.jsp");
		   } 
		   
			break;
		case 2://修改
			flag=ss.update(st);
			   if(flag){
				   response.sendRedirect("dosv.jsp?op=5");
				   return;
			   }else{
				   response.sendRedirect("error.jsp");
			   }
			break;

		case 3://删除
			 
		      String cid=request.getParameter("st");
			 flag= ss.delByid(st);
			   if(flag){
				   response.sendRedirect("dosv.jsp?op=5");
				   return;
			   }else{
				   response.sendRedirect("error.jsp");
			   }
			break;


		 case 4://单个查询
			 cid=request.getParameter("st");
				cadmin oldst=ss.findbyid(st);
				session.setAttribute("oldst", oldst);
				response.sendRedirect("update.jsp");
				break; 
		     case 5://显示
		      List<cadmin> list=ss.findAll();
		      session.setAttribute("list", list);
		  	   String sname=request.getParameter("text1");
		  	 System.out.println("size"+list.size());
		  	 System.out.println("dddddddddd555555555"+sname);
		  	List<String> listNames = new ArrayList<String>();;
		  	for(cadmin st1:list) {
		  		if(st1.getSname().equals(sname)) {
		  		response.sendRedirect("ok1.jsp");
		  		return;
		  		  }
		  	}
		  	response.sendRedirect("error1.jsp");
		  	  break;
	}

}
}