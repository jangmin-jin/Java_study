package ex01;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFrameEx05 extends JFrame {

	private JPanel contentPane;
	private JTextField txtText;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameEx05 frame = new JFrameEx05();
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
	public JFrameEx05() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtText = new JTextField();
		txtText.setText("난 Text 기본값");
		txtText.setBounds(12, 10, 500, 21);
		contentPane.add(txtText);
		txtText.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(12, 41, 500, 21);
		contentPane.add(passwordField);
		
		JButton btn = new JButton("입력");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println( txtText.getText() );
				// System.out.println( passwordField.getText() );
				// 캐릭터 배열로 가져와서 스트링화 시킴
				System.out.println( new String( passwordField.getPassword() ) );
			}
		});
		btn.setBounds(524, 9, 97, 53);
		contentPane.add(btn);
	}
}
