package day_027;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEx09 {

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
			// String sql = String.format("select empno, ename, sal, hiredate from emp");
			// 날짜 형태 변경, String.format과 충돌나기때문에 지워주어야 한다.
			// String sql = "select empno, ename, sal, date_format(hiredate, '%Y/%m/%d') hiredate from emp";
			
			// 충돌 안나게 하려면 %를 2개 써준다.
			// String.format을 사용하는 이유는 where문을 사용하기 편리하게 하기 위함이다.
			String sql = String.format("select empno, ename, sal, date_format(hiredate, '%%Y/%%m/%%d') hiredate from emp where deptno=%s", "10");
			
			// 쿼리 실행
			rs = stmt.executeQuery(sql);
			
			// 반복문을 통한 모든 데이터 읽어오기
			// rs.next()는 빈값에 도달하면 false의 값을 출력한다.
			while( rs.next() ) {
				 System.out.println( rs.getString("empno") );
				 System.out.println( rs.getString("ename") );
				 System.out.println( rs.getString("sal") );
				 System.out.println( rs.getString("hiredate") );
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