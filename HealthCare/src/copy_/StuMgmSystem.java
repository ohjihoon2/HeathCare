package copy_;

import java.util.ArrayList;
import java.util.Hashtable;


public class StuMgmSystem {
	//Field	
	StuDAO dao;

	
	//Constructor
	public StuMgmSystem() {		
		dao = new StuDAO();		
	}
	
	//Method	
	//학생 점수 등록한다.
	public boolean regist(StuVO vo) {
		boolean result = false;
		int val = dao.getResultInsert(vo);
		if(val != 0) result = true;
		
		return result;
	}

	
	//전체리스트 - 학생 list UI로 전달
	public ArrayList<StuVO> getList() {		
		ArrayList<StuVO> list = dao.getList();		
		return list;
	}	
	
	
	
	//searchData
	public StuVO searchData(String sno) {		
		StuVO svo = dao.getListVO(sno);		
		return svo;
	}
	
	
	//update
	public boolean update(StuVO uvo) {
		boolean result = false;
	
		int val = dao.getResultUpdate(uvo);
		if(val != 0) result = true;
		
		return result;
	}
	
	//delete
	public boolean delete(String sno) {
		boolean result = false;
	
		int val = dao.getResultDelete(sno);
		if(val != 0) result = true;
		
		return result;
	}
	
	//close
	public void close() {
		dao.close();		
	}
	
	//로그인 체크
	public boolean loginCheck(String sid, String spass) {
		boolean result = false;
		int val = dao.getResultLogin(sid, spass);
		if(val != 0) result = true;
		
		return result;
	}
	
}


















