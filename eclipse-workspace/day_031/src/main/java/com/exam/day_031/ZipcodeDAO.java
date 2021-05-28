package com.exam.day_031;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// CRUD
public class ZipcodeDAO {
	private Connection conn =null;
	public ZipcodeDAO() {
		// 연결을 위한 생성자
		// TODO Auto-generated constructor stub
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		try {
			
			Class.forName("org.mariadb.jdbc.Driver");
			this.conn = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<ZipcodeTO> searchZipcode(String strDong){
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// datas 초기화
		ArrayList<ZipcodeTO> datas = new ArrayList();
		try {
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
				ZipcodeTO to = new ZipcodeTO();
				to.setZipcode( rs.getString("zipcode") );
				to.setSido( rs.getString("sido") );
				to.setGugun( rs.getString("gugun") );
				to.setDong( rs.getString("dong") );
				to.setRi( rs.getString("ri") );
				to.setBunji( rs.getString("bunji") );
				
				// 2차원 배열
				datas.add(to);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) try {conn.close();} catch(SQLException e) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(rs != null) try {rs.close();} catch(SQLException e) {}
		}
		
		return datas;
	}
}