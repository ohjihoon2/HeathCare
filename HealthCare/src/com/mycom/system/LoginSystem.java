package com.mycom.system;

import com.mycom.dao.LoginDAO;
import com.mycom.vo.MemberVO;

public class LoginSystem {
	
	//Filed
	LoginDAO dao;
	MemberVO vo;
	
	//Constructor
	public LoginSystem() {
		dao = new LoginDAO();
	}
		
	//Method
	/**
	 * 로그인하기
	 * @param vo
	 * @return
	 */
	public boolean loginCheck(String cno) {
		System.out.println("system cno = "+cno);
		boolean result = false;
		int val =dao.getResultLogin(cno);
		System.out.println("val = " + val);
		if(val != 0) result = true;
		return result;
	}
	
	
	
}
