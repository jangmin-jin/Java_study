package day_030;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ZipcodeSearchMainEx01 extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZipcodeSearchMainEx01 frame = new ZipcodeSearchMainEx01();
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
	public ZipcodeSearchMainEx01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField1 = new JTextField();
		textField1.setEditable(false);
		textField1.setBounds(12, 10, 57, 21);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("-");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(80, 13, 33, 15);
		contentPane.add(lblNewLabel);
		
		textField2 = new JTextField();
		textField2.setEditable(false);
		textField2.setBounds(125, 10, 57, 21);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		JButton btnNewButton = new JButton("우편번호찾기");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// dlg 실행
				ZipcodeSearchDlgEx01 dialog = new ZipcodeSearchDlgEx01();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setModal(true);
				dialog.setVisible(true);
				
				// 주소창을 검색결과로 초기화
				textField1.setText(dialog.getZipcode1());
				textField2.setText(dialog.getZipcode2());
				textField3.setText(dialog.getEtcAddress());
			}
		});
		btnNewButton.setBounds(194, 9, 116, 23);
		contentPane.add(btnNewButton);
		
		textField3 = new JTextField();
		textField3.setEditable(false);
		textField3.setText("기본주소");
		textField3.setBounds(12, 41, 420, 21);
		contentPane.add(textField3);
		textField3.setColumns(10);
		
		textField4 = new JTextField();
		textField4.setText("상세주소");
		textField4.setColumns(10);
		textField4.setBounds(12, 72, 420, 21);
		contentPane.add(textField4);
	}
}
