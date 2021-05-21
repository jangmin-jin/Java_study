// 10번 부서의 사원번호, 사원이름, 직책, 연봉을 출력하는 자바 프로그램 작성

package day_027;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCEx10 {

	public static void main(String[] args) {
		System.out.println("시작");
		
		// mysql 정보 입력
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		// 연결을 위한 인터페이스 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 드라이버 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			// 데이터 베이스 연결
			conn = DriverManager.getConnection(url, user, password);
			
			// SQL 실행 및 생성 결과 반환을 위한 개체 선언
			stmt = conn.createStatement();
			String sql = String.format("select empno, ename, job, ( sal*12 + ifnull(comm,0) ) annsal from emp where deptno=%s", "10");
			
			// 쿼리 실행
			rs = stmt.executeQuery(sql);
			
			// 반복문을 통한 모든 데이터 읽어오기
			while( rs.next() ) {
				 System.out.printf( "%5S", rs.getString("empno"));
				 System.out.printf("%10S", rs.getString("ename"));
				 System.out.printf("%12S", rs.getString("job"));
				 System.out.printf("%10S", rs.getString("annsal"));
				 System.out.println();
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