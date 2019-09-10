package com.mycom.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import com.mycom.system.GymExtentionSystem;
import com.mycom.vo.GymExtentionVO;

public class GymExtentionUI implements ActionListener {
	//field
	MainScreenUI mainui;
	StartUI startui;
	GymExtentionSystem system = new GymExtentionSystem();
	GymExtentionVO choicevo;
	Vector<String> vt;
	int month = 0;   
	int price = 0;
	
	//UI화면
	JPanel  p_main, p_title, p_table, p_price, p_checkdate,p_checkprice,p_extention,p_top, p_blank;
	JLabel lb_title, lb_checkdate, lb_checkpirce;
	JScrollPane js;
	JTable table;
	DefaultTableModel model = null;
	ArrayList<GymExtentionVO> tablelist;
	JTextField jtf_checkprice,jtf_checkdate;
	JButton btn_extention, btn_back;
	
	ImageIcon ic_gx_topimg;
    JLabel ic_gx_topimgBox;
	
	//constructor
	public GymExtentionUI(MainScreenUI mainui, StartUI startui) {
		this.startui = startui;
		this.mainui = mainui;
		
		tablelist = system.getPriceList();
		
		Vector<String> columnList = new Vector<String>();
		columnList.add("개  월  수");
		columnList.add("가       격");
		columnList.add("할인 가격");
		columnList.add("할인 금액");
		columnList.add("연장 선택");

		model = new DefaultTableModel(columnList,0);
		for(GymExtentionVO vo : tablelist) {
			vt = new Vector<String>();
			vt.add(vo.getMonth());
			vt.add(String.valueOf(vo.getOrigprice()));
			vt.add(String.valueOf(vo.getSaleprice()));
			vt.add(String.valueOf(vo.getSaveprice()));
			
			model.addRow(vt);
		}
		
		
		
		p_main = new JPanel(new GridLayout(3,1));
		p_title = new JPanel();
		p_table = new JPanel();
		p_top = new JPanel(new GridLayout(2,1));
		p_blank = new JPanel();
		p_price = new JPanel(new GridLayout(3,1));
		p_checkdate = new JPanel();
		p_checkprice = new JPanel();
		p_extention = new JPanel();

        ic_gx_topimg = new ImageIcon("image/logo3.jpg");
        ic_gx_topimgBox = new JLabel(ic_gx_topimg);
		
		lb_title = new JLabel("*** 헬스 연장 신청 ***");
		lb_title.setFont(new Font("굴림", Font.BOLD, 20));
		lb_checkdate = new JLabel("헬스 연장 기간 확인");
		lb_checkpirce = new JLabel("헬스 연장 금액 확인");
	

		btn_extention = new JButton("연장 신청");
		btn_extention.setBackground(Color.getHSBColor(0.85f, 0.05f, 0.95f));
		btn_back = new JButton("돌아가기");
		btn_back.setBackground(Color.getHSBColor(0.85f, 0.05f, 0.95f));
		jtf_checkprice = new JTextField(30);
		jtf_checkdate = new JTextField(30);
				
		p_main.add(p_top);p_main.add(p_table);p_main.add(p_price);
		p_price.add(p_checkdate); p_price.add(p_checkprice); p_price.add(p_extention);
		p_top.add(p_blank); p_top.add(p_title);
		p_blank.add(ic_gx_topimgBox); p_title.add(lb_title);
		
		table = new JTable(model);
		js = new JScrollPane(table);
		table.setBackground(Color.getHSBColor(0.85f, 0.05f, 0.95f));
		table.getColumnModel().getColumn(4).setCellRenderer(new TableCell());
	        //table에서 column을 불러온 뒤 셀의 속성을 설정해준다
		table.getColumnModel().getColumn(4).setCellEditor(new TableCell());
	        //table에서 column을 불러온 뒤 활성화할수 있고, 편집할수 있게 고쳐준다	
	        
		//white
		p_main.setBackground(Color.WHITE);
		p_title.setBackground(Color.WHITE); 
		p_table.setBackground(Color.WHITE); 
		p_price.setBackground(Color.WHITE); 
		p_checkdate.setBackground(Color.WHITE);
		p_checkprice.setBackground(Color.WHITE);
		p_extention.setBackground(Color.WHITE);
		p_top.setBackground(Color.WHITE);
		p_blank.setBackground(Color.WHITE);
		js.getViewport().setBackground(Color.WHITE);
		
		js.setPreferredSize(new Dimension(700,150));
		p_table.add(js);

		p_checkdate.add(lb_checkdate);
		p_checkdate.add(jtf_checkdate);
		p_checkprice.add(lb_checkpirce);
		p_checkprice.add(jtf_checkprice);
		p_extention.add(btn_extention, BorderLayout.SOUTH);	
		p_extention.add(btn_back, BorderLayout.SOUTH);	
		
		startui.jf.getContentPane().add(p_main, BorderLayout.CENTER);
		startui.jf.getContentPane().setBackground(Color.WHITE);
		p_main.setSize(1000,600);
		p_main.setVisible(true);
                	
        
        //이벤트처리
        btn_extention.addActionListener(this);
        btn_back.addActionListener(this);
		
		
		
	}
	
	class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer{
	       
        JButton btn_exChoice;
         
        public TableCell() {
            // TODO Auto-generated constructor stub
        	btn_exChoice = new JButton("선택");
             
        	btn_exChoice.addActionListener(e -> {
        		//DietVO 생성: 데이터
        		choicevo = new GymExtentionVO();
        		choicevo.setMonth(String.valueOf(table.getValueAt(table.getSelectedRow(), 0)));
        		choicevo.setOrigprice(Integer.parseInt(String.valueOf(table.getValueAt(table.getSelectedRow(), 1))));
        		choicevo.setSaleprice((Integer.parseInt(String.valueOf(table.getValueAt(table.getSelectedRow(), 2)))));
        		choicevo.setSaveprice((Integer.parseInt(String.valueOf(table.getValueAt(table.getSelectedRow(), 3)))));
        		
        		
        		Calendar cal = Calendar.getInstance();
        		if(choicevo.getMonth().equals("1개월")) {
        			month = 1;
        			price = 50000;
        			choicMonthInit(month, price, cal);

        		}else if(choicevo.getMonth().equals("3개월")) {
        			month = 3;
        			price = 130000;
        			choicMonthInit(month, price, cal);
        			
        		}else if(choicevo.getMonth().equals("6개월")) {
        			month = 6;
        			price = 250000;
        			choicMonthInit(month, price, cal);
        			
        		}else if(choicevo.getMonth().equals("12개월")) {
        			month = 12;
        			price = 450000;
        			choicMonthInit(month, price, cal);
        			
        		}
        		

            });
         
        }
         
        @Override
        public Object getCellEditorValue() {
            // TODO Auto-generated method stub
            return null;
        }
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            // TODO Auto-generated method stub
            return btn_exChoice;
        }
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                int column) {
            // TODO Auto-generated method stub
            return btn_exChoice;
        }
        
        
   }

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj==btn_extention) {
			int result = JOptionPane.showConfirmDialog(null, "연장 신청하시겠습니까?");
			
			
			if(result == 0) {
				system.update(StartUI.vo.getCno(), month, price);
				JOptionPane.showMessageDialog(null, "연장 성공");
				
			}else if(result == 1){
				JOptionPane.showMessageDialog(null, "연장 실패");
				
			}else {
				JOptionPane.showMessageDialog(null, "연장 취소");
			}
		}else if(obj==btn_back) {
			p_main.setVisible(false);
			new MainScreenUI(startui);
			
		}
		
	}
	
	//method
	public void choicMonthInit(int month, int price, Calendar cal) {

		String year = startui.vo.getEnd_date().substring(0, 4);
		String mon = startui.vo.getEnd_date().substring(5, 7);
		String date = startui.vo.getEnd_date().substring(8, 10);

		cal.set(Calendar.YEAR, 	Integer.parseInt(year));
		cal.set(Calendar.MONTH, Integer.parseInt(mon));
		cal.set(Calendar.DATE, Integer.parseInt(date));
		cal.add(Calendar.MONTH,month-1);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");					
		formatter.format(cal.getTime());
		
		jtf_checkdate.setText(formatter.format(cal.getTime()));
		jtf_checkprice.setText(String.valueOf(price));
		
	}
	
}
