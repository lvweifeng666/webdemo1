<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@  include file="inn.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${pb.pagelist==null}">
<c:redirect url="RecordServletTest?oop=5"></c:redirect>
</c:if>
<html>
<head>
<meta charset="utf-8">

<title>注册信息展示页面</title>
<%-- <%
 List<record> list1=(List<record>)session.getAttribute("list"); 
 //System.out.println("ppppp"+list1.get(1).getCname());
  /* if(list1==null){
	 response.sendRedirect("inquire.jsp");
} */   
  <% List<record> pb=(List<record>)session.getAttribute("pb");  %>
%> --%>

<script>
//更改每页记录数的函数
function docbangeRows(){
	var rows=document.form1.rows.value;
	if(isNaN(rows)){
	alter('输入正确数字！');
	document.form1.rows.value=${pb.rows};
	return;
	}
	window.location="RecordServletTest?oop=5&rows="+rows;
}
//跳转页数的函数
function docbangePage(){
	var page=document.form1.page.value;
	if(isNaN(page)){
	alter('输入正确数字！');
	document.form1.page.value=${pb.page};
	return;
	}
	window.location="RecordServletTest?oop=5&page="+page;
}
</script>
</head>
<body>
<table align="center" width="600px" height="200px" border="1px" bgcolor="#ccffcc">
<tr bgcolor="#ffccff" align="center">
<td colspan="60">
  信息展示
</td>
</tr>
<tr>
<td colspan="6">英雄战斗值排行</td>
<td colspan="6">英雄姓名</td>
<td colspan="6">英雄性别</td>
<td colspan="6">英雄年龄</td>
<td colspan="6">英雄简介</td>
<td colspan="6">信息修改</td>
</tr>
 <%-- <%
 for(record st:pb){
  for(record st:list1){
%>
<tr>
<td><%=st.getIDnumber() %></td>
<td><%=st.getCname() %></td>
<td><%=st.getSex() %></td>
<td><%=st.getAge() %></td>
<td><%=st.getIntroduce() %></td>
<td>
<a href="show.jsp?oop=3&cname=<%=st.getCname()%>">删除</a>
<a href="show.jsp?oop=4&cname=<%=st.getCname()%>">修改</a>
</td>
</tr>
<%}%> --%> 

  <c:forEach items="${pb.pagelist}" var="st">
  <tr align="center">
    <td colspan="6">${st.getIDnumber()} </td>  
    <td colspan="6">${st.getCname()}</td>
    <td colspan="6">${st.getSex()}</td>
    <td colspan="6">${st.getAge()}</td>
    <td colspan="6">${st.getIntroduce()}</td>
    
    
    <td colspan="2">
    <a href="RecordServletTest?oop=3&cname=${st.getCname()}">删除</a>
    <a href="RecordServletTest?oop=4&cname=${st.getCname()}">修改</a>
    </td>
    </tr>
 </c:forEach> 
 
</table>

<form action="" id="form1" name="form1" method="post">
<table align="center" width="600px" height="100px" border="1px" bgcolor="#ccffcc">
<tr align="center" bgcolor="#FFFF99">
    <td>
    <c:if test="${pb.page>1}">
    <a href="RecordServletTest?oop=5&page=1">
    </c:if>
    首页</a>
    </td>
    <td>
     <c:if test="${pb.page>1}">
    <a href="RecordServletTest?oop=5&page=${pb.page-1}">
    </c:if>
    上一页</a>
    </td>
    <td>
     <c:if test="${pb.page<pb.maxpage}">
    <a href="RecordServletTest?oop=5&page=${pb.page+1}">
    </c:if>
     下一页</a>
    </td>
    <td>
     <c:if test="${pb.page<pb.maxpage}">
    <a href="RecordServletTest?oop=5&page=${pb.maxpage}">
    </c:if>
     末页</a>
    </td>
    <td>
    
    跳转到
    <input type="text" id="page" name="page" size="2" value="${pb.page}" />
    页
    <input type="button" name="button" id="button" value="确定" onclick="docbangePage()" />
    </td>
    <td>
     每页
    <input type="text" id="rows" name="rows" size="2" value="${pb.rows}" />
    记录
     <input type="button" name="button2" id="button2" value="确定" onclick="docbangeRows()" />
    </td>
    
    <td>${pb.page}/${pb.maxpage}</td>
  </tr>
</table>
</form>
<p align="center">
<a href="add2.jsp">返回继续添加</a>
</p>
</body>
</html>