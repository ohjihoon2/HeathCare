package com.mycom.system;

import com.mycom.dao.MainDAO;
import com.mycom.vo.MainVO;

public class MainSystem {
	//Field
	MainDAO dao;
	
	//Constructor
	public MainSystem() {
		try {
			dao = new MainDAO();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//ȭ�� ���� ����
	public MainVO getListMainVO(String seq) {
		MainVO mvo = dao.getListMainVO(seq);
		
		return mvo;
	}
	
	public void close() {
		dao.close();
	}
}
