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
	 * �α����ϱ�
	 * @param vo
	 * @return
	 */
	public int loginCheck(int cno) {
		int result = 0;
		int val =dao.getResultLogin(cno);
		if(val != 0) {
			//cno�� �α��� �� MemberVO ����
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
