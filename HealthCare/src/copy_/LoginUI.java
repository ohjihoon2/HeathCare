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
		//1. ȭ�� ����
		loginPanel = new JPanel(new GridLayout(4,1));
		idPanel = new JPanel();
		passPanel = new JPanel();			
		btnPanel = new JPanel();
		title = new JLabel("**********  �α��� �ϼ���  **********", JLabel.CENTER);
		lblId = new JLabel("��  ��  ��");
		lblPass = new JLabel("�н�����");
		jtfId = new JTextField(18);
		jtfPass = new JPasswordField(18);
		btnLogin = new JButton("�α���");
		btnReset = new JButton("���");
						
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
		
		//������ �����ư(X) Ŭ�� �� ���μ��� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//2. �̺�Ʈ ���
		btnLogin.addActionListener(this);
		btnReset.addActionListener(this);
	}
	
	
	//3. �̺�Ʈ ó��
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("�α���")) {
			//StuMgmSystem ����
			StuMgmSystem system = new StuMgmSystem();
			boolean result = system.loginCheck(jtfId.getText(), jtfPass.getText());
			
			if(result) {
				JOptionPane.showMessageDialog(null, "�α��� ����");
				new StuMgmSystemUI2();
				setVisible(false);
				
			}else {
				JOptionPane.showMessageDialog(null, "�α��� ����");
			}
			
		}else if(e.getActionCommand().equals("���")){
			//System.out.println("���");
			jtfId.setText("");
			jtfPass.setText("");
		}
	}
	
	//�α��� üũ
	public void loginCheck() {
		//System.out.println("�α���");
		if(!jtfId.getText().equals("")) {
			//�α���ó��->���̵� üũ
			if(jtfId.getText().equals("test") ) {
				
				if(!jtfPass.getText().equals("")) {
					//�н����� ó�� --> �н����� üũ
					if(jtfPass.getText().equals("1234")) {
						//�α��� ����!!
						JOptionPane.showMessageDialog(null,"�α��� ����!!!");
						//������� ȣ��~~
												
					}else {
						//�н����� �ٸ�
						JOptionPane.showMessageDialog(null,"�н����尡 �ٸ��ϴ�. �ٽ��Է����ּ���");
						jtfPass.setText("");
						jtfPass.requestFocus();
					}
				}else {
					JOptionPane.showMessageDialog(null,"�н����带 �Է����ּ���");
					jtfPass.requestFocus();
				}
			}else {
				//���̵� �ٸ�
				JOptionPane.showMessageDialog(null,"���̵� �ٸ��ϴ�. �ٽ��Է����ּ���");
				jtfId.setText("");
				jtfId.requestFocus();
			}
		}else {
			//���̵� �Է� �޽��� ���
			JOptionPane.showMessageDialog(null,"���̵� �Է����ּ���");
			jtfId.requestFocus();
		}
	}
	
	
}










