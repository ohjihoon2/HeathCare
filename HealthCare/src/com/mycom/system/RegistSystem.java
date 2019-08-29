package com.mycom.system;

import com.mycom.dao.RegistDAO;
import com.mycom.vo.MemberVO;

public class RegistSystem {
	
	//Filed
	RegistDAO dao;
	MemberVO vo;
	int sno;
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
	public boolean regist(MemberVO vo) {
		boolean result = false;
		
		int val= dao.getClientInsert(vo);
		if(val != 0) {
			
			System.out.println("sno="+ sno);
			result = true;
		}
		return result;
	}
	public int searchSno() {
		sno = dao.searchCno();
		System.out.println("system.searchSno() = " +sno);
		
		return sno;
	}
	
	
	
}
