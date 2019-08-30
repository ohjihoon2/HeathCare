package com.mycom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class AdminDAO {
	//Field
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	String url = "jdbc:oracle:thin:@127.0.0.1:1521";
	String user = "HealthCare";
	String pass = "1234";
	
	//Constructor
	public AdminDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1�ܰ� ����~");
			
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("2�ܰ� ����~");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Method
	
	/** 3�ܰ� : PreparedStatement ��ü ���� **/
	public void getPreparedStatement(String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	public void getList(DefaultTableModel dtm_Adm) {
		String sql = "select cno, name, gender, phone, TO_CHAR(birth_date, 'MM/DD'), TO_CHAR(start_date, 'YY.MM.DD'), TO_CHAR(end_date, 'YY.MM.DD'), gx_code, gx_price, gx_count, gx_validity, bmi, fat, pbf, whr from member";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			
			// DefaultTableModel�� �ִ� ���� ������ �����
			for(int i=0; i<dtm_Adm.getRowCount();) {
				dtm_Adm.removeRow(0);
			}
			
			while(rs.next()) {
				Object data[] = { 
				rs.getInt(1), 
			    rs.getString(2),
                rs.getString(3), 
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getString(7),
                rs.getString(8),
                rs.getInt(9),
                rs.getInt(10),
                rs.getString(11),
                rs.getString(12),
                rs.getString(13),
                rs.getString(14),
                rs.getString(15)
                };
 
			   dtm_Adm.addRow(data); //DefaultTableModel�� ���ڵ� �߰�
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void getLecture(DefaultTableModel lec_Adm) {
		String sql = "select * from lecture";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			
			// DefaultTableModel�� �ִ� ���� ������ �����
			for(int i=0; i<lec_Adm.getRowCount();) {
				lec_Adm.removeRow(0);
			}
			
			while(rs.next()) {
				Object data[] = { 
				rs.getString(1), 
			    rs.getString(2),
                rs.getInt(3), 
                };
 
				lec_Adm.addRow(data); //DefaultTableModel�� ���ڵ� �߰�
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
