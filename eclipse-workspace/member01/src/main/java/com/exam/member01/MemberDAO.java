package com.exam.member01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	private Connection conn;
	
	public MemberDAO() {
		// 데이터베이스 연결을 위한 변수 선언
		String url = "jdbc:mysql://localhost:3306/project";
		String user = "project";
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
	
	public ArrayList<MemberTO> listMember(){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<MemberTO> datas = new ArrayList<MemberTO>();
		
		try {
			String sql = "select seq, groupNo, name, phone, email from member";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberTO to = new MemberTO();
				to.setSeq(rs.getInt("seq"));
				to.setGroupNo(rs.getInt("groupNo"));
				to.setName(rs.getString("name"));
				to.setPhone(rs.getString("phone"));
				to.setEmail(rs.getString("email"));
				
				datas.add(to);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
		}
		
		return datas;
	}
	
	public boolean insertMember(MemberTO to) {
		PreparedStatement pstmt = null;
		
		int flag = 1;
		try {
			String sql = "INSERT INTO member VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, to.getGroupNo());
			pstmt.setString(2, to.getName());
			pstmt.setString(3, to.getPhone());
			pstmt.setString(4, to.getEmail());
			pstmt.setString(5, to.getZipcode());
			pstmt.setString(6, to.getAddress1());
			pstmt.setString(7, to.getAddress2());
			pstmt.setString(8, to.getEtc1());
			pstmt.setString(9, to.getEtc2());
			pstmt.setString(10, to.getMemo());
			
			if(pstmt.executeUpdate() == 1) {
				flag = 0;
			};
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
		
		if( flag == 0 ) {
			return true;
		}else {
			return false;
		}

	}
	
	public boolean modifyMember(MemberTO to) {
		PreparedStatement pstmt = null;
		
		int flag = 1;
		try {
			String sql = "update member set groupno=?, name=?, phone=?, email=?, "
					+ "zipcode=?, address1=?, address2=?, etc1=?, etc2=?, memo=? where seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, to.getGroupNo());
			pstmt.setString(2, to.getName());
			pstmt.setString(3, to.getPhone());
			pstmt.setString(4, to.getEmail());
			pstmt.setString(5, to.getZipcode());
			pstmt.setString(6, to.getAddress1());
			pstmt.setString(7, to.getAddress2());
			pstmt.setString(8, to.getEtc1());
			pstmt.setString(9, to.getEtc2());
			pstmt.setString(10, to.getMemo());
			pstmt.setInt(11, to.getSeq());
			
			if(pstmt.executeUpdate() == 1) {
				flag = 0;
			};
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
		
		if( flag == 0 ) {
			return true;
		}else {
			return false;
		}
	}	
	
	public boolean deleteMember(MemberTO to) {
PreparedStatement pstmt = null;
		
		int flag = 1;
		try {
			String sql = "delete from member where seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, to.getSeq());
			
			if(pstmt.executeUpdate() == 1) {
				flag = 0;
			};
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
		
		if( flag == 0 ) {
			return true;
		}else {
			return false;
		}
	}

	public MemberTO viewMember(MemberTO to) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select groupNo, name, phone, email, zipcode, address1, "
					+ "address2, etc1, etc2, memo from member where seq=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, to.getSeq());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				to.setGroupNo(rs.getInt("groupNo"));
				to.setName(rs.getString("name"));
				to.setPhone(rs.getString("phone"));
				to.setEmail(rs.getString("email"));
				to.setZipcode(rs.getString("zipcode"));
				to.setAddress1(rs.getString("address1"));
				to.setAddress2(rs.getString("address2"));
				to.setEtc1(rs.getString("etc1"));
				to.setEtc2(rs.getString("etc2"));
				to.setMemo(rs.getString("memo"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
		return to;
	}
}
