package day_032;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// DAO
public class SubwayDAO {
	
	private Connection conn = null;
	
	public SubwayDAO() {
		// database 연결을 위한 변수 선언
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		try {
			// database 연결
			Class.forName("org.mariadb.jdbc.Driver");
			this.conn = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<SubwayTO> searchSubway(String local, String line){
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<SubwayTO> datas = new ArrayList();
		
		try {
			// comboBox1, 2의 값을 이용하여 원하는 검색 결과 도출
			String sql = "select * from table_subway where local=? and line=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, local);
			pstmt.setString(2, line);
	
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SubwayTO to = new SubwayTO();
				to.setNo(rs.getString("no"));
				to.setLocal(rs.getString("local"));
				to.setLine(rs.getString("line"));
				to.setStation(rs.getString("station"));
				
				datas.add(to);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) try {conn.close();} catch(SQLException e) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(rs != null) try {rs.close();} catch(SQLException e) {}
		}
		
		// 결과 반환
		return datas;
	}
	
	// DAO
	// comboBox2에 노선을 추가 시켜주는 기능
	public ArrayList<SubwayTO> searchLine(String local){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<SubwayTO> datas = new ArrayList();
		
		try {
			// comboBox1에 선택된 지역 이름을 기준으로 노선을 검색.
			// 중복을 제거한다.
			String sql = "select distinct line from table_subway where local =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, local);
	
			rs = pstmt.executeQuery();
			
			// 노선 정보만 저장.
			while(rs.next()) {
				SubwayTO to = new SubwayTO();
				to.setLine(rs.getString("line"));
				
				datas.add(to);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) try {conn.close();} catch(SQLException e) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(rs != null) try {rs.close();} catch(SQLException e) {}
		}
		
		// 결과 반환
		return datas;
	}
}