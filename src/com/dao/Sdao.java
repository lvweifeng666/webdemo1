package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.bean.cadmin;

public class Sdao implements ISdao {

	private ResultSet rst=null;
	//添加
	public boolean sava(cadmin st) {
		String sql="insert into cadmin(sname,passwd,sex,address,birthday,zdate)values(?,?,?,?,?,?)";
		int rows=dbhoperdao.executeupdate(sql, new Object[] {
				st.getSname(),
				st.getPasswd(),
				st.getSex(),
				st.getAddress(),
				st.getBirthday(),
				st.getZdate()	
		}
		);
     if(rows>0) {
			return true;
		}
		return false;
	}
	
	//修改
	public boolean update(cadmin st) {
		String sql="insert into cadmin( sname,passwd,sex,address,birthday,zdate)values(?,?,?,?,?,?)";
		int rows=dbhoperdao.executeupdate(sql, new Object[] {
				st.getSname(),
				st.getPasswd(),
				st.getSex(),
				st.getAddress(),
				st.getBirthday(),
				st.getZdate()	
				
		}
		);
     if(rows>0) {
			return true;
		}
		return false;
	}

//单个删除
	public boolean delbyid(cadmin  st) {
		String  sql="delete from student where cid=?";
		int rows=dbhoperdao.executeupdate(sql, new Object[]{st.getCid()});
		if(rows>0){
			return true;
		}
		return false;
	}
//单个查询
	public cadmin findbyid(cadmin  st) {
		String sql="select * from vwstu where cid=?";
		rst=dbhoperdao.executequery(sql, new Object[]{st.getCid()});
		try {
			if(rst.next()){
				cadmin st1 =new cadmin(
						rst.getString(1),
						rst.getString(2),
						rst.getString(3),
						rst.getString(4),
						rst.getString(5),
						rst.getString(6)
						);
				return st1;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null ;
		
	}
//全部查询
	public List<cadmin> findAll() {
		
		List<cadmin> lica=new ArrayList<cadmin>();
		String sql="select * from cadmin ";
		rst=dbhoperdao.executequery(sql,null);
		try {
			while(rst.next()){
				cadmin ca=new cadmin(
						rst.getString(1),
						rst.getString(2),
						rst.getString(3),
						rst.getString(4),
						rst.getString(5),
						rst.getString(6), 
						rst.getString(7)
						
						);
				lica.add(ca);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lica;
	}

	}

