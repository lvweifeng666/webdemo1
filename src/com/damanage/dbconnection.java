package com.damanage;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class dbconnection {
	private static Connection conn=null;
	private static ResultSet rst=null;
	private static Statement st=null;
	private static PreparedStatement ps=null;
	
	public static Connection getconn() {
		try {
			Class.forName("com.mysql.jdbc.diiver");
			try {
				 Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/DDDD?characterEncoding=utf-8",
						"root",
						"123456");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	
	public static void colseALL(ResultSet rst, Statement st,PreparedStatement ps,Connection conn  ) {
		try {
		if(rst!=null)rst.close();
		if(st!=null)st.close();
		if(ps!=null)ps.close();
		if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	};

}
