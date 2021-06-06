package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// 생성자를 통한 연결
public class DataDAO {
	private Connection conn =null;
	
	public DataDAO() {
		
		// 데이터베이스 연결을 위한 변수 선언
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
		
		ArrayList<ZipcodeTO> datas = new ArrayList();
		try {
			// sql 검색 조건 : 내가 입력한 dong에 해당하는 값을 찾는다.
			String sql = "select zipcode, sido, gugun, dong, ri, bunji from zipcode where dong like ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strDong +"%");
			
			rs = pstmt.executeQuery();
			
			// 2차원 배열형식으로 반환
			while(rs.next()) {
				ZipcodeTO to = new ZipcodeTO();
				to.setZipcode( rs.getString("zipcode") );
				to.setSido( rs.getString("sido") );
				to.setGugun( rs.getString("gugun") );
				to.setDong( rs.getString("dong") );
				to.setRi( rs.getString("ri") );
				to.setBunji( rs.getString("bunji") );
				
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
		
		// 주민번호가 13자리가 아닌경우
		if(juminSplit.length != 13) {
			System.out.println("DAO : 주민번호 자리수가 맞지 않습니다");
			return false;
		}
		// 배열화
		for(int i=0; i< juminNum.length; i++) {
			juminNum[ i ] = Integer.parseInt( juminSplit[ i ] );
		}
		
		// 주민번호 검사 로직에 해당하는 계산 실시
		int juminMulNum[] = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};
		int checkValue = 0;
		int checkLogicNum = 11;
		
		for(int i=0; i<juminMulNum.length; i++) {
			checkValue += juminNum[ i ] * juminMulNum[ i ];
		}
		
		int checkLogic = (checkLogicNum - (checkValue % checkLogicNum)) %10;
		
		// 주민번호 정상
		if (checkLogic == juminNum[12]) {
			return true;
		}else {
		// 주민번호 비정상
			return false;
		}
	}
	
	// 아이디 체크 DAO
	public boolean idCheck(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 아이디 중복확인 Dlg에서 입력한 값을 데이터베이스에서 검색
			String sql = "select * from userdata where id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			// 입력한 id가 데이터베이스에 있으면 가입 불가 : false처리
			while(rs.next()) {
				if (id.matches(rs.getString("id")) && rs.getString("id").matches(id)) {
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
		
		// 검사 통과 : true
		return true;
	}
	
	// 회원가입을 위한 DAO
	// 필요한 정보 id, pw, name, sex, jumin, email, zipcode, address, extraAddress
	public void signUp(String id, String pw, String name, String sex, String jumin, String email, String zipcode, String address, String extraAddress) {
		PreparedStatement pstmt = null;
		
		try {
			// sql 검색 조건 : userdata를 입력할 수 있는 형태
			String sql = "insert userdata values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			// 값을 입력한다.
			pstmt.setString( 1, id );
			pstmt.setString( 2, pw );
			pstmt.setString( 3, name );
			pstmt.setString( 4, sex );
			pstmt.setString( 5, jumin );
			pstmt.setString( 6, email );
			pstmt.setString( 7, zipcode );
			pstmt.setString( 8, address );
			pstmt.setString( 9, extraAddress );
			
			int result = pstmt.executeUpdate();
			// System.out.println("데이터 전송 성공 유무" + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) try {conn.close();} catch(SQLException e) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
		}
	}

	// 아이디 검사 DAO
	public int logInCheck(String id, String pw) {
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// sql 검색 조건
			stmt = conn.createStatement();
			String sql = "select id, pw from userdata";
			
			rs = stmt.executeQuery(sql);
			
			// 아이디 비번 사이에 연결 문구를 넣어서 검사
			// -> 예상치 못한 에러 방지
			// case1 : 아이디 = id123, 비밀번호 = 456
			// case2 : 아이디 = id1234, 비밀번호 = 56 인경우 같다고 처리되는 것을 방지
			String idpw = id + "#join#" + pw;
			
			while(rs.next()) {
				String result = rs.getString("id") + "#join#" + rs.getString("PW");
				
				if(result.equals(idpw)) {
					// 로그인 성공
					return 0;
				}else {
					// 로그인 실패
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) try {conn.close();} catch(SQLException e) {}
			if(stmt != null) try {stmt.close();} catch(SQLException e) {}
			if(rs != null) try {rs.close();} catch(SQLException e) {}
		}
		// 둘다 false인 경우
		return 1;
	}

	// 할일 목록 출력
	public ArrayList<TodolistTO> printTodolist(String id) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// datas 초기화
		ArrayList<TodolistTO> datas = new ArrayList();
		try {
			// sql 검색 조건 : 완료되지 않고(comthis='false'), 삭제되지 않은(delthis='false') 목록 출력
			String sql = "select todo, time, comtime from todolist where id =? and comthis='false' and delthis='false'";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			// 2차원 배열 형식으로 반환
			while(rs.next()) {
				TodolistTO to = new TodolistTO();
				to.setTodo( rs.getString("todo") );
				to.setTime( rs.getString("time") );
				to.setComtime( rs.getString("comtime") );
				
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

	// 완료목록 출력 DAO
	public ArrayList<TodolistTO> printCompleteTodolist(String id) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// datas 초기화
		ArrayList<TodolistTO> datas = new ArrayList();
		try {
			// sql 검색 조건 : 완료되었지만(comthis='true') 삭제되지 않은(delthis='false') 경우
			String sql = "select todo, time, comtime from todolist where id =? and comthis='true' and delthis='false'";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			// 2차원 배열 형식으로 반환
			while(rs.next()) {
				TodolistTO to = new TodolistTO();
				to.setTodo( rs.getString("todo") );
				to.setTime( rs.getString("time") );
				to.setComtime( rs.getString("comtime") );
				
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

	// 삭제목록 출력 DAO
	public ArrayList<TodolistTO> printDeleteTodolist(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		// 초기화
		ArrayList<TodolistTO> datas = new ArrayList();
	
		try {
			// sql 검색 조건 : 지워진 목록(delthis='true')인경우를 출력
			String sql = "select todo, time, comtime from todolist where id =? and delthis='true'";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
		
			rs = pstmt.executeQuery();
		
			// 2차원 배열 형식으로 반환
			while(rs.next()) {
				TodolistTO to = new TodolistTO();
				to.setTodo( rs.getString("todo") );
				to.setTime( rs.getString("time") );
				to.setComtime( rs.getString("comtime") );
			
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

	// 할일 추가를 위한 DAO
	public void addTodoList(String id, String addTodo, String addTime) {
		PreparedStatement pstmt = null;
	
		// 초기화
		ArrayList<TodolistTO> datas = new ArrayList();
	
		try {
			// sql 검색 조건 : 할일에 추가할 때는 완료되지 않고(comthis='false'), 삭제되지 않은(delthis='false')상태 이어야한다.
			String sql = "insert todolist values (?, ?, ?, null, 'false', 'false')";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, addTodo);
			pstmt.setString(3, addTime);
		
			int result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) try {conn.close();} catch(SQLException e) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
		}
	}

	// 수정을 위한 DAO
	public void modifyTodo(String id, String selectTodoList, String selectTodoTime, String modifyTodo,
			String modifyTime) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			// sql 검색 조건 : 선택한 [할일]과 입력했었던 [시간], [id] 값이 같아야 한다.
			String sql = "update todolist set todo=?, time=? where id=? and todo=? and time=? and comthis='false' and delthis='false'";
			
			pstmt = conn.prepareStatement(sql);
			
			// 일치해야하는 데이터 : id, selectTodoList, selectTodoTime
			// 수정되는 데이터 : modifyTodo, modifyTime
			pstmt.setString(1, modifyTodo);
			pstmt.setString(2, modifyTime);
			pstmt.setString(3, id);
			pstmt.setString(4, selectTodoList);
			pstmt.setString(5, selectTodoTime);
			
			rs = pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) try {conn.close();} catch(SQLException e) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(rs != null) try {rs.close();} catch(SQLException e) {}
		}
	}

	// 삭제를 위한 DAO
	public void deleteTodo(String id, String selectTodoList, String selectTodoTime) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			// sql 검색 조건 : 선택된 [할일], 입력했던 [시간]이 일치하는 데이터의 delthis를 true로 변경
			String sql = "update todolist set delthis='true' where id=? and todo=? and time=?";
			
			pstmt = conn.prepareStatement(sql);
			
			// 일치해야하는 데이터 : id, selectTodoList, selectTodoTime
			// 수정되는 데이터 : delthis = false -> true
			pstmt.setString(1, id);
			pstmt.setString(2, selectTodoList);
			pstmt.setString(3, selectTodoTime);
			
			rs = pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) try {conn.close();} catch(SQLException e) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(rs != null) try {rs.close();} catch(SQLException e) {}
		}
	}

	// 완료를 위한 DAO
	public void completeTodo(String id, String selectTodoList, String selectTodoTime, String comTime) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			// sql 검색 조건 : 선택된 [할일], 입력했던 [시간]과 일치하는 항목의 comthis를 true로 변경후 [완료시간]추가
			String sql = "update todolist set comthis='true', comtime=? where id=? and todo=? and time=?";
			
			pstmt = conn.prepareStatement(sql);
			
			// 일치해야하는 데이터 : id, selectTodoList, selectTodoTime
			// 수정되는 데이터 : comthis = false -> true
			pstmt.setString(1, comTime);
			pstmt.setString(2, id);
			pstmt.setString(3, selectTodoList);
			pstmt.setString(4, selectTodoTime);
			
			rs = pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) try {conn.close();} catch(SQLException e) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(rs != null) try {rs.close();} catch(SQLException e) {}
		}
	}

	public void restoreTodo(String id, String selectTodoList, String selectTodoTime, String selectTodoComTime, int listSelect) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			// sql 검색 조건 : 
			// 할일 목록에서 삭제된 항목이면, 할일 목록으로 이동
			// 완료 목록에서 삭제된 항목이면, 완료 목록으로 이동
			
			String sql = "";
			
			// 삭제목록 -> 할일 목록
			if(selectTodoComTime == null) {
				sql = "update todolist set comthis='false', delthis='false', comtime=null where id=? and todo=? and time=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, selectTodoList);
				pstmt.setString(3, selectTodoTime);
				rs = pstmt.executeQuery();
			} else {
				switch (listSelect) {
				// 완료목록 -> 할일목록
				case 1:
					sql = "update todolist set comthis='false', delthis='false', comtime=null where id=? and todo=? and time=? and comtime=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setString(2, selectTodoList);
					pstmt.setString(3, selectTodoTime);
					pstmt.setString(4, selectTodoComTime);
					rs = pstmt.executeQuery();
					break;
				
				// 삭제목록 -> 완료목록
				case 2:
					sql = "update todolist set comthis='true', delthis='false' where id=? and todo=? and time=? and comtime=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setString(2, selectTodoList);
					pstmt.setString(3, selectTodoTime);
					pstmt.setString(4, selectTodoComTime);
					rs = pstmt.executeQuery();
					break;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) try {conn.close();} catch(SQLException e) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(rs != null) try {rs.close();} catch(SQLException e) {}
		}
	}

	// 완전 삭제를 위한 DAO
	public void delComTodo(String id, String selectTodoList, String selectTodoTime) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			// sql 검색 조건 : 삭제 목록에서 선택한 행의 [할일], 입력했던 [시간]이 일치하는 행을 delete
			String sql = "delete from todolist where delthis='true' and id=? and todo=? and time=?";
			
			pstmt = conn.prepareStatement(sql);
			
			// 일치해야하는 데이터 : id, selectTodoList, selectTodoTime, delthis
			// 수정되는 데이터 : 해당 데이터 삭제
			pstmt.setString(1, id);
			pstmt.setString(2, selectTodoList);
			pstmt.setString(3, selectTodoTime);
			
			rs = pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) try {conn.close();} catch(SQLException e) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(rs != null) try {rs.close();} catch(SQLException e) {}
		}
	}

	// 완료목록 전체 삭제를 위한 DAO
	public void delAllcomTodo(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			// sql 검색 조건 : 완료 목록의 모든 데이터의 delthis를 'true'로 변경, comthis를 false로 변경
			String sql = "update todolist set comthis='false', delthis='true' where id=? and comthis='true' and delthis='false'";
			
			pstmt = conn.prepareStatement(sql);
			
			// 일치해야하는 데이터 : id
			// 수정되는 데이터
			// comthis = 'true' -> 'false'
			// delthis = 'false' -> 'true'
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) try {conn.close();} catch(SQLException e) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(rs != null) try {rs.close();} catch(SQLException e) {}
		}
	}

	// 삭제 목록 전체 데이터 삭제를 위한 DAO
	public void delAlldelTodo(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			// sql 검색 조건 : 삭제 목록의 모든 (delthis='true')인 데이터를 delete
			String sql = "delete from todolist where delthis='true' and id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) try {conn.close();} catch(SQLException e) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(rs != null) try {rs.close();} catch(SQLException e) {}
		}
	}

	// 아이디 찾기를 위한 DAO
	public String findId(String name, String jumin) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String resultId ="";
		
		try {
			// sql 검색 조건 : 가입한 이름과 주민번호가 일치하는 결과 출력
			String sql = "select id from userdata where name=? and jumin=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, jumin);
			
			rs = pstmt.executeQuery();
			
			// 여러 아이디를 가입했을시 구분을 위해 "/" 추가
			while(rs.next()) {
				resultId += rs.getString("id") + "/";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) try {conn.close();} catch(SQLException e) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(rs != null) try {rs.close();} catch(SQLException e) {}
		}
		return resultId;
	}

	// 비밀번호 찾기를 위한 DAO
	public String findPw(String id, String name, String jumin) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String resultPw ="";
		
		try {
			// sql 검색 조건 : 가입한 아이디, 이름, 주민번호가 일치하는 결과 출력
			String sql = "select pw from userdata where id=? and name=? and jumin=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, jumin);
			
			rs = pstmt.executeQuery();
			
			// 입력한 값과 출력결과가 같은 경우 생성 불가
			while(rs.next()) {
				resultPw += rs.getString("pw");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) try {conn.close();} catch(SQLException e) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(rs != null) try {rs.close();} catch(SQLException e) {}
		}
		// 결과가 없으면 공백 return
		return resultPw;
	}
}