package com.mycom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.mycom.vo.MemberVO;



public class AdminDAO {
	//Field
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	String url = "jdbc:oracle:thin:@211.63.89.226:1521";
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
	 * @return 
	 */
	public ArrayList<MemberVO> getMember(DefaultTableModel dtm_Adm) {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		String sql = "select cno, name, gender, phone, TO_CHAR(birth_date, 'YY/MM/DD'), TO_CHAR(start_date, 'YY.MM.DD'), TO_CHAR(end_date, 'YY.MM.DD'), gx_code, gx_price, gx_count, gx_validity, bmi, fat, pbf, whr, S_WEIGHT, GYM_PRICE from member where division =1";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setCno(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setGender(rs.getString(3));
				vo.setPhone(rs.getString(4));
				vo.setBirth_date(rs.getString(5));
				vo.setStart_date(rs.getString(6));
				vo.setEnd_date(rs.getString(7));
				vo.setGx_code(rs.getString(8));
				vo.setGx_price(rs.getInt(9));
				vo.setGx_count(rs.getInt(10));
                vo.setGx_validity(rs.getString(11));
                vo.setBmi(rs.getString(12));
                vo.setFat(rs.getString(13));
                vo.setPbf(rs.getString(14));
                vo.setWhr(rs.getString(15));
                vo.setS_weight(rs.getString(16));
                vo.setGym_price(rs.getInt(17));
                list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
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
		String sql = "select cno, name, gender, phone, TO_CHAR(birth_date, 'YY/MM/DD'), TO_CHAR(start_date, 'YY.MM.DD'), TO_CHAR(end_date, 'YY.MM.DD'), gx_code, gx_price, gx_count, gx_validity, bmi, fat, pbf, whr from member where cno = ?";
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
	
	/** Update **/
	public int getResultUpdate(MemberVO vo) {
		int result = 0;
		
		String sql = "update member set name=?, gender=?, address=?, "
				+ "phone=?, birth_date =?, gx_code=?"
				+ "where cno=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getGender());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getPhone());
			pstmt.setString(5, vo.getBirth_date());
			pstmt.setString(6, vo.getGx_code());
			pstmt.setInt(7, vo.getCno());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/** Select : VO 객체 가져오기 **/
	public MemberVO getMember(int cno) {
		MemberVO vo = new MemberVO();
		String sql = "select cno, name, gender, phone, address, TO_CHAR(birth_date, 'YY/MM/DD'), TO_CHAR(start_date, 'YY.MM.DD'), TO_CHAR(end_date, 'YY.MM.DD'), gx_code, gx_price, gx_count, gx_validity, bmi, fat, pbf, whr from member where cno = ?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setInt(1, cno);	
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
					vo.setCno(rs.getInt(1)); 
				    vo.setName(rs.getString(2));
				    vo.setGender(rs.getString(3));
				    vo.setPhone(rs.getString(4));
				    vo.setAddress(rs.getString(5));
				    vo.setBirth_date(rs.getString(6));
				    vo.setStart_date(rs.getString(7));
				    vo.setEnd_date(rs.getString(8));
				    vo.setGx_code(rs.getString(9));
				    vo.setGx_price(rs.getInt(10));
				    vo.setGx_count(rs.getInt(11));
				    vo.setGx_validity(rs.getString(12));
				    vo.setBmi(rs.getString(13));
				    vo.setFat(rs.getString(14));
				    vo.setPbf(rs.getString(15));
				    vo.setWhr(rs.getString(16));
 
			}
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return vo;
	}
	
	/** Select : VO 객체 가져오기 **/
	public MemberVO getMember(String code) {
		MemberVO vo = new MemberVO();
		String sql = "select cno, name, gender, phone, address, TO_CHAR(birth_date, 'YY/MM/DD'), TO_CHAR(start_date, 'YY.MM.DD'), TO_CHAR(end_date, 'YY.MM.DD'), gx_code, gx_price, gx_count, gx_validity, bmi, fat, pbf, whr from member where gx_code = ?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, code);	
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
					vo.setCno(rs.getInt(1)); 
				    vo.setName(rs.getString(2));
				    vo.setGender(rs.getString(3));
				    vo.setPhone(rs.getString(4));
				    vo.setAddress(rs.getString(5));
				    vo.setBirth_date(rs.getString(6));
				    vo.setStart_date(rs.getString(7));
				    vo.setEnd_date(rs.getString(8));
				    vo.setGx_code(rs.getString(9));
				    vo.setGx_price(rs.getInt(10));
				    vo.setGx_count(rs.getInt(11));
				    vo.setGx_validity(rs.getString(12));
				    vo.setBmi(rs.getString(13));
				    vo.setFat(rs.getString(14));
				    vo.setPbf(rs.getString(15));
				    vo.setWhr(rs.getString(16));
 
			}
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return vo;
	}
	
	/** Delete **/
	public int getResultDelete(int cno) {
		int result = 0;
		String sql = "delete from member where cno = ?";
		getPreparedStatement(sql);
		try {
			pstmt.setInt(1, cno);
			
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
