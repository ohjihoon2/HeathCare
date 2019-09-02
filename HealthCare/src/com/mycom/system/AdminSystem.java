package com.mycom.system;

import javax.swing.table.DefaultTableModel;

import com.mycom.dao.AdminDAO;
import com.mycom.ui.StartUI;
import com.mycom.vo.MemberVO;


public class AdminSystem {
	//Field
	AdminDAO dao;
	
	//Constructor
	public AdminSystem() {
		dao = new AdminDAO();
	}
	
	/**
	 * 멤버 전체 검색
	 * @param dtm_Adm
	 */
	public void getMember(DefaultTableModel dtm_Adm) {
		dao.getMember(dtm_Adm);
	}
	/**
	 * 강의 정보 검색
	 * @param dtm_Adm
	 */
	public void getLecture(DefaultTableModel dtm_Adm) {
		dao.getLecture(dtm_Adm);
	}
	
	/**
	 * 멤버 검색
	 * @param dtm_Adm
	 * @param cno
	 */
	public void searchData(DefaultTableModel dtm_Adm, int cno) {	
		dao.getMember(dtm_Adm, cno);		
	}

}
