package com.biz;

import java.util.List;

import com.bean.cadmin;
import com.bean.record;
import com.dao.ISdao;
import com.dao.ISdao1;
import com.dao.Sdao;
import com.dao.Sdao1;

public class Sbiz1  implements ISbiz1{
	ISdao1  dao1=  new Sdao1();
	public boolean save1(record st1) {
		return dao1.sava1(st1);
	
	}

	public boolean update1(record st1) {
		
		return dao1.update1(st1);
	}

	public boolean delByname(String name) {
		
		return dao1.delbyname(name);
	}

	public record findbyname(String name) {
		
		return dao1.findbyname(name) ;
	}

	public List<record> findAll() {
		return (dao1.findAll());
	}

	public List<record> findPageAll(int page, int rows) {
		
		return dao1.findPageAll(page, rows);
	}

	public int findMaxpage(int rows) {
		
		return dao1.findMaxpage(rows);
}
}