package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// CRUD
public class DataDAO {
	private Connection conn =null;
	
	public DataDAO() {
		
		// 연결을 위한 생성자
		String url = "jdbc:mysql://localhost:3306/todolist";
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
	
	// 우편번호 검색 DAO
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
//			System.out.println(rs.next());
			
			// 2차원 배열형식으로 만들기 위해
			// ArrayList<String> data에 요소별로 배열 데이터를 추가하여
			// 다시 ArrayList<ArrayList<String>> datas에 넣어준다.
			while(rs.next()) {
				ZipcodeTO to = new ZipcodeTO();
				to.setZipcode( rs.getString("zipcode") );
//				System.out.println(rs.getString("zipcode"));
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
	
	// 주민번호 검사 DAO
	public boolean jumincheck(String jumin) {
		
		String juminSplit[] = jumin.split("");
		int juminNum[] = new int[13];
		
		if(juminSplit.length<13) {
			System.out.println("DAO : 주민번호 자리수가 맞지 않습니다");
			return false;
		}
		
		for(int i=0; i< juminNum.length; i++) {
			juminNum[ i ] = Integer.parseInt( juminSplit[ i ] );
		}
		
		int juminMulNum[] = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};
		int checkValue = 0;
		int checkLogicNum = 11;
		
		for(int i=0; i<juminMulNum.length; i++) {
			checkValue += juminNum[ i ] * juminMulNum[ i ];
		}
		
		int checkLogic = (checkLogicNum - (checkValue % checkLogicNum)) %10;
		
		if (checkLogic == juminNum[12]) {
//			System.out.println("DAO : 주민번호 검사 로직 통과");
			return true;
		}else {
//			System.out.println("DAO : 주민번호 형식이 올바르지 않음");
			return false;
		}
	}
	
	// 아이디 체크 DAO
	public boolean idCheck(String id) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// sql 검색 조건
			String sql = "select * from userdata where id like ?";
			
			pstmt = conn.prepareStatement(sql);
			// 입력한 값을 포함하는 결과를 불러온다.
			pstmt.setString(1, id +"%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if (id.matches(rs.getString("id")) && rs.getString("id").matches(id)) {
					System.out.println("중복아이디 검출");
					return false;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) try {conn.close();} catch(SQLException e) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(rs != null) try {rs.close();} catch(SQLException e) {}
		}
		return true;
	}
}