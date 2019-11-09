package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.cadmin;
import com.bean.record;

public class Sdao1 implements ISdao1 {
	private ResultSet rst=null;
	private Object cname;
	//添加
	public boolean sava1(record st1) {
		
		String sql="insert into record(cname,IDnumber,sex,age,introduce,fname)values(?,?,?,?,?,?)";
		int rows=dbhoperdao.executeupdate(sql, new Object[] {
				st1.getCname(),
				st1.getIDnumber(),
				st1.getSex(),
				st1.getAge(),
				st1.getIntroduce(),
				st1.getFname()
		}
		);
     if(rows>0) {
			return true;
		}
		return false;
	
	}
//更新
	public boolean update1(record st1) {
		String sql="update  record set cname=?,sex=?,age=?,introduce=? ,fname=?where IDnumber=?";
		int rows=dbhoperdao.executeupdate(sql, new Object[] {
				st1.getCname(),
				st1.getSex(),
				st1.getAge(),
				st1.getIntroduce(),
				st1.getFname(),
				st1.getIDnumber()
				
		}
		);
     if(rows>0) {
			return true;
		}
		return false;
		
	}
	public boolean delbyname(String cname) {
		String sql="delete from record where cname=?";
		int rows=dbhoperdao.executeupdate(sql, new Object[]{cname});
		if(rows>0){
			return true;
			
		}
		return false;
	}
	public record findbyname(String cname) {
		String sql="select * from record where cname=?";
		rst=dbhoperdao.executequery(sql, new Object[]{cname});
		
		try {
			if(rst.next()){
				 record re=new record(
				rst.getString(1),
				rst.getString(2),
				rst.getString(3),
				rst.getString(4),
				rst.getString(5),
				rst.getNString(6)
			);
				return re;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<record> findAll() {
		List<record> reco=new ArrayList<record>();
		String sql="select * from record ";
		rst=dbhoperdao.executequery(sql,null);
		try {
			while(rst.next()){
				record re=new record(
						rst.getString(1),
						rst.getString(2),
						rst.getString(3),
						rst.getString(4),
						rst.getString(5),
						rst.getString(6)
						);
				reco.add(re);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reco;
	}
	public List<record> findPageAll(int page, int rows) {
		List<record> lsst=new ArrayList<record>();
		String sql="SELECT * FROM record ORDER BY IDnumber LIMIT "+(page-1)*rows+","+rows;
		System.out.println("sql-->"+sql);
	    rst=dbhoperdao.executequery(sql, null);
	    try {
			while(rst.next()){
				record st=new record(
						rst.getString(1),
						rst.getString(2),
						rst.getString(3),
						rst.getString(4),
						rst.getString(5),
						rst.getString(6)
						);
				lsst.add(st);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lsst;
	}
	public int findMaxpage(int rows) {
		
		int maxrows=0;//总记录数
		int maxpage=0;//总页数
		String sql="select count(*) from record";
		rst=dbhoperdao.executequery(sql, null);
		try {
			if(rst.next()){
				maxrows=rst.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(maxrows==0){
			maxpage=1;
		}else{
			maxpage=maxrows%rows==0?maxrows/rows:maxrows/rows+1;
		}
		return maxpage;
	}

	}

	
	 
	
