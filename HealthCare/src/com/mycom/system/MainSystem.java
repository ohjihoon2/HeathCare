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
	
	
	//화면 정보 띄우기
	public MainVO getListMainVO(int cno) {
		MainVO mvo = dao.getResultMainVO(cno);
		
		return mvo;
	}
	
	public MainVO getListInbodyVO(int cno) {
		MainVO mvo = dao.getInbodyVO(cno);
		
		return mvo;
	}
	
	public void close() {
		dao.close();
	}
}
