package day_027;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEx06 {

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
			
			// DDL 테이블 생성
			// String sql = "create table dept3 ( deptno int(2), dname varchar(14), loc varchar(13) )";
			// 스트링 버퍼를 이용하여 더 효율적으로 처리해 줄 수 있다.
			
			StringBuffer sql = new StringBuffer();
			sql.append("create table dept4");
			sql.append("(");
			sql.append("deptno int(2)");
			sql.append(",");
			sql.append("dname varchar(14)");
			sql.append(",");
			sql.append("loc varchar(13)");
			sql.append(")");
			
			// 스트링 버퍼라서 바로 못넣기 때문에 .toString을 이용하여 안의 값을 넣어준다.
			int result = stmt.executeUpdate( sql.toString( ) );
			
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