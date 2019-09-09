package com.mycom.system;

import java.util.ArrayList;

import com.mycom.dao.GymExtentionDAO;
import com.mycom.vo.GymExtentionVO;

public class GymExtentionSystem {
	//field
	GymExtentionDAO dao;
	
	//constructor
	public GymExtentionSystem() {
		try {
			dao = new GymExtentionDAO();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	//method
	//헬스, 수강 가격표 출력
	public ArrayList<GymExtentionVO> getPriceList(){
		ArrayList<GymExtentionVO> list = dao.getResultList();
	
		return list;	
	}
	
	//헬스 업데이트 (1개월)
	public boolean update(int cno, int month, int price){
		boolean result = false;
		
		int val = dao.getResultUpdate(cno, month, price);
		if(val != 0) result = true;
		
		return result;
		
	}
	

	
	

}
