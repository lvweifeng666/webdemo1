package com.biz;

import java.util.List;

import com.bean.cadmin;


public interface ISbiz {
	 public boolean save(cadmin st);
	  public boolean update(cadmin st);
	  public boolean delByid(cadmin  st);
	  public cadmin findbyid(cadmin  st);
	  public List<cadmin> findAll();
	 
}
