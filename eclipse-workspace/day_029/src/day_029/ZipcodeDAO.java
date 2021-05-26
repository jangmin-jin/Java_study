package day_029;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ZipcodeDAO {
	// CRUD 작업을 실시
	private Connection conn;
	
	public ZipcodeDAO() {
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<ZipcodeTo> listSido(){
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<ZipcodeTo> sidos = new ArrayList<ZipcodeTo>();
		
		try {	
			String sql = "select distinct sido from zipcode";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ZipcodeTo to = new ZipcodeTo();
			
			to.setSido("시도");
			sidos.add(to);
			while(rs.next()) {
				to = new ZipcodeTo();
				to.setSido(rs.getString("sido"));
				sidos.add(to);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {};
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {};
			if(conn != null) try {conn.close();} catch(SQLException e) {};
		}
		return sidos;
	}
	
public ArrayList<ZipcodeTo> listGugun(String strSido){
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<ZipcodeTo> guguns = new ArrayList<ZipcodeTo>();
		
		try {	
			String sql = "select distinct gugun from zipcode where sido=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strSido);
			rs = pstmt.executeQuery();
			
			ZipcodeTo to = new ZipcodeTo();
			
			to.setGugun("구군");
			guguns.add(to);
			while(rs.next()) {
				to = new ZipcodeTo();
				to.setGugun(rs.getString("gugun"));
				guguns.add(to);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {};
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {};
			if(conn != null) try {conn.close();} catch(SQLException e) {};
		}
		return guguns;
	}

public ArrayList<ZipcodeTo> listDong(String strSido, String strGugun){
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	ArrayList<ZipcodeTo> dongs = new ArrayList<ZipcodeTo>();
	
	try {	
		String sql = "select distinct dong from zipcode where sido=? and gugun=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, strSido);
		pstmt.setString(2, strGugun);
		
		rs = pstmt.executeQuery();
		
		ZipcodeTo to = new ZipcodeTo();
		
		to.setDong("동");
		dongs.add(to);
		while(rs.next()) {
			to = new ZipcodeTo();
			to.setDong(rs.getString("dong"));
			dongs.add(to);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		if(rs != null) try {rs.close();} catch(SQLException e) {};
		if(pstmt != null) try {pstmt.close();} catch(SQLException e) {};
		if(conn != null) try {conn.close();} catch(SQLException e) {};
	}
	return dongs;
}

public ArrayList<ZipcodeTo> listAddress (String strSido, String strGugun, String strDong){
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	ArrayList<ZipcodeTo> addresses = new ArrayList<ZipcodeTo>();
	
	try {	
		String sql = "select zipcode, sido, gugun, dong, ri, bunji from zipcode where sido=? and gugun=? and dong=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, strSido);
		pstmt.setString(2, strGugun);
		pstmt.setString(3, strDong);
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			ZipcodeTo to = new ZipcodeTo();
			to.setZipcode(rs.getString("zipcode"));
			to.setSido(rs.getString("sido"));
			to.setGugun(rs.getString("gugun"));
			to.setDong(rs.getString("dong"));
			to.setRi(rs.getString("ri"));
			to.setBunji(rs.getString("bunji"));
			
			addresses.add(to);

		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		if(rs != null) try {rs.close();} catch(SQLException e) {};
		if(pstmt != null) try {pstmt.close();} catch(SQLException e) {};
		if(conn != null) try {conn.close();} catch(SQLException e) {};
	}
	return addresses;
}
	
}