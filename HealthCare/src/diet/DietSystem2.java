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
	//���̾�Ʈ �Ĵ� ��ü ���
	public void getList(DefaultTableModel t_model) {
		dao.getList(t_model);
	}
	
}
