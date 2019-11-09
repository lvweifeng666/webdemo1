package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.jdbcUtil;

public class dbhoperdao {
	private static java.sql.Connection conn;
	private static java.sql.PreparedStatement ps;
	private static ResultSet rst;
	
//通用的增删改
	public static int executeupdate(String sql,Object[] obj) {
		conn=jdbcUtil.getconn();
		try {
			ps=(PreparedStatement) conn.prepareStatement(sql);
			if(obj!=null&&obj.length>0) {
				for (int i = 0; i < obj.length; i++) {
					ps.setString(i+1, (String) obj[i]);
					
				}
				
			}
			System.out.println(ps.toString());
			int rows=ps.executeUpdate();
			if(rows>0) {
				
				return rows;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	//查询
	public static ResultSet executequery(String sql,Object[] obj) {
		//数据库驱动
		conn=jdbcUtil.getconn();
		try {
			ps=conn.prepareStatement(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if(obj!=null&&obj.length>0) {
				for (int i = 0; i < obj.length; i++) {
					ps.setString(i+1, (String) obj[i]);
				}
				
			}
			System.out.println(ps.toString());
			rst=ps.executeQuery();
			
			//ps=(PreparedStatement) conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rst;
		
	}
}
