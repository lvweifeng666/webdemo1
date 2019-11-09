<%@page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ include file="inn.jsp" %>
<!DOCTYPE html> 
<html>
<head>
<meta charset="utf-8">
<title>用户注册</title>


<script type="text/javascript">
	function validate() {
		var name = $("#name").val();
		if (name == null || name == "") {
			$("#nameDiv").html("用户名不能为空！");
		} else {
			//1.创建XMLHttpRequest对象
			xmlHttpRequest = createXmlHttpRequest();
			//2.设置回调函数
			xmlHttpRequest.onreadystatechange = callBack;
			//3.初始化XMLHttpRequest组件
			var url = "cadminServlet?name=" + name;//服务器端URL地址,name为用户名文本框获取的值
			xmlHttpRequest.open("GET", url, true);
			//4.发送请求
			xmlHttpRequest.send(null);
			/* 使用POST方式发送请求
			var url = "userServlet";//服务器端URL地址
			xmlHttpRequest.open("POST", url, true);
			xmlHttpRequest.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded");
			var data = "name=" + name;//需要发送的数据信息,name为用户名文本框获取的值
			xmlHttpRequest.send(data);
            */
			//Ajax 回调函数
			function callBack() {
				if (xmlHttpRequest.readyState == 4
						&& xmlHttpRequest.status == 200) {
					var data = xmlHttpRequest.responseText;
					if (data == "true") {
						$("#nameDiv").html("用户名已被使用！");
					} else {
						$("#nameDiv").html("用户名可以使用！");
					}
				}
			}//end of callBack()
		}
	}//end of validate()

	/*
	 *创建XMLHttpRequest对象
	 */
	function createXmlHttpRequest() {
		if (window.XMLHttpRequest) {//返回值为true时说明是新版本IE或其他浏览器
			return new XMLHttpRequest();
		} else {//返回值为false时说明是老版本IE浏览器（IE5和IE6）
			return new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
</script>




</head>
<%-- <%
 List<cadmin> list=(List<cadmin>)session.getAttribute("list"); 
 
   if(list==null){
	 response.sendRedirect("zhuce.jsp");
}   
%> --%>

<body>
<form action="dosv.jsp"  method="post"  name="form1">
<table>
<tr align="center">
<td colspan="2"> 用户登录</td>
</tr>
<tr>
<td>账号</td>
<td><input type="text" name="text1" value=""></td>
<div id="nameDiv" style="display: inline"></div></td>
</tr>
<tr>
<td>密码</td>
<td><input type="password"></td>
</tr>
<tr>
<td colspan="2">
<input type="hidden"  value="5"  name="op">
<input type="submit"  value="提交">
<input type="reset"  value="重置">
</td>
</tr>
<tr>
<td>

<a href="zhuce.jsp">注册</a><br>
</td>
</tr>

</table>
</form>

</body>
</html>