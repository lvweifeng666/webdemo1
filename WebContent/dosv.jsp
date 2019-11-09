<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@ page import="com.biz.*"%>
    <%@ include file="inn.jsp" %>
    <jsp:useBean id="st" class="com.bean.cadmin" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="st"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>信息更改</title>
<%-- 
 <%ISbiz ss=new Sbiz();
String s=request.getParameter("op");
int op=Integer.parseInt(s);
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
  		   
  		   for(cadmin st1:list){
  		 System.out.println(st1.getSname());
  		  if(st1.getSname().equals(sname)){
  	
  			 System.out.println("dddddddddd00000jjjjjj"+st1.getSname());
  		response.sendRedirect("ok1.jsp");  
  		//return;
  		  }else{
  			response.sendRedirect("error1.jsp");  
  	  		 return;
  		  }
  		  } 
  	  break;
} %>  --%>
<% String op=request.getParameter("op");
System.out.println("jdjhhjdhjdjhjhdjhdjhhdhdhdhdh"+op);
%>
<jsp:forward page="cadminServletTest">
<jsp:param value="<%=op%>" name="op"></jsp:param>
</jsp:forward> 
</head>
<body>

</body>
</html>