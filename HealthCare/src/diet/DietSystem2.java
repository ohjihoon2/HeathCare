package diet;

import javax.swing.table.DefaultTableModel;

public class DietSystem2 {
	//Field
	DietDAO2 dao;
	
	//Constructor
	public DietSystem2() {
		dao = new DietDAO2();
	}
	
	//Method
	//다이어트 식단 전체 출력
	public void getList(DefaultTableModel t_model) {
		dao.getList(t_model);
	}
	
}
