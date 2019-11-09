<%@page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ include file="inn.jsp" %>
<!DOCTYPE html> 
<html>
<head>
<meta charset="utf-8">
<title>英雄人物档案信息</title>
</head>
<body>
<form action="show.jsp"  method="post"  name="form1">
<table>
<tr align="center">
<td colspan="2"> 管理员操作界面</td>
</tr>
<tr>
<td>姓名</td>
<td><input type="text"  name="cname"></td>
</tr>
<tr>
<td>战斗值编号</td>
<td><input type="text" name="IDnumber"></td>
</tr>
<tr>
<td>性别</td>
<td><input type="text" name="sex"></td>
</tr>
<tr>
<td>年龄</td>
<td><input type="text" name="age"></td>
</tr>
<tr>
<td>简介</td>
<td><textarea rows="10" cols="10" name="introduce">英雄人物简介</textarea></td>
</tr>
<tr>
<td colspan="2">
<input type="submit"  value="提交">
<input type="reset"  value="重置">
</td>
</tr>
<tr>
<td>

<input type="hidden" name="oop" value="1">添加英雄人物档案信息
</td>
</tr>
</table>
</form>

</body>
</html>