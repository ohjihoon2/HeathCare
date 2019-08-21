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
	//�л� ���� ����Ѵ�.
	public boolean regist(StuVO vo) {
		boolean result = false;
		int val = dao.getResultInsert(vo);
		if(val != 0) result = true;
		
		return result;
	}

	
	//��ü����Ʈ - �л� list UI�� ����
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
	
	//�α��� üũ
	public boolean loginCheck(String sid, String spass) {
		boolean result = false;
		int val = dao.getResultLogin(sid, spass);
		if(val != 0) result = true;
		
		return result;
	}
	
}


















