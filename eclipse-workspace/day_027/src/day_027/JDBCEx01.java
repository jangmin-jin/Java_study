package day_027;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCEx01 {

	public static void main(String[] args) {
		System.out.println("시작");
		
		// 드라이버 클래스의 동적로딩 ( 실행시 )
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("에러 : " + e.getMessage());
			System.out.println("에러처리");
		}
		
		// 데이터 베이스 url, user명, ps비밀번호 입력
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		// Connection 인터페이스를 불러온다.
		Connection conn = null;
		
		try {
			// 입력된 데이터 기반으로 연결
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("데이터 베이스 연결 성공");
		} catch (SQLException e) {
			System.out.println("에러 : " + e.getMessage());
		
		// 반드시 종료해야 한다.
		} finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
		System.out.println("끝");
	}
}