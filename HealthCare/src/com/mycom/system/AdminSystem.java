package com.mycom.system;

import javax.swing.table.DefaultTableModel;

import com.mycom.dao.AdminDAO;


public class AdminSystem {
	//Field
	AdminDAO dao;
	
	//Constructor
	public AdminSystem() {
		dao = new AdminDAO();
	}
	

	public void getMember(DefaultTableModel dtm_Adm) {
		dao.getList(dtm_Adm);
	}
	
	public void getLecture(DefaultTableModel dtm_Adm) {
		dao.getList(dtm_Adm);
	}

}
