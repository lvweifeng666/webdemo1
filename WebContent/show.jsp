<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>  
     <%@ page import="com.biz.*" %>
      <%@ include file="inn.jsp" %>
       <jsp:useBean id="st1" class="com.bean.record" scope="request"></jsp:useBean>
       <jsp:setProperty property="*" name="st1"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>学生信息判断</title>
</head>
<body>
<%-- <%
ISbiz1 ss1=new Sbiz1();
String s=request.getParameter("oop");
int oop=Integer.parseInt(s);
switch(oop){
case 1://增加
boolean flag=ss1.save1(st1);

//System.out.print(flag);
 if(flag){
	   response.sendRedirect("show.jsp?oop=5");
	  // response.sendRedirect("ok.jsp");
	  
 }else{
	   response.sendRedirect("error1.jsp");
 } 
 
	break;
case 2://修改
	 flag=ss1.update1(st1);
	   if(flag){
		   response.sendRedirect("show.jsp?oop=5");
		   return;
	   }else{
		   response.sendRedirect("error.jsp");
	   }
	break;
case 3://删除
	 String cname=request.getParameter("cname");
	  flag=ss1.delByname(cname);
	   if(flag){
		//System.out.println("kjjjjjjjjjjjjjjjjjj"+flag);
		   response.sendRedirect("show.jsp?oop=5");
		 //  System.out.println("kjjjjjjjjjjjjjjjjjj"+flag);
		   return;
	   }else{
		   response.sendRedirect("error.jsp");
	   }
	break;
case 4://单个查询
	cname=request.getParameter("cname");
	//System.out.println("kjjjjjjjjjjjjjjjjjj"+"   "+cname);
	record oldst=ss1.findbyname(cname);
	//System.out.println("kjjjjjjjjjjjjjjjjjj"+oldst);
	session.setAttribute("oldst", oldst);
	response.sendRedirect("update.jsp");
	break;
case 5://查询
    List<record> list1=ss1.findAll();
    session.setAttribute("list", list1);
    response.sendRedirect("list.jsp");
 	break;
case 6://单个查询
	cname=request.getParameter("cname");
	System.out.println("kjjjjjjjjjjjjjjjjjj"+"   "+cname);
	record ol=ss1.findbyname(cname);
	System.out.println("kjjj"+ol);
	session.setAttribute("ol", ol);
	response.sendRedirect("list1.jsp");
	break;
} %>
 --%>
 <%
String oop=request.getParameter("oop");
 System.out.println(oop+"jdjhhjdhjdjhjhdjhdjhhdhdhdhdh");
%>
<jsp:forward page="RecordServletTest">
<jsp:param value="<%=oop%>" name="oop"></jsp:param>
</jsp:forward>
</body>
</html>