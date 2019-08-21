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
		jf = new JFrame("학사관리시스템");
		btnPanel = new Panel();
		title = new Label("----------------- 학사 관리 시스템 ------------------");
		btnReg = new Button("등록");
		btnOutput = new Button("출력");
		btnExit = new Button("종료");
		
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










