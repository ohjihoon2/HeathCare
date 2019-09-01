package diet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;


public class DietUI extends JFrame implements ActionListener {
	//Field
	JFrame jf;
	JPanel p_Dietall, p_Dieta2;
	JScrollPane s_Dietscroll;

	DietSystem system = new DietSystem();
	DefaultTableModel d_Dietdt;
	JTable j_DIettable;
	// ��ũ�� ��� ����
	String[] name = {"��ȣ","��ǰ�̸�","1ȸ������(g)",	"����(kcal)",	"ź��ȭ��(g)","�ܹ���(g)","����(g)","���(g)","��Ʈ��(mg)","����"};
	
	//Constructor
	public DietUI() {
		jf = new JFrame();
		p_Dietall = new JPanel();
		p_Dieta2 = new JPanel();
		
		d_Dietdt = new DefaultTableModel(name, 0);
		j_DIettable = new JTable(d_Dietdt); 
        s_Dietscroll = new JScrollPane(j_DIettable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
//        j_DIettable.getColumnModel().getColumn(9).setCellRenderer(new TableCell());
//        //table���� column�� �ҷ��� �� ���� �Ӽ��� �������ش�
//        j_DIettable.getColumnModel().getColumn(9).setCellEditor(new TableCell());
//        //table���� column�� �ҷ��� �� Ȱ��ȭ�Ҽ� �ְ�, �����Ҽ� �ְ� �����ش�
        
        j_DIettable.getColumnModel().getColumn(0).setPreferredWidth(50);
        j_DIettable.getColumnModel().getColumn(1).setPreferredWidth(200);
        //���̺� �÷� ���α��� ����
        
		
		s_Dietscroll.setBounds(50,70,900,400);
		p_Dieta2.setBounds(0,260,1000,480);
		//scroll.add(p_Dieta2_2);
		p_Dieta2.add(s_Dietscroll);
		p_Dietall.add(p_Dieta2);
		
		p_Dieta2.setLayout(null);
		p_Dietall.setLayout(null);
		
		jf.getContentPane().add(p_Dietall,BorderLayout.CENTER);
		jf.setSize(1000,1000);
		jf.setVisible(true);
		
		
		//��緹�ڵ带 �˻��Ͽ� DefaultTableModle�� �ø���
        system.getList(d_Dietdt);
      
        //ù���� ����.
        if (d_Dietdt.getRowCount() > 0) {
            j_DIettable.setRowSelectionInterval(0, 0);
        }
	}
	
	
//	class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer{
//		 
//        JButton b_DietChoice;
//         
//        public TableCell() {
//            // TODO Auto-generated constructor stub
//        	b_DietChoice = new JButton("��ư");
//             
//        	b_DietChoice.addActionListener(e -> {
//        		//DietVO ����: ������
//        		DietSelectVO vo = new DietSelectVO();
//        		vo.setDSF_NO((Integer.parseInt(String.valueOf(j_DIettable.getValueAt(j_DIettable.getSelectedRow(), 0)))));
//        		vo.setDSF_NAME((String.valueOf(j_DIettable.getValueAt(j_DIettable.getSelectedRow(), 1))));
//        		vo.setDSF_CALORIE((Integer.parseInt(String.valueOf(j_DIettable.getValueAt(j_DIettable.getSelectedRow(), 3)))));
//                System.out.print(j_DIettable.getValueAt(j_DIettable.getSelectedRow(), 0)+", ");
//                System.out.print(j_DIettable.getValueAt(j_DIettable.getSelectedRow(), 1)+", ");
//                System.out.println(j_DIettable.getValueAt(j_DIettable.getSelectedRow(), 3));
//                
//            });
//         
//        }
//         
//        @Override
//        public Object getCellEditorValue() {
//            // TODO Auto-generated method stub
//            return null;
//        }
//        @Override
//        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
//                int row, int column) {
//            // TODO Auto-generated method stub
//            return b_DietChoice;
//        }
//        @Override
//        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
//                int column) {
//            // TODO Auto-generated method stub
//            return b_DietChoice;
//        }
//	}
//	
	
	
	
	
	//�̺�Ʈ ó��
	public void actionPerformed(ActionEvent ae) {
			
	}
	
}
