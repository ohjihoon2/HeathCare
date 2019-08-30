package com.mycom.system;

import com.mycom.dao.LoginDAO;
import com.mycom.ui.StartUI;
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
	public int loginCheck(int cno) {
		int result = 0;
		int val =dao.getResultLogin(cno);
		if(val != 0) {
			//cno로 로그인 한 MemberVO 저장
			dao.setVO(cno);
			System.out.println("division = "+StartUI.vo.getDivision());
			if(StartUI.vo.getDivision()==1) {
				result = 1;
			}else {
				result = 2;
			}
		}
		
		return result;
	}
	
	
	
}
