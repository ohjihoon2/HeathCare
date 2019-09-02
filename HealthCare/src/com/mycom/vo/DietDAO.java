package com.mycom.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.*;

public class DietDAO {
	
	//Field
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	String url = "jdbc:oracle:thin:@127.0.0.1:1521";
	String user = "scott";
	String pass = "tiger";
	
	//Constructor
	public DietDAO() {
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
	/** 3�ܰ� : Statement ��ü ���� **/
	public void getStatement() {
		try {
			stmt = conn.createStatement();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 3�ܰ� : PreparedStatement ��ü ���� **/
	public void getPreparedStatement(String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/** 4~5 �ܰ� : ��ü ����Ʈ ��� **/
	public void getList(DefaultTableModel t_model) {
		String sql = "select * from food order by f_no asc";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			
			// DefaultTableModel�� �ִ� ���� ������ �����
			for(int i=0; i<t_model.getRowCount();) {
				t_model.removeRow(0);
			}
			
			while(rs.next()) {
				   Object data[] = { 
						   rs.getInt(1), 
						   rs.getString(2),
	                       rs.getInt(3), 
	                       rs.getInt(4),
	                       rs.getInt(5),
	                       rs.getInt(6),
	                       rs.getInt(7),
	                       rs.getInt(8),
	                       rs.getInt(9)
	                        };
	 
	            t_model.addRow(data); //DefaultTableModel�� ���ڵ� �߰�
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/** ���̾�Ʈ �Ĵ� �˻� **/
	public void getResultDietSearch(DefaultTableModel t_model,String name){
		
		String sql = "select * from food where f_name like ?"
				+ " order by f_no asc";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, "%"+name+"%");
			rs = pstmt.executeQuery();
			
			// DefaultTableModel�� �ִ� ���� ������ �����
			for(int i=0; i<t_model.getRowCount();) {
				t_model.removeRow(0);
			}
			
			while(rs.next()) {
				   Object data[] = { 
						   rs.getInt(1), 
						   rs.getString(2),
	                       rs.getInt(3), 
	                       rs.getInt(4),
	                       rs.getInt(5),
	                       rs.getInt(6),
	                       rs.getInt(7),
	                       rs.getInt(8),
	                       rs.getInt(9)
	                        };
	 
	            t_model.addRow(data); //DefaultTableModel�� ���ڵ� �߰�
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/** 4~5 �ܰ� : �˻� ������ �߰� **/
	public int getResultInseret(DietSelectVO vo) {
		int result = 0;
		
		String sql  = "insert into DietSelect values"
				+ " (SEQU_DietSelect.NEXTVAL,?,?,?,sysdate)";
		
		getPreparedStatement(sql);
		
		try {
			pstmt.setInt(1,vo.getDSF_NO());
			pstmt.setString(2,vo.getDSF_NAME());
			pstmt.setInt(3,vo.getDSF_CALORIE());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/** 4~5 �ܰ� : �˻� ���� ����Ʈ ��� **/
	public void getInsertList2(DefaultTableModel t_model) {
		String sql = "select DSF_NO,DSF_NAME,DSF_CALORIE,to_char(DS_DATE,'yyyy-mm-dd')  from DietSelect order by DS_NO asc";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			
			// DefaultTableModel�� �ִ� ���� ������ �����
			for(int i=0; i<t_model.getRowCount();) {
				t_model.removeRow(0);
			}
			
			while(rs.next()) {
				   Object data[] = { 
						   rs.getInt(1),
	                       rs.getString(2), 
	                       rs.getInt(3),
	                       rs.getString(4)
	                      
	                       
	                        };
	 
	            t_model.addRow(data); //DefaultTableModel�� ���ڵ� �߰�
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**ȸ������ ���**/
	public DietMemberVO getMemberInfo(int cno) {
		DietMemberVO mvo = new DietMemberVO();
		String sql="select * from member" 
				+ " where cno=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setInt(1, cno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mvo.setCNO(rs.getInt(1));
				mvo.setNAME(rs.getString(2));
				mvo.setGENDER(rs.getString(3));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mvo;
	}
	
	/**������ ���**/
	public int getInsertWeigth(DietMemberVO mvo2) {
		int result = 0;
		
		String sql = "insert into DietWeight values (SEQU_DIETWEIGHT.NEXTVAL,?,?,?,?)";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, mvo2.getDW_WEIGHT());
			pstmt.setString(2, mvo2.getDW_TARGETWEIGHT());
			pstmt.setString(3, mvo2.getDW_DATE());
			pstmt.setInt(4, mvo2.getCNO());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/** ������ ��� **/
	public DietMemberVO getResultWeight(int cno,String time1) {
		DietMemberVO vo = new DietMemberVO();
		String sql = "select d.DW_NO, d.cno, m.name, m.GENDER, dw_weight, d.DW_TARGETWEIGHT, to_char(DW_DATE,'yyyy-MM-dd') "
				+" from dietweight d,member m"  
				+" where d.cno = m.cno"
				+" and d.cno = ?"
				+" and to_char(DW_DATE,'yyyy-MM-dd') = ?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setInt(1, cno);
			pstmt.setString(2, time1);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setDW_NO(rs.getInt(1));
				vo.setCNO(rs.getInt(2));
				vo.setNAME(rs.getString(3));
				vo.setGENDER(rs.getString(4));
				vo.setDW_WEIGHT(rs.getString(5));
				vo.setDW_TARGETWEIGHT(rs.getString(6));
				vo.setDW_DATE(rs.getString(7));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	
	
	/**�������� ���(ȸ������,������,Į�θ�)**/
	public int getInsertDiet(DietSaveVO dsvo) {
		int result = 0;
		
		String sql = "insert into DIETSAVE values (?,?,?,?)";
		getPreparedStatement(sql);
		
		try {
			pstmt.setInt(1, dsvo.getDS_SelectKcal());
			pstmt.setInt(2, dsvo.getDS_RECOMMEND());
			pstmt.setInt(3, dsvo.getDS_RESULTKCAL());
			pstmt.setInt(4, dsvo.getCNO());
			
			
			System.out.println( dsvo.getDS_SelectKcal());
			System.out.println( dsvo.getDS_RECOMMEND());
			System.out.println( dsvo.getDS_RESULTKCAL());
			System.out.println( dsvo.getDW_WEIGHT());
			System.out.println(dsvo.getCNO());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/** 6�ܰ� : ����**/
	public void close() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
