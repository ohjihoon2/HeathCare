package com.mycom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
			System.out.println("1단계 성공~");
			
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("2단계 성공~");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Method
	
	/** 3단계 : PreparedStatement 객체 생성 **/
	public void getPreparedStatement(String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	/**
	 * 
	 * memberList 출력
	 * @param dtm_Adm
	 */
	public void getMember(DefaultTableModel dtm_Adm) {
		String sql = "select cno, name, gender, phone, TO_CHAR(birth_date, 'MM/DD'), TO_CHAR(start_date, 'YY.MM.DD'), TO_CHAR(end_date, 'YY.MM.DD'), gx_code, gx_price, gx_count, gx_validity, bmi, fat, pbf, whr from member where division =1";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			
			// DefaultTableModel에 있는 기존 데이터 지우기
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
 
			   dtm_Adm.addRow(data); //DefaultTableModel에 레코드 추가
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
			
			// DefaultTableModel에 있는 기존 데이터 지우기
			for(int i=0; i<lec_Adm.getRowCount();) {
				lec_Adm.removeRow(0);
			}
			
			while(rs.next()) {
				Object data[] = { 
				rs.getString(1), 
			    rs.getString(2),
                rs.getInt(3) 
                };
 
				lec_Adm.addRow(data); //DefaultTableModel에 레코드 추가
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getMember(DefaultTableModel dtm_Adm, int cno) {
		String sql = "select cno, name, gender, phone, TO_CHAR(birth_date, 'MM/DD'), TO_CHAR(start_date, 'YY.MM.DD'), TO_CHAR(end_date, 'YY.MM.DD'), gx_code, gx_price, gx_count, gx_validity, bmi, fat, pbf, whr from member where cno = ?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setInt(1, cno);	
			rs = pstmt.executeQuery();
			
//			ResultSetMetaData rsMetaData = rs.getMetaData();
			
			// 데이터를 담을 오브젝트 생성
//			Object [] data = new Object[rsMetaData.getColumnCount()];
//			 DefaultTableModel에 있는 기존 데이터 지우기
			for(int i=0; i<dtm_Adm.getRowCount();) {
				dtm_Adm.removeRow(0);
			}
//			dtm_Adm.setRowCount(0);
			
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
 
			   dtm_Adm.addRow(data); //DefaultTableModel에 레코드 추가
//				dtm_Adm = new DefaultTableModel(data,0);
//				new JTable(dtm_Adm);
//				dtm_Adm.fireTableDataChanged(); //DefaultTableModel에 레코드 수정
			}
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
//	/** Update **/
//	public int getResultUpdate(MemberVO vo) {
//		int result = 0;
//		String sql = "update member set btitle = ?, bcontent = ? where bno = ?";
//		getPreparedStatement(sql);
//		System.out.println(vo.getBtitle());
//		System.out.println(vo.getBcontent());
//		System.out.println(vo.getBno());
//		try {
//			pstmt.setString(1, vo.getBtitle());
//			pstmt.setString(2, vo.getBcontent());
//			pstmt.setInt(3, vo.getBno());
//			
//			result = pstmt.executeUpdate();
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
	
	
	/** Delete **/
	public int getResultDelete(int bno) {
		int result = 0;
		String sql = "delete from si_board where bno = ?";
		getPreparedStatement(sql);
		try {
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/** 종료 **/
	public void close() {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();			
		}catch(Exception e) {e.printStackTrace();}
	}

}
