package copy_;

import java.awt.*;
import javax.swing.*;

public class StuMgmSystemUI {
	//Field
	JFrame jf;
	Panel btnPanel;
	Label title;
	Button btnReg, btnOutput, btnExit;	
	
	//Constructor
	public StuMgmSystemUI() {
		jf = new JFrame("�л�����ý���");
		btnPanel = new Panel();
		title = new Label("----------------- �л� ���� �ý��� ------------------");
		btnReg = new Button("���");
		btnOutput = new Button("���");
		btnExit = new Button("����");
		
		btnPanel.add(btnReg);
		btnPanel.add(btnOutput);
		btnPanel.add(btnExit);
		
		jf.getContentPane().add(title,BorderLayout.CENTER);
		jf.getContentPane().add(btnPanel,BorderLayout.SOUTH);
		
		jf.setSize(270,200);
		jf.setVisible(true);
		
	}
	
	//Method
}










