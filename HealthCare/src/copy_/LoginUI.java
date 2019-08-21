package copy_;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginUI extends JFrame implements ActionListener{
	//Field
	JPanel idPanel, passPanel,loginPanel,btnPanel, testPanel;
	JLabel title, lblId, lblPass;
	JTextField jtfId;
	JPasswordField jtfPass;
	JButton btnLogin, btnReset;
	
	//Constructor
	public LoginUI() {
		//1. 화면 구성
		loginPanel = new JPanel(new GridLayout(4,1));
		idPanel = new JPanel();
		passPanel = new JPanel();			
		btnPanel = new JPanel();
		title = new JLabel("**********  로그인 하세요  **********", JLabel.CENTER);
		lblId = new JLabel("아  이  디");
		lblPass = new JLabel("패스워드");
		jtfId = new JTextField(18);
		jtfPass = new JPasswordField(18);
		btnLogin = new JButton("로그인");
		btnReset = new JButton("취소");
						
		idPanel.add(lblId); idPanel.add(jtfId);
		idPanel.add(lblPass); idPanel.add(jtfPass);
		btnPanel.add(btnLogin); btnPanel.add(btnReset);
		loginPanel.add(title);
		loginPanel.add(idPanel); loginPanel.add(passPanel);	
		loginPanel.add(btnPanel);
		
		getContentPane().add(loginPanel, BorderLayout.CENTER);

		setSize(300,280);
		setLocation(300, 220);
		setVisible(true);
		
		//윈도우 종료버튼(X) 클릭 시 프로세서 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//2. 이벤트 등록
		btnLogin.addActionListener(this);
		btnReset.addActionListener(this);
	}
	
	
	//3. 이벤트 처리
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("로그인")) {
			//StuMgmSystem 생성
			StuMgmSystem system = new StuMgmSystem();
			boolean result = system.loginCheck(jtfId.getText(), jtfPass.getText());
			
			if(result) {
				JOptionPane.showMessageDialog(null, "로그인 성공");
				new StuMgmSystemUI2();
				setVisible(false);
				
			}else {
				JOptionPane.showMessageDialog(null, "로그인 실패");
			}
			
		}else if(e.getActionCommand().equals("취소")){
			//System.out.println("취소");
			jtfId.setText("");
			jtfPass.setText("");
		}
	}
	
	//로그인 체크
	public void loginCheck() {
		//System.out.println("로그인");
		if(!jtfId.getText().equals("")) {
			//로그인처리->아이디 체크
			if(jtfId.getText().equals("test") ) {
				
				if(!jtfPass.getText().equals("")) {
					//패스워드 처리 --> 패스워드 체크
					if(jtfPass.getText().equals("1234")) {
						//로그인 성공!!
						JOptionPane.showMessageDialog(null,"로그인 성공!!!");
						//수행로직 호출~~
												
					}else {
						//패스워드 다름
						JOptionPane.showMessageDialog(null,"패스워드가 다릅니다. 다시입력해주세요");
						jtfPass.setText("");
						jtfPass.requestFocus();
					}
				}else {
					JOptionPane.showMessageDialog(null,"패스워드를 입력해주세요");
					jtfPass.requestFocus();
				}
			}else {
				//아이디가 다름
				JOptionPane.showMessageDialog(null,"아이디가 다릅니다. 다시입력해주세요");
				jtfId.setText("");
				jtfId.requestFocus();
			}
		}else {
			//아이디 입력 메시지 출력
			JOptionPane.showMessageDialog(null,"아이디를 입력해주세요");
			jtfId.requestFocus();
		}
	}
	
	
}










