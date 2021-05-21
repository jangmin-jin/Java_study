package day_027;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEx07 {

	public static void main(String[] args) {
		System.out.println("시작");
		
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		// 반드시 다 닫아줘야 한다.
		// Connection 인터페이스를 불러온다.
		Connection conn = null;
		Statement stmt = null;
		
		// ResultSet 생성 - select를 위한 sql 인터페이스
		ResultSet rs = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("드라이버 로딩 성공");
			
			// 입력된 데이터 기반으로 연결
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("데이터 베이스 연결 성공");
			
			stmt = conn.createStatement();
			String sql = String.format("select deptno, dname, loc from dept");
			
			// 쿼리 실행
			rs = stmt.executeQuery(sql);
			
			// 커서를 움직여야 데이터가 보인다. : 초기 커서 위치에선 아무것도 못읽음.
			rs.next();
			System.out.println( rs.getString("deptno") );
			System.out.println( rs.getString("dname") );
			System.out.println( rs.getString("loc") );
			
			// 커서를 움직여야 다음 행의 데이터가 보인다.
			rs.next();
			System.out.println( rs.getString("deptno") );
			System.out.println( rs.getString("dname") );
			System.out.println( rs.getString("loc") );
			
		} catch (ClassNotFoundException e) {
			System.out.println("에러 : " + e.getMessage());
			System.out.println("에러처리");
		} catch (SQLException e) {
			System.out.println("에러 : " + e.getMessage());
			System.out.println("에러처리");
			
		// 반드시 종료해야 한다.
		} finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
			if(stmt!=null) try {stmt.close();} catch(SQLException e) {}
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
		}
		System.out.println("끝");
	}
}