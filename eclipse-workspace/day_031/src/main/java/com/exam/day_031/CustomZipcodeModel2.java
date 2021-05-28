package com.exam.day_031;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class CustomZipcodeModel2 extends AbstractTableModel {
	
	// 최종 결과를 담을 변수 datas 선언
	private ArrayList<ArrayList<String>> datas;
	
	// column들의 이름을 정해준다.
	private String[] columnNames = new String[] {
			"\uC6B0\uD3B8\uBC88\uD638", "\uC2DC\uB3C4", "\uAD6C\uAD70", "\uB3D9", "\uB9AC", "\uBC88\uC9C0"
		};
	
	// 생성자
	public CustomZipcodeModel2(String strDong){
		// mysql 접속
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// datas 초기화
		this.datas = new ArrayList();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			// sql 검색 조건
			String sql = "select zipcode, sido, gugun, dong, ri, bunji from zipcode where dong like ?";
			
			pstmt = conn.prepareStatement(sql);
			// 입력한 값 을 포함하는 결과를 불러온다.
			pstmt.setString(1, strDong +"%");
			
			rs = pstmt.executeQuery();
			
			// 2차원 배열형식으로 만들기 위해
			// ArrayList<String> data에 요소별로 배열 데이터를 추가하여
			// 다시 ArrayList<ArrayList<String>> datas에 넣어준다.
			while(rs.next()) {
				ArrayList<String> data = new ArrayList();
				data.add( rs.getString("zipcode") );
				data.add( rs.getString("sido") );
				data.add( rs.getString("gugun") );
				data.add( rs.getString("dong") );
				data.add( rs.getString("ri") );
				data.add( rs.getString("bunji") );
				
				// 2차원 배열
				datas.add(data);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) try {conn.close();} catch(SQLException e) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(rs != null) try {rs.close();} catch(SQLException e) {}
		}
	}

	@Override
	public String getColumnName(int column) {
		// 새로운 컬럼의 이름들을 반환
		return columnNames[column];
	}
	
	@Override
	public int getRowCount() {
		// 행의 갯수
		return datas.size();
	}

	@Override
	public int getColumnCount() {
		// 열의 갯수
		return datas.get(0).size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// 모든 데이터가 담긴 2차원 배열을 반환
		return datas.get(rowIndex).get(columnIndex);
	}
}