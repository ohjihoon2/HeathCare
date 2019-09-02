package com.mycom.system;

import java.util.ArrayList;

import com.mycom.dao.LectureDAO;
import com.mycom.vo.LectureVO;

public class LectureSystem {
	//field
	LectureDAO dao;
	
	//constructor
	public LectureSystem() {
		try {
			dao = new LectureDAO();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//method
	//�������������� ȸ������ ���
	public LectureVO getListVO(int cno) {
		LectureVO vo = dao.getResultVO(cno);
		
		return vo;
	}
		

	//���� ��� ����Ʈ ���
	public ArrayList<LectureVO> uplistVO() {	
		ArrayList<LectureVO> list = dao.getGXList();
		
		return list;
	}
	
	
	//���� ������Ʈ
	public boolean update(LectureVO lvo){
		boolean result = false;
		
		int val = dao.getResultUpdate(lvo);
		if(val != 0) result = true;
		
		return result;
		
	}
	

	

}
