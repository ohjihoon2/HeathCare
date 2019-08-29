package com.mycom.system;

import com.mycom.dao.LoginDAO;
import com.mycom.vo.MemberVO;

public class LoginSystem {
	
	//Filed
	LoginDAO dao;
	
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
	public boolean loginCheck(int cno) {
		boolean result = false;
		int val =dao.getResultLogin(cno);
		System.out.println("val = " + val);
		if(val != 0) {
			//cno로 로그인 한 MemberVO 저장
			dao.setVO(cno);
			result = true;
		}
		
		return result;
	}
	
	
	
}
