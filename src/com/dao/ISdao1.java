package com.dao;

import java.sql.ResultSet;
import java.util.List;
import com.bean.cadmin;
import com.bean.record;
public interface ISdao1 {
public boolean sava1( record st1);
public boolean update1(record st1);
public boolean delbyname(String  cname);
public record findbyname( String cname);
public List<record> findAll();

/**
 * page ��ǰҳ
 * rows ÿҳ��¼��
 * */
public List<record> findPageAll(int page,int rows);
/**
 * ��ҳ��
 * */
public int findMaxpage(int rows);

}
