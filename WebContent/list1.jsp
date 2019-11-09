<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@  include file="inn.jsp" %>

<html>
<head>
<meta charset="utf-8">
<title>英雄信息展示页面</title>
<%-- <%
 List<record> list1=(List<record>)session.getAttribute("list"); 
 //System.out.println("ppppp"+list1.get(1).getCname());
  /* if(list1==null){
	 response.sendRedirect("inquire.jsp");
} */   
  
%> --%>
<%
	record oldst=(record)session.getAttribute("ol");
%>
</head>
<body>
<table align="center" width="600px" height="200px" border="1px" bgcolor="#ccffcc">
<tr bgcolor="#ffccff" align="center">
<td colspan="7">
  英雄信息展示
</td>
</tr>
<tr>
<td>英雄战斗值排行</td>
<td>英雄姓名</td>
<td>英雄性别</td>
<td>英雄年龄</td>
<td>英雄简介</td>
<td>英雄图片</td>
</tr>
 
<tr>
<td><%=oldst.getIDnumber() %></td>
<td><%=oldst.getCname() %></td>
<td><%=oldst.getSex() %></td>
<td><%=oldst.getAge() %></td>
<td><%=oldst.getIntroduce() %></td>


 
 
  <td >
     <a href="uppic/<%=oldst.getFname() %>">
     <img src="uppic/<%=oldst.getFname() %>" width="120" height="110" />
     </a>
     </td>
     
   </tr>  
</table>
<p align="center">
<a href="inquire.jsp">返回继续查看</a>
</p>
</body>
</html>