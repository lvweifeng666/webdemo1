package com.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.alibaba.fastjson.JSONObject;
import com.bean.PageBean;
import com.bean.record;
import com.biz.ISbiz1;
import com.biz.Sbiz1;
import com.util1.AJAXUtils;

public class RecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean flase;
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		ISbiz1 ss1=new Sbiz1();
		//从前台页面获取数据
		int oop=Integer.parseInt(request.getParameter("oop"));
		record st1=(record)request.getAttribute("st1");
		 boolean flag=flase;
		switch(oop){
		case 1://增加
			List<record> lsss=(List<record>)session.getAttribute("lsss");
			lsss=lsss==null?new ArrayList<record>():lsss;
			//磁盘工厂
			DiskFileItemFactory factory =new DiskFileItemFactory();
			//获取对象
			ServletFileUpload ServletFileUpload =new ServletFileUpload(factory);
			//解析请求对象
			try {
				List<FileItem> Items=ServletFileUpload.parseRequest(request);
				if(Items!=null) {
					//创建对象
					record st=new record();
					 for(FileItem item:Items) {
						 if(item.isFormField()) {//判断是表单
							 String FieldName=item.getFieldName();
							 if( FieldName.equals("cname")) {
								 String cname=item.getString("utf-8");
								 System.out.println("cname=====>"+cname);
								 st.setCname(cname);
							 }
							 if( FieldName.equals("IDnumber")) {
								 String IDnumber=item.getString("utf-8");
								 System.out.println("IDnumber=====>"+IDnumber);
								 st.setIDnumber(IDnumber);
							 }
							 if( FieldName.equals("age")) {
								 String age=item.getString("utf-8");
								 System.out.println("cname=====>"+age);
								 st.setAge(age);
							 }
							 if( FieldName.equals("sex")) {
								 String sex=item.getString("utf-8");
								 System.out.println("sex=====>"+sex);
								 st.setSex(sex);
							 }
							 if( FieldName.equals("introduce")) {
								 String introduce=item.getString("utf-8");
								 System.out.println("introduce=====>"+introduce);
								 st.setIntroduce(introduce);
							 }
						 }else {
							 //为文件
							 String fname=item.getName();
							 if(fname.lastIndexOf(".")!=-1) {
								
								String ext=fname.substring(fname.lastIndexOf("."));
								if(ext!=null&&(ext.equalsIgnoreCase(".jpg"))) {
									fname=new Date().getTime()+ext;
								}
							 }
							 
							 System.out.println("修改后的图片名称为："+fname);
							 String realpath=getServletContext().getRealPath("/");
							 //获取上传文件字节数组
							 byte[] b=item.get();
							 //创建输出流对象
							 FileOutputStream fout=new FileOutputStream(new File(realpath+"/uppic/"+fname));
							 fout.write(b);
							 fout.flush();
							 fout.close();
							 st.setFname(fname);
						 }
					 }
					 lsss.add(st);
					 session.setAttribute("lsss", lsss);
					
					  flag=ss1.save1(st);
					 
					 if(flag){
						 System.out.println("dsssssssssssssdfsffdffdd");
						   response.sendRedirect(getServletContext().getContextPath()+"/listAjax.jsp");
						   System.out.println("dsssssssssssssdfsff222222222222222222dffdd");
						  // response.sendRedirect("ok.jsp");
						  return;
					 }else{
						   response.sendRedirect("error1.jsp");
					 } 
					}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		case 2://修改
			
			List<record> lsss1=(List<record>)session.getAttribute("lsss");
			lsss1=lsss1==null?new ArrayList<record>():lsss1;
			//磁盘工厂
			DiskFileItemFactory factory1 =new DiskFileItemFactory();
			//获取对象
			ServletFileUpload ServletFileUpload1 =new ServletFileUpload(factory1);
			//解析请求对象
			try {
				List<FileItem> Items=ServletFileUpload1.parseRequest(request);
				if(Items!=null) {
					//创建对象
					record st=new record();
					 for(FileItem item:Items) {
						 if(item.isFormField()) {//判断是表单
							 String FieldName=item.getFieldName();
							 if( FieldName.equals("cname")) {
								 String cname=item.getString("utf-8");
								 System.out.println("cname=====>"+cname);
								 st.setCname(cname);
							 }
							 if( FieldName.equals("IDnumber")) {
								 String IDnumber=item.getString("utf-8");
								 System.out.println("IDnumber=====>"+IDnumber);
								 st.setIDnumber(IDnumber);
							 }
							 if( FieldName.equals("age")) {
								 String age=item.getString("utf-8");
								 System.out.println("cname=====>"+age);
								 st.setAge(age);
							 }
							 if( FieldName.equals("sex")) {
								 String sex=item.getString("utf-8");
								 System.out.println("sex=====>"+sex);
								 st.setSex(sex);
							 }
							 if( FieldName.equals("introduce")) {
								 String introduce=item.getString("utf-8");
								 System.out.println("introduce=====>"+introduce);
								 st.setIntroduce(introduce);
							 }
						 }else {
							 //为文件
							 String fname=item.getName();
							 if(fname.lastIndexOf(".")!=-1) {
								
								String ext=fname.substring(fname.lastIndexOf("."));
								if(ext!=null&&(ext.equalsIgnoreCase(".jpg"))) {
									fname=new Date().getTime()+ext;
								}
							 }
							 
							 System.out.println("修改后的图片名称为："+fname);
							 String realpath=getServletContext().getRealPath("/");
							 //获取上传文件字节数组
							 byte[] b=item.get();
							 //创建输出流对象
							 FileOutputStream fout=new FileOutputStream(new File(realpath+"/uppic/"+fname));
							 fout.write(b);
							 fout.flush();
							 fout.close();
							 st.setFname(fname);
						 }
					 }
				
			 flag=ss1.update1(st);
			   if(flag){
				   //response.sendRedirect("show.jsp?oop=5");
					AJAXUtils.printString(response, 1+"");
				   return;
			   }else{
				  // response.sendRedirect("error.jsp");
					AJAXUtils.printString(response, 0+"");
			   }
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3://删除
			 String cname=request.getParameter("cname");
			  flag=ss1.delByname(cname);
			  System.out.println(cname);
			   if(flag){
				   System.out.println(flag);
				//System.out.println("kjjjjjjjjjjjjjjjjjj"+flag);
				  // response.sendRedirect("show.jsp?oop=5");
				 //  System.out.println("kjjjjjjjjjjjjjjjjjj"+flag);
				   String jsonstr=JSONObject.toJSONString(1+"");
					AJAXUtils.printString(response, jsonstr);
				   return;
			   }else{
				  // response.sendRedirect("error.jsp");
				   String jsonstr=JSONObject.toJSONString(0+"");
					AJAXUtils.printString(response, jsonstr);
			   }
			break;
		case 4://单个查询
			cname=request.getParameter("cname");
			//System.out.println("kjjjjjjjjjjjjjjjjjj"+"   "+cname);
			record oldst=ss1.findbyname(cname);
			//System.out.println("kjjjjjjjjjjjjjjjjjj"+oldst);
			//session.setAttribute("oldst", oldst);
			//response.sendRedirect("update.jsp");
			String jsonstr=JSONObject.toJSONString(oldst);
			AJAXUtils.printString(response, jsonstr);
			response.sendRedirect("update.jsp");
			break;
		case 5://查询
			 //从session中获取pb对象
			 PageBean pb=(PageBean)session.getAttribute("pb");
			 pb=pb==null?new PageBean():pb;
			 String page=request.getParameter("page");
			  String rows=request.getParameter("rows");
			page=page==null?""+pb.getPage():page; 
			rows=rows==null?""+pb.getRows():rows;
			 //将页面获取数据强转 
			int ipage=Integer.parseInt(page); int
			  irows=Integer.parseInt(rows); 
			  if(ipage<1)ipage=1; if(irows<1)irows=5; //获取总页数
			 int maxpage=ss1.findMaxpage(irows);
			 if(ipage>maxpage)ipage=maxpage;
		 //获取当前页记录集合
			 List<record> lsst=ss1.findPageAll(ipage, irows);
			 //检查分页数据封装pb对象
			 pb.setMaxpage(maxpage);
			 pb.setPage(ipage); pb.setRows(irows);
			 pb.setPagelist(lsst);
			 
			 jsonstr=JSONObject.toJSONString(pb);
		    AJAXUtils.printString(response, jsonstr);
			 
			/*
			 * session.setAttribute("pb", pb);
			 * List<record> list1=ss1.findAll(); session.setAttribute("list", list1);
			 * response.sendRedirect("list3.jsp");
			 */
             
		 	break;
		
		/*
		 * case 6://单个查询 cname=request.getParameter("cname");
		 * System.out.println("kjjjjjjjjjjjjjjjjjj"+"   "+cname); record
		 * ol=ss1.findbyname(cname); System.out.println("kjjj"+ol);
		 * session.setAttribute("ol", ol); response.sendRedirect("list1.jsp"); break;
		 */
			
		
	}
	}
	}
