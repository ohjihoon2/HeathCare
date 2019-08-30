package diet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.*;

public class DietDAO2 {
	
	//Field
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	String url = "jdbc:oracle:thin:@127.0.0.1:1521";
	String user = "scott";
	String pass = "tiger";
	
	//Constructor
	public DietDAO2() {
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
	

}
