package com.biz;

import java.util.List;

import com.bean.cadmin;
import com.bean.record;

public interface ISbiz1 {

	  public boolean save1(record st1);
	  public boolean update1(record st1);
	  public boolean delByname(String  cname);
	  public record findbyname(String cname);
	  public List<record> findAll();
	  /**
	   * page 当前页
	   * rows 每页记录数
	   * */
	  public List<record> findPageAll(int page,int rows);
	  /**
	   * 总页数
	   * */
	  public int findMaxpage(int rows);
}
