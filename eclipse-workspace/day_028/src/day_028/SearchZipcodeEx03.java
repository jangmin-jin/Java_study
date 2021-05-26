package day_028;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ItemEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;

public class SearchZipcodeEx03 extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JComboBox cbox1;
	private JComboBox cbox2;
	private JComboBox cbox3;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchZipcodeEx03 frame = new SearchZipcodeEx03();
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
	public SearchZipcodeEx03() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uB3D9\uC774\uB984 \uAC80\uC0C9", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(6, 12, 471, 52);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// 콤보박스1 (시도) 로직
		cbox1 = new JComboBox();
		cbox1.setModel(new DefaultComboBoxModel(new String[] {"시", "서울", "인천", "경기"}));
		cbox1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					// 콤보박스2 (구군) 초기화
					cbox2.removeAllItems();
					// 제일 상위 item은 '구군'으로 하고싶다.
					cbox2.addItem("구군");
					
					// 검색을 실행할 sql문과 조건을 정하여 searchZipcode함수 실행
					String gugun = "gugun";
					String sql = "select distinct gugun from zipcode where sido='" + cbox1.getSelectedItem() +"'";
					String result = searchZipcode(sql, gugun);
					
					// 반환된 결과를 배열에 저장후 콤보박스2 (구군) 에 추가
					String[] resultArr = result.split(",");
					for(int i=0; i<resultArr.length; i++) {
						cbox2.addItem(resultArr[i]);
					}
				}
			}
		});
		cbox1.setBounds(6, 17, 138, 23);
		panel.add(cbox1);
		
		// 콤보박스2 (구군) 로직
		cbox2 = new JComboBox();
		cbox2.setModel(new DefaultComboBoxModel(new String[] {"구군"}));
		cbox2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					// 콤보박스3 (동) 초기화
					cbox3.removeAllItems();
					// 제일 상위 item은 '동'으로 하고싶다.
					cbox3.addItem("동");
					
					// 검색을 실행할 sql문과 조건을 정하여 searchZipcode함수 실행
					String dong = "dong";
					String sql = "select distinct dong from zipcode where sido='" + cbox1.getSelectedItem() +"' and gugun ='"+ cbox2.getSelectedItem() + "'";
					String result = searchZipcode(sql, dong);
					
					// 반환된 결과를 배열에 저장후 콤보박스3 (동) 에 추가
					String[] resultArr = result.split(",");
					for(int i=0; i<resultArr.length; i++) {
						cbox3.addItem(resultArr[i]);
					}
				}
			}
		});
		cbox2.setBounds(166, 17, 138, 23);
		panel.add(cbox2);
		
		// 콤보박스3 (동) 로직 - 출력부
		cbox3 = new JComboBox();
		cbox3.setModel(new DefaultComboBoxModel(new String[] {"동"}));
		cbox3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
				// 검색을 실행할 sql문과 조건을 정하여 searchZipcode함수 실행
				String adress = "allAdress";
				String sql = "select * from zipcode where sido='" + cbox1.getSelectedItem() +"' and gugun ='"+ cbox2.getSelectedItem() +"' and dong ='" + cbox3.getSelectedItem() + "'";
				String result = searchZipcode(sql, adress);
				
				// textArea에 결과 출력
				textArea.setText(result);
				}
			}
		});
		cbox3.setBounds(327, 17, 138, 23);
		panel.add(cbox3);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 71, 462, 480);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
	
	// searchZipcode 함수
	public String searchZipcode(String insertSql, String where) {
		// 연결 url 생성
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "root";
		String password = "123456";
				
		// 연결을 위한 인터페이스 호출
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuffer sbResult = new StringBuffer();
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			// 각 콤보박스에서 넘어온 sql문장을 재정의
			String sql = insertSql;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// 콤보박스3 (동) 의 경우 선택시 TextArea에 모든 주소를 출력해주어야 하기 때문에
			// where 값이 allAdress일 경우에만 따로 처리한다.
			if(where == "allAdress") {
				while( rs.next() ) {
					sbResult.append( String.format( "[%s] %s %s %s %s %s %s \n", 
					rs.getString("zipcode"), rs.getString("sido"), rs.getString("gugun"),
					rs.getString("dong"), rs.getString("ri"), rs.getString("bunji"), rs.getString("seq")));
				}
			// 콤보박스1, 2 해당
			}else {
				while( rs.next() ) {
					// 다시 분할해주기 위한 ","삽입.
					sbResult.append( rs.getString(where) +"," );
				}
			}
		
		// 예외처리
		} catch (ClassNotFoundException e) {
			System.out.println( "[에러] : " + e.getMessage() );
		} catch (SQLException e) {
			System.out.println( "[에러] : " + e.getMessage() );
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {};
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {};
			if(conn != null) try {conn.close();} catch(SQLException e) {};
		}
		
		// 함수 실행 결과 반환
		return sbResult.toString();
	}
}