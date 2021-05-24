package day_028;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class SearchZipcodeEx01 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchZipcodeEx01 frame = new SearchZipcodeEx01();
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
	public SearchZipcodeEx01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uC6B0\uD3B8\uBC88\uD638 \uAC80\uC0C9\uAE30", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(16, 18, 606, 94);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(25, 38, 446, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btn = new JButton("검색");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea.setText("");
				
				if( textField.getText().split("").length <2) {
					JOptionPane.showMessageDialog(SearchZipcodeEx01.this, "두 글자 이상 입력하세여", "우편번호 검사 오류", JOptionPane.INFORMATION_MESSAGE);
				} else {
					// 입력 받은 텍스트 양옆 공백 제거
					String address = textField.getText().trim();
					// 연결 url 생성
					String url = "jdbc:mysql://localhost:3306/sample";
					String user = "root";
					String password = "123456";
					
					// 연결을 위한 인터페이스 호출
					Connection conn = null;
					Statement stmt = null;
					ResultSet rs = null;
					
					try {
						Class.forName("org.mariadb.jdbc.Driver");
						conn = DriverManager.getConnection(url, user, password);
						stmt = conn.createStatement();
						
						String sql = "select * from zipcode where dong like '" + address + "%'" ;
						
						rs = stmt.executeQuery(sql);
						int result = stmt.executeUpdate(sql);
						
						int checkresult = 0;
						while( rs.next() ) {
							textArea.append(rs.getString("zipcode") +"  ");
							textArea.append(rs.getString("sido") +"  ");
							textArea.append(rs.getString("gugun") +"  ");
							textArea.append(rs.getString("dong") +"  ");
							textArea.append(rs.getString("ri") +"  ");
							textArea.append(rs.getString("bunji") +"  ");
							textArea.append(rs.getString("seq") +"  \n");
							checkresult++;
						}
						
						if(checkresult == 0) {
							JOptionPane.showMessageDialog(SearchZipcodeEx01.this, "검색 결과가 없습니다.", "우편번호 검사 결과 없음", JOptionPane.INFORMATION_MESSAGE);
						}
						
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					} finally {
						if(rs != null) try {rs.close();} catch(SQLException e1) {};
						if(stmt != null) try {stmt.close();} catch(SQLException e1) {};
						if(conn != null) try {conn.close();} catch(SQLException e1) {};
					}
				}
			}
		});
		btn.setBounds(483, 37, 97, 23);
		panel.add(btn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 128, 610, 423);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
	}
}
