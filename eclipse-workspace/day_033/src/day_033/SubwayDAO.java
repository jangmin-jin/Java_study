package day_033;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubwayDAO {
	private Connection conn;
	
	public SubwayDAO() {
		// TODO Auto-generated constructor stub
		
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		// 생성자 호출과 동시에 Connection 열기
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			this.conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		}
		
	}
	
	public ArrayList<SubwayTO> listLocal() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<SubwayTO> locals = new ArrayList<SubwayTO>();
		// combobox의 제목이 될 데이터 추가
		SubwayTO to = new SubwayTO();
		to.setLocal( "지역" );
		locals.add(to);
		
		try {
			String sql = "select distinct local from table_subway";
			pstmt = conn.prepareStatement(sql);
			
			// 쿼리 실행
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				to = new SubwayTO();
				// db에서 가져온 local의 값을 to에 저장
				// System.out.println( "listLocal() : " + rs.getString( "local" ) );
				to.setLocal( rs.getString( "local" ) );
				// local의 값이 담긴 to를 arraylist에 저장
				locals.add(to);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
		}

		
		return locals;
	}
	
	public ArrayList<SubwayTO> listLine( String strLocal ) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<SubwayTO> lines = new ArrayList<SubwayTO>();
		// combobox의 제목이 될 데이터 추가
		SubwayTO to = new SubwayTO();
		to.setLine( "노선" );
		lines.add(to);
		
		try {
			String sql = "select distinct line from table_subway where local = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strLocal);
			
			// 쿼리 실행
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				to = new SubwayTO();
				// db에서 가져온 line의 값을 to에 저장
				// System.out.println( "listLine() : " + rs.getString( "line" ) );
				to.setLine( rs.getString( "line" ) );
				// line의 값이 담긴 to를 arraylist에 저장
				lines.add(to);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
		}
		
		return lines;
	}
	
	
	
	public ArrayList<SubwayTO> searchStation( String strLocal, String strLine ) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<SubwayTO> datas = new ArrayList<SubwayTO>();
		
		try {
			String sql = "select no, local, line, station from table_subway where local = ? and line = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strLocal);
			pstmt.setString(2, strLine);
			
			// 쿼리 실행
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				SubwayTO to = new SubwayTO();
				// db에서 가져온 값을 to에 저장
				to.setNo( rs.getString( "no" ) );
				to.setLocal( rs.getString( "local" ) );
				to.setLine( rs.getString( "line" ) );
				to.setStation( rs.getString( "station" ) );
				// 값이 담긴 to를 arraylist에 저장
				datas.add(to);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
		}
		
		return datas;
	}
}
