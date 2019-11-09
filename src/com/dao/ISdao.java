package com.dao;

import java.sql.ResultSet;
import java.util.List;
import com.bean.cadmin;
public interface ISdao {
public boolean sava( cadmin st);
public boolean update(cadmin st);
public boolean delbyid(cadmin  st);
public cadmin findbyid(cadmin  st);
public List<cadmin> findAll();

}
