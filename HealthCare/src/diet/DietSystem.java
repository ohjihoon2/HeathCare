package diet;

import javax.swing.table.DefaultTableModel;

public class DietSystem {
	//Field
	DietDAO dao;
	
	//Constructor
	public DietSystem() {
		dao = new DietDAO();
	}
	
	//Method
	//다이어트 식단 전체 출력
	public void getList(DefaultTableModel t_model) {
		dao.getList(t_model);
	}
	
}
