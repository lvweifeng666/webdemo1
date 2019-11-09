<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@  include file="inn.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<title>注册信息展示页面</title>
<script src="js/jquery-1.9.1.js"></script>
<script>
$(function(){
	showAll();//显示列表的方法
});
/********显示列表*********/
 var page=1;
 var rows=5;
 var maxpage=1;
alert(page);
 function showAll(){
	 $.getJSON("RecordServletTest?oop=5&page="+page+"&rows="+rows,function(jsonPageBean){
		 page=jsonPageBean.page;
		 rows=jsonPageBean.rows;
		 maxpage=jsonPageBean.maxpage;
		 var lsst=jsonPageBean.pagelist;
		 var tablehead="<table align='center' width='1000' border='1px' bgcolor='ccffcc'>"
		 +"<tr align='center'>"
		 +"<td >英雄战斗值排行</td>"
		 +"<td >英雄姓名</td>"
		 +"<td >英雄性别</td>"
		 +"<td >英雄年龄</td>"
		 +"<td >英雄简介</td>"
		 +"<td >英雄图片</td>"
		 +"<td >信息修改</td>"
		 +" </tr>"
          var trs="";
		 for (var i = 0; i <lsst.length; i++) {
				var st=lsst[i];
			trs+= "<tr align='center'>"
				 +"<td >"+st.IDnumber+"</td>"
				 +"<td >"+st.cname+"</td>"
				 +" <td >"+st.sex+"</td>"
				 +" <td >"+st.age+"</td>"
				 +"<td >"+st.introduce+"</td>"
				 +"<td ><a href=uppic/"+st.fname+ "><img src=uppic/"+st.fname+ "  width='120' height='110' /></a></td>"
				 +"<td ><input type='button' id='btdetele' onclick='dodelById(&quot"+st.cname+"&quot)' value='删除' /> <input type='button' id='btedit' onclick='doupdate(&quot"+st.cname+"&quot)' value='修改' /></td>"
			+" </tr>" 
			
		} 
		
		var endtable=tablehead+trs+" </table>";
		$("#mytable").html(endtable);
		//给分页组件写入值
		$("#rows").val(rows);
		$("#page").val(page);
		$("#pagetable").html(page+"/"+maxpage);
	 });

 }
		/* 显示列表end */
		/********分页组件赋值*********/
 $(function(){
	 $("#btfirst").click(function(){
		 page=1;
		 showAll();
	 });
	 $("#btup").click(function(){
		 page=page-1;
		 if(page<1){
			 page=1;
		 }
		 showAll();
	 });
	 $("#btnext").click(function(){
		 page=page+1;
		 if(page>maxpage){
			 page=maxpage;
		 }
		 showAll();
	 });
	 $("#btlast").click(function(){
		 page=maxpage;
		 showAll();
	 });
	 //更改每页记录数
	 $("#btchanRows").click(function(){
		 var rowsval=$("#rows").val();
		 if(isNaN(rowsval)){
			 alert('请输入正确的数字');
			 $("#rows").val(rows);
	         return;
		 }
		 rows=rowsval;
		 showAll();
	 });
	 //更改跳转
	 $("#btchanPage").click(function(){
		 var pageval=$("#page").val();
		 if(isNaN(pageval)){
			 alert('请输入正确的数字');
			 $("#page").val(page);
	         return;
		 }
		 page=pageval;
		 showAll();
	 });
 });
/********分页组件赋值end*********/
 
/********删除*********/
  
 
  function dodelById(cname){
	alert(cname);
	if(window.confirm('是否确定删除编号为'+cname+'的数据')){
		$.get("RecordServletTest?oop=3&cname="+cname,function(code){
			alert(code);
			if(code=='"1"'){
				alert("删除成功");
				showAll();
			}else{
				alert("删除失败");
			}
		});
	}
}
 
/********删除end*********/
/*******修改*********/

 function doupdate(cname){
		alert(cname);
		if(window.confirm('是否确定修改姓名为'+cname+'的数据')){
			
			/*   <a href="RecordServletTest?oop=4&cname="+cname+">修改</a> */
			
			 $.get("RecordServletTest?oop=4&cname="+cname,function(code){
				/* alert(code);
				if(code=='"1"'){
					alert("删除成功");
					showAll();
				}else{
					alert("删除失败");
				} */
			}); 
		}
	}  
	 
	/********修改end*********/
 
	/********编辑end*********/
/*  function doupdate(cname){
	$.getJSON("RecordServletTest?oop=4&cname="+cname,function(oldst){
		//给表单元素赋值
		$("#cname").val(oldst.cname);
		$("#IDnumber").val(oldst.IDnumber);
		$("#sex").val(oldst.sex);
		$("#age").val(oldst.age);
		$("#introduce").val(oldst.introduce);
		//处理图片
		$("#aa").attr('href','uppic/'+oldst.fname);
		$("#imgg").attr('src','uppic/'+oldst.fname);
		//处理班级
	
	});
} */
	
	/********修改*********/
//修改
 /*  $(function(){
 $("#buttonupdate").click(function(){
	 alert("2222222222");
	 var canem=$("#cname").val();
	 var IDnumber=$("#IDnumber").val();
	 var sex=$("#sex").val();
	 var age=$("#age").val();
	 var introduce=$("#introduce").val();
	 var fname=$("#fname").val();
	 var oop=$("#oop").val(); 
	 var fname=$("#imgg")[0].src; 
	 var jsondata={
			 'cname':cname,
			 'IDnumber':IDnumber,
			 'sex':sex,
			 'age':age,
			 'introduce':introduce,
			 'fname':fname
	 };
	 alert("222");
	 $.getJSON("RecordServletTest?oop=4",jsondata,function(nummm){
		    alert(nummm);
			var code1=nummm;
			if(code1=='1'){
				alert("修改成功");
				showAll();
			}else{
				alert("修改失败");
			}
		});
	     showAll();
     });
 }); */
/********修改end*********/ 
	
	
	
	


</script>
</head>
<body>
<p align="center">英雄列表</p>
<hr />
<div id="mytable">

</div>
<form action="">
<table  width="1000" align="center" border="1">
<tr align="center" bgcolor="#FFFFCC">
    <td >
    <input type="button" name="btfirst" id="btfirst" value="首页" />
    </td>
    <td ><input type="button" name="btup" id="btup" value="上一页" /></td>
    <td ><input type="button" name="btnext" id="btnext" value="下一页" /></td>
    <td ><input type="button" name="btlast" id="btlast" value="末页" /></td>
    <td >
    每页
    <input type="text" name="rows" id="rows" size="2" />
    条记录
    <input type="button" name="btchanRows" id="btchanRows" value="确定" /></td>
    <td >跳转到第
    <input type="text" name="page" id="page" size="2" />
    页
    <input type="button" name="btchanPage" id="btchanPage" value="确定" /></td>
    <td >
    <span id="pagetable">page/maxpage</span>
    </td>
</tr>
</table>
</form>

<div align="center">

<a href=add3.jsp>添加英雄人物档案信息</a>
</div>

<!-- 
</form>
<form action="" method="post" name="form1" id="form1">
  <table width="500" border="1" align="center" cellpadding="1" cellspacing="0">
    <tr>
      <td colspan="2" align="center" bgcolor="#FFFF66">信息修改</td>
    </tr>
    <tr>
      <td width="94">姓名</td>
      <td width="396">
        
        <input type="text" name="cname" id="canem"/>
        <input type="hidden" name="cname" id="cname" />
     </td>
    </tr>
     <tr>
      <td>介绍</td>
      <td>
        <input type="text" name="IDnumber" id="IDnumber"/>
      </td>
    </tr>
    
    <tr>
      <td>性别</td>
      <td>
        <input type="text" name="sex" id="sex"/>
      </td>
    </tr>
    <tr>
      <td>年龄</td>
      <td>
        <input type="text" name="age" id="age"/>
     </span></td>
    </tr>
    <tr>
      <td>介绍</td>
      <td><input type="text" name="introduce" id="introduce"/></td>
    </tr>
   
   
    <tr>
      <td>图片</td>
      <td>
      <a id="aa" href="">
     <img id="imgg" src="" width="120" height="110" alt="图片没有上传" />
    </a>
    
      </td>
    </tr>
    <tr>
      <td colspan="2" align="center" bgcolor="#FFFF66">
       <input type="hidden" name="op" id="op" value="2" />
        <input type="submit" name="buttonupdate" id="buttonupdate" value="提交" />
      <input type="reset" name="button2" id="button2" value="重置" /></td>
    </tr>
  </table>
</form> -->

</body>
</html>