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
	//�ｺ, ���� ����ǥ ���
	public ArrayList<GymExtentionVO> getPriceList(){
		ArrayList<GymExtentionVO> list = dao.getResultList();
	
		return list;	
	}
	
	//�ｺ ������Ʈ (1����)
	public boolean update(int cno, int month, int price){
		boolean result = false;
		
		int val = dao.getResultUpdate(cno, month, price);
		if(val != 0) result = true;
		
		return result;
		
	}
	

	
	

}
