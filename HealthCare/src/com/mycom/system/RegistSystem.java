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
		System.out.println("regist 입성");
		int val= dao.getMemberInsert(vo);
		if(val != 0) {
			
			System.out.println("sno="+ sno);
			result = true;
		}
		return result;
	}
	public int searchSno(String name) {
		sno = dao.searchCno(name);
		System.out.println("system.searchSno() = " +sno);
		
		return sno;
	}
	
	
	
}
