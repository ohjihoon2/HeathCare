package com.mycom.system;

import java.util.ArrayList;

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
	 * ��� ��ü �˻�
	 * @param dtm_Adm
	 * @return 
	 */
	public ArrayList<MemberVO> getMember(DefaultTableModel dtm_Adm) {
		return dao.getMember(dtm_Adm);
	}
	/**
	 * ���� ���� �˻�
	 * @param dtm_Adm
	 */
	public void getLecture(DefaultTableModel dtm_Adm) {
		dao.getLecture(dtm_Adm);
	}
	
	/**
	 * ��� �˻�
	 * @param dtm_Adm
	 * @param cno
	 */
	public void searchData(DefaultTableModel dtm_Adm, int cno) {	
		dao.getMember(dtm_Adm, cno);		
	}
	
	/**
	 * ���� 
	 */
	public boolean getAdminDelete(int cno) {
		boolean result = false;
		
		int val = dao.getResultDelete(cno);
		if(val != 0) {
			result = true;
		}
		
		return result;
	}
	
	
}
