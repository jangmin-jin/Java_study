package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginDlgCopy extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginDlgCopy frame = new LoginDlgCopy();
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
	public LoginDlgCopy() {
		setTitle("로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 175);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(12, 25, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setBounds(12, 61, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(70, 19, 150, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(70, 55, 150, 21);
		contentPane.add(textField_1);
		
		btnNewButton = new JButton("회원가입");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUpDlgCopy signUpDlg = new SignUpDlgCopy();
				signUpDlg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				signUpDlg.setModalExclusionType(getModalExclusionType());
				signUpDlg.setVisible(true);
			}
		});
		btnNewButton.setBounds(12, 98, 90, 25);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("로그인");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 창닫기
				LoginDlgCopy.this.dispose();
			}
		});
		btnNewButton_1.setBounds(140, 98, 80, 25);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("취소");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 창닫기
				LoginDlgCopy.this.dispose();
			}
		});
		btnNewButton_2.setBounds(222, 98, 70, 25);
		contentPane.add(btnNewButton_2);
	}

}
