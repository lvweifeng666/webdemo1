package com.biz;

import java.util.List;

import com.bean.cadmin;
import com.dao.ISdao;
import com.dao.Sdao;

public class Sbiz implements ISbiz {
    ISdao  dao=new Sdao();
	public boolean save(cadmin st) {
		boolean flag=true;
		if(st!=null){
		 flag=dao.sava(st);
		}
		return flag;
	}
	public boolean update(cadmin st) {
		return dao.update(st);
	}
	public cadmin findbyid(cadmin  st) {
		
		return dao.findbyid(st);
	}

	public List<cadmin> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public boolean delByid(cadmin  st) {
		// TODO Auto-generated method stub
		return dao.delbyid(st);
	}

}
