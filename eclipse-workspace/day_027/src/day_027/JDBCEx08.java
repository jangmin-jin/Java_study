package day_027;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEx08 {

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
			
			// 반복문을 통한 모든 데이터 읽어오기
			// rs.next()는 빈값에 도달하면 false의 값을 출력한다.
			while( rs.next() ) {
				// System.out.println( rs.getString("deptno") );
				// System.out.println( rs.getString("dname") );
				// System.out.println( rs.getString("loc") );
				
				// 컬럼명을 모르는 경우에는 번호로 접근 가능하다.
				System.out.println( rs.getString(1) );
				System.out.println( rs.getString(2) );
				System.out.println( rs.getString(3) );
			}
			
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