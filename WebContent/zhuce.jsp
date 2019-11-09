<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ include file="inn.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

</head>
<body>
<form action="dosv.jsp"  method="post"  name="form1">
<table>
<tr align="center">
<td colspan="2"> 用户注册</td>
</tr>
<tr>
<td>账号</td>
<td><input type="text" name="sname" value="sname1"></td>
</tr>
<tr>
<td>密码</td>
<td><input type="password"  name="passwd"></td>
</tr>
<tr>
<td>性别</td>
<td><input type="radio" value="男"  name="sex" checked>男
<input type="radio" name="sex" value="女" >女
</td>
</tr>
<tr>
<td>生日</td>
<td><input type="date" name="birthday"></td>
</tr>
<tr>
<td>地址</td>
<td><input type="text" name="address"></td>
</tr>
<tr>
<td>注册日期</td>
<td><input type="date" name="zdate"></td>
</tr>
<tr>
<td colspan="2">
<input type="hidden" name="op" value="1">
<input type="submit"  value="提交">
<input type="reset"  value="重置">
</td>
</tr>


</table>
</form>

</body>
</html>