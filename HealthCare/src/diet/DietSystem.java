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
	//���̾�Ʈ �Ĵ� ��ü ���
	public void getList(DefaultTableModel t_model) {
		dao.getList(t_model);
	}
	
}
