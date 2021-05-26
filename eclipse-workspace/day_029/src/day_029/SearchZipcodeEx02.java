package day_029;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ItemEvent;

public class SearchZipcodeEx02 extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JComboBox comboBox1;
	private JComboBox comboBox2;
	private JComboBox comboBox3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchZipcodeEx02 frame = new SearchZipcodeEx02();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchZipcodeEx02() {
		setTitle("우편번호 검색기\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uC6B0\uD3B8\uBC88\uD638 \uAC80\uC0C9\uAE30", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 5, 459, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		
		/*
		 	*  콤보박스1 
		 */
		comboBox1 = new JComboBox();
		comboBox1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {

					if( comboBox1.getSelectedIndex() != 0 ) {
						String strSido = (String)comboBox1.getSelectedItem( );
						comboBox2.setModel( new DefaultComboBoxModel ( listGugun( strSido ).toArray() ) );
					}
				}
			}
		});
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {"시도"}));
		comboBox1.setBounds(26, 24, 118, 23);
		panel.add(comboBox1);
		
		/*
	 		*  콤보박스2
	 	*/
		comboBox2 = new JComboBox();
		comboBox2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {

					if( comboBox2.getSelectedIndex() != 0 ) {
						String strSido = (String)comboBox1.getSelectedItem();
						String strGugun = (String)comboBox2.getSelectedItem();
						comboBox3.setModel( new DefaultComboBoxModel ( listDong( strSido, strGugun ).toArray() ) );
					}
				}
			}
		});
		comboBox2.setModel(new DefaultComboBoxModel(new String[] {"구군"}));
		comboBox2.setBounds(170, 24, 118, 23);
		panel.add(comboBox2);
		
		/*
 			*  콤보박스3
 		*/
		comboBox3 = new JComboBox();
		comboBox3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if( comboBox3.getSelectedIndex() != 0 ) {
					String strSido = (String)comboBox1.getSelectedItem();
					String strGugun = (String)comboBox2.getSelectedItem();
					String strDong = (String)comboBox3.getSelectedItem();
					
					textArea.setText( listAddress(strSido, strGugun, strDong).toString() );
				}
			}
		});
		comboBox3.setModel(new DefaultComboBoxModel(new String[] {"동"}));
		comboBox3.setBounds(314, 24, 118, 23);
		panel.add(comboBox3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 68, 459, 529);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		// comboBox1 초기화
		ArrayList<String> sidos = listSido();
		comboBox1.setModel( new DefaultComboBoxModel( sidos.toArray( ) ) );
	}
	
	// 콤보박스1에 시도 리스트를 만들기 위한 함수
	public ArrayList<String> listSido(){
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<String> sidos = new ArrayList<String>();
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			String sql = "select distinct sido from zipcode";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			sidos.add("시도");
			while(rs.next()) {
				sidos.add(rs.getString("sido"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {};
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {};
			if(conn != null) try {conn.close();} catch(SQLException e) {};
		}
		return sidos;
	}
	// 콤보박스2에 구군 리스트를 만들기 위한 함수
	public ArrayList<String> listGugun(String strSido){
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<String> guguns = new ArrayList<String>();
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			String sql = "select distinct gugun from zipcode where sido=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strSido);
			
			rs = pstmt.executeQuery();
			guguns.add("구군");
			while(rs.next()) {
				guguns.add(rs.getString("gugun"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {};
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {};
			if(conn != null) try {conn.close();} catch(SQLException e) {};
		}
		return guguns;
	}
	// 콤보박스3에 동 리스트를 만들기 위한 함수
	public ArrayList<String> listDong(String strSido, String strGugun){
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<String> dongs = new ArrayList<String>();
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			String sql = "select distinct dong from zipcode where sido=? and gugun=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strSido);
			pstmt.setString(2, strGugun);
			
			rs = pstmt.executeQuery();
			dongs.add("동");
			while(rs.next()) {
				dongs.add(rs.getString("dong"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {};
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {};
			if(conn != null) try {conn.close();} catch(SQLException e) {};
		}
		return dongs;
	}
	// 모든 콤보박스의 정보를 받아 TextArea에 출력하기 위한 함수
	public StringBuffer listAddress(String strSido, String strGugun, String strDong){
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 스트링 버퍼를 이용하여 후에 .toString()으로 출력하기 위함
		StringBuffer addresses = new StringBuffer();
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			String sql = "select zipcode, sido, gugun, dong, ri, bunji from zipcode where sido=? and gugun=? and dong =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strSido);
			pstmt.setString(2, strGugun);
			pstmt.setString(3, strDong);
			
			rs = pstmt.executeQuery();
			
			// 출력결과를 addresses에 전부 담는다.
			while(rs.next()) {
				String address = String.format( "[%s] %s %s %s %s %s \n", 
						rs.getString("zipcode"), rs.getString("sido"), rs.getString("gugun"),
						rs.getString("dong"), rs.getString("ri"), rs.getString("bunji"));
				addresses.append( address );
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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