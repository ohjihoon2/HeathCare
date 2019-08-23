package com.mycom.system;

import com.mycom.dao.RegistDAO;
import com.mycom.vo.ClientVO;

public class RegistSystem {
	
	//Filed
	RegistDAO dao;
	ClientVO vo;
	
	//Constructor
	public RegistSystem() {
		dao = new RegistDAO();
	}
		
	//Method
	/**
	 * 등록하기
	 * @param vo
	 * @return
	 */
	public boolean regist(ClientVO vo) {
		boolean result = false;
		
		int val= dao.getClientInsert(vo);
		if(val != 0) {
			result = true;
		}
		return result;
	}
	
	
	
}
