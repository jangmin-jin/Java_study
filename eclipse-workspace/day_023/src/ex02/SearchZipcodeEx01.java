package ex02;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class SearchZipcodeEx01 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JScrollPane scrollPane;

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
		setTitle("우편번호 검색기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uC6B0\uD3B8\uBC88\uD638 \uAC80\uC0C9\uAE30", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(6, 19, 666, 71);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("동이름을 입력하세요");
		lblNewLabel.setBounds(160, 29, 132, 15);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(304, 26, 229, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btn1 = new JButton("검색");
		btn1.setBounds(545, 25, 97, 23);
		panel.add(btn1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 100, 660, 501);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// 조건 : 2글자 미만으로 입력되면 알림창 생성
				if ( textField.getText().split("").length < 2) {
					JOptionPane.showMessageDialog(SearchZipcodeEx01.this, "두 글자 이상 입력하세여", "우편번호 검사 오류", JOptionPane.INFORMATION_MESSAGE);
				}else {
					String address = textField.getText();
					table.setModel( new CustomTableModelZipcode(address) );
				}
			}
		});
	}
}