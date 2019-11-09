<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ include file="inn.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生档案修改</title>
<script src="SpryAssets/SpryValidationTextField.js" type="text/javascript"></script>
<link href="SpryAssets/SpryValidationTextField.css" rel="stylesheet" type="text/css" />
</head>
<%
	ISbiz1 ss1=new Sbiz1();
	
	
	
	record oldst=(record)session.getAttribute("oldst");
%>
<body>
<form action="RecordServletTest?oop=2"   enctype="multipart/form-data"  method="post"  name="form1" id="form1">
  <table width="500" border="1" align="center" cellpadding="1" cellspacing="0">
    <tr>
      <td colspan="2" align="center" bgcolor="#FFFF66">学生档案修改</td>
    </tr>
    <tr>
    <%System.out.println("uhjjhhhh"); %>
      <td >姓名</td>
      <td >
        <input type="text" name="cname" id="cname"  value="<%=oldst.getCname()%>"/>
       <%-- <input type="hidden" name="cname" id="cname" value="<%=oldst.getCname()%>"/> --%>
    </td>
    </tr>
    <tr>
      <td >年龄</td>
      <td >
        <input type="text" name="age" id="age"  value="<%=oldst.getAge()%>"/>
    </td>
    </tr>
    <tr>
      <td>性别</td>
      <td><input name="sex" type="text" id="sex" value="<%=oldst.getSex() %>" />
      </td>
    </tr>
    <tr>
      <td>战斗值排行</td>
     <td>
        <input type="text" name="IDnumber" id="IDnumber"  value="<%=oldst.getIDnumber()%>"/>
   </td>
    </tr>  
    <tr>
      <td>个人简介</td>
      <td><input type="textarea" name="introduce" id="introduce"  value="<%=oldst.getIntroduce()%>" />
      </td>
    </tr>
     <tr>
      <td>图片</td>
      <td><input type="file" name="file" id="file"  value="<%=oldst.getFname()%>" />
      </td>
    </tr>
    
    
    
   
    <tr>
      <td colspan="2" align="center" bgcolor="#FFFF66">
      <!--  <input name="oop" type="hidden" id="oop" value="2" /> -->
        <input type="submit" name="button" id="button" value="提交" />
        <input type="reset" name="button2" id="button2" value="重置" /></td>
    </tr>
  </table>
  <p align="center"><a href="show.jsp?oop=5">查看列表</a></p>
</form>
<script type="text/javascript">
/* var sprytextfield1 = new Spry.Widget.ValidationTextField("sprytextfield1");
var sprytextfield2 = new Spry.Widget.ValidationTextField("sprytextfield2"); */
</script>
</body>
</html>