package com.mycom.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mycom.vo.ClientVO;

public class registDAO {

	//Field
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	String url="jdbc:oracle:thin:@127.0.0.1:1521";
	String user= "scott";
	String pass ="tiger";
	
	//Constructor
	public registDAO() {
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
	
	/**
	 * 3�ܰ� : PreparedStatement ��ü ����
	 */
	public void getPreparedStatement(String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	/**
//	 * 4~5�ܰ� : ��ü ����Ʈ ���
//	 */
//	public ArrayList<StuVO> getList(){
//		ArrayList<StuVO> list = new ArrayList<StuVO>();
//		String sql = "select rownum, sno, sname, skor, seng, smath,stot, savg  "
//				+ " from (select  sno, sname, skor, seng, smath,stot, trunc(savg,2) savg from stu order by sno)";
//		//3�ܰ�
//		getPreparedStatement(sql);
//		try {
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				StuVO vo = new StuVO();
//				vo.setRno(rs.getInt(1));
//				vo.setSno(rs.getString(2));
//				vo.setSname(rs.getString(3));
//				vo.setSkor(rs.getInt(4));
//				vo.setSeng(rs.getInt(5));
//				vo.setSmath(rs.getInt(6));
//				vo.setStot(rs.getDouble(7));
//				vo.setSavg(rs.getDouble(8));
//				
//				//������ null �̶��. �ƹ��͵� �������� list.add(vo) �ǽ��غ��� --
//				list.add(vo);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		return list;
//	}
	
//	/**
//	 * 4~5�ܰ� : �ϳ��� row ���
//	 */
//	
//	public StuVO getListVO(String sno){
//		StuVO vo = new StuVO();
//		String sql ="select * from stu where sno=upper(?)";
//		//3�ܰ�
//		getPreparedStatement(sql);
//		try {
//			pstmt.setString(1, sno);
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				vo.setSno(rs.getString(1));
//				vo.setSname(rs.getString(2));
//				vo.setSkor(rs.getInt(3));
//				vo.setSeng(rs.getInt(4));
//				vo.setSmath(rs.getInt(5));
//				vo.setStot(rs.getDouble(6));
//				vo.setSavg(rs.getDouble(7));
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return vo;
//	}
	
	/**
	 * 4~5�ܰ� : ������ �߰� 
	 */
	public int getClientInsert(ClientVO vo) {
		int result =0;
//		getStatement();
		String sql = "INSERT INTO STU VALUES('SIST_'||SEQU_STU.NEXTVAL,?,?,?,?,?,?)";
		
		getPreparedStatement(sql);
		System.out.println("3�ܰ� ����~");
		
		try {
			//������ �����ϱ����� ����ǥ �ڸ��� �ϳ��ϳ� �־��ִ� ������ �ʿ��ϴ�.
			pstmt.setString(1, vo.getSname());
			pstmt.setInt(2, vo.getSkor());	
			pstmt.setInt(3, vo.getSeng());
			pstmt.setInt(4, vo.getSmath());
			pstmt.setDouble(5, vo.getStot());
			pstmt.setDouble(6, vo.getSavg());
			
			// api ���� �ŰԺ����� ���µ� ������ �ȶߴ����� 
			// result = pstmt.executeUpdate(sql); �� statement �� ����ϱ� ������ �Ű����� sql�� �־ ������ ���� ����. ������ Ʋ�������̴�.
			
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("4�ܰ� ����");
		}
		return result;
	}
	
	/**
	 * 4~5�ܰ� : ������ ���� 
	 */
	public int getUpdate(ClientVO vo) {
		int result = 0;
		String sql = "update stu set skor = ?, seng = ?, smath =? where sno = ?";
		getPreparedStatement(sql);
		System.out.println("3�ܰ� ����~");
		try {
			pstmt.setInt(1, vo.getSkor());
			pstmt.setInt(2, vo.getSeng());
			pstmt.setInt(3, vo.getSmath());
			pstmt.setString(4, vo.getSno());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("4�ܰ� ����");
		}
		return result;
	}
	
	/**
	 * 4~5�ܰ� : ������ ���� 
	 */
	public int getDelete(String sno) {
		int result = 0;
		String sql = "delete from stu where sno =upper(?)";
		getPreparedStatement(sql);
		System.out.println("3�ܰ� ����");

		try {
			pstmt.setString(1, sno);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("4�ܰ� ����");
		}
		return result;
	}
	
	/**
	 * 6�ܰ� : ����
	 */
	
	public void close() {
		try{
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �α��� üũ
	 * @param sid
	 * @param spass
	 * @return
	 */
	public int getResultLogin(String sid, String spass) {
		int result = 0;
		String sql = "SELECT COUNT(*) FROM STU_MEMBER WHERE SID=? AND SPASS=?";
		
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, sid);
			pstmt.setString(2, spass);
			
			// query�� select �̱� ������ resultSet���� �޾ƾ� �� 
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
}
