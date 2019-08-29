package com.mycom.system;

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
	//수강 리스트 출력
	public LectureVO uplistVO(String cno) {
		LectureVO lvo = dao.getListLectureVO(cno);
		
		return lvo;
	}
	
	//수강 업데이트
	public boolean update(LectureVO lvo){
		boolean result = false;
		
		int val = dao.getResultUpdate(lvo);
		if(val != 0) result = true;
		
		return result;
		
	}
	

	

}
