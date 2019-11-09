package com.util;

/*
 * import java.io.IOException; import java.io.InputStream; import
 * java.sql.DriverManager; import java.util.Properties;
 * 
 * import com.mysql.jdbc.Connection;
 * 
 * public class jdbcUtil { private static String driverclass; private static
 * String url; private static String user; private static String passworld;
 * static { InputStream fis=
 * jdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
 * //创建properties对象 Properties info=new Properties(); try { info.load(fis);
 * driverclass=info.getProperty("driverclass"); url=info.getProperty("url");
 * user=info.getProperty("user"); passworld=info.getProperty("passworld"); }
 * catch (IOException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); }
 * 
 * //获取数据库驱 public static Connection getconn() { Connection conn=null;
 * Class.forName(driverclass); conn=DriverManager.getConnection(url, user,
 * password);
 * 
 * 
 * }
 * 
 * 
 * //关闭的方法 public static void colseAll(Resu ) {
 * 
 * } } }
 */
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class jdbcUtil {
 private static String url;
 private static String user;
 private static String passworld;
 private static String driverclass;
 static{
	 //从文件读取输入流
  InputStream fis=jdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
     //创建properties对象
  Properties info=new Properties();
    //加载数据
    try {
		info.load(fis);
		driverclass=info.getProperty("driverclass");
		url=info.getProperty("url");
		user=info.getProperty("user");
		passworld=info.getProperty("passworld");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
 public static Connection getconn(){
		Connection conn=null;
		try {
			//1.加载驱动
			Class.forName(driverclass);
			//2.使用数据库驱动管理器类，获取数据库连接
			conn=DriverManager.getConnection(url,user,passworld
					);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	public static void closeAll(ResultSet rst,Statement st,PreparedStatement ps,Connection conn){
		
			try {
				if(rst!=null)rst.close();
				if(st!=null)st.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}