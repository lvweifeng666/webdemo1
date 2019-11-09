<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>档案查询系统</title>
</head>
<body>
<form action="show.jsp"  method="post"  name="form2">
<h1 align="center">欢迎登录学生档案查询系统</h1>
<p>请输入您要查询的学生信息</p><br>
<table>

<tr>
<td>英雄人物姓名</td>
<td>
<input type="text" name="cname" id="cname"/>
</td>
</tr>
<tr>
<td colspan="2">
<input type="hidden" value="6" name="oop"/>
<input  type="submit" name="" value="提交" /> 
<input  type="reset" name="" value="重置" />
</td>
</tr>
</table>
</form>
</body>
</html>