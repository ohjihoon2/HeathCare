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
	 * �α����ϱ�
	 * @param vo
	 * @return
	 */
	public boolean loginCheck(int cno) {
		boolean result = false;
		int val =dao.getResultLogin(cno);
		System.out.println("val = " + val);
		if(val != 0) {
			//cno�� �α��� �� MemberVO ����
			dao.setVO(cno);
			result = true;
		}
		
		return result;
	}
	
	
	
}
