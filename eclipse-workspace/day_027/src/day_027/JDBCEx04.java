package day_027;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEx04 {

	public static void main(String[] args) {
		
		System.out.println("시작");
		
		// 데이터 베이스 url, user명, ps비밀번호 입력
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		// Connection 인터페이스를 불러온다.
		Connection conn = null;
		
		// java.sql 패키지 인터페이스 임포트
		Statement stmt = null;
		
		// 드라이버 클래스의 동적로딩 ( 실행시 )
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("드라이버 로딩 성공");
			
			// 입력된 데이터 기반으로 연결
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("데이터 베이스 연결 성공");
			
			// connection Statement
			stmt = conn.createStatement();
			// 이 문장을 Statement을 이용해서 실행시켜줘
			// Insert, Updata, Delete [DDL]
			
			// 변수를 이용하여 선언 하는 방법
			String deptno = "12";
			String dname = "개발부";
			String loc = "쓰울";
			
			// 문자열에는 반드시 ' 단일 따음표와 " 쌍 따옴표를 함께 사용해주어야 한다.
			
			// String sql = "insert into dept2 values ( " + deptno + ", '" + dname + "', '" + loc + "' )";
			String sql = String.format("insert into dept2 values (%s, '%s', '%s')", deptno, dname, loc);
			
			int result = stmt.executeUpdate(sql);
			
			System.out.println( "성공 : " + result );
			
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
		}
		System.out.println("끝");
	}
}