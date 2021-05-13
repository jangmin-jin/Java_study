package ex01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JScrollPane;

public class PostSearchJFrameEx01 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostSearchJFrameEx01 frame = new PostSearchJFrameEx01();
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
	public PostSearchJFrameEx01() {
		setTitle("우편번호 검색기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setBounds(12, 10, 336, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btn = new JButton("우편번호 검색");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// textArea 초기화
				textArea.setText("");
				
				// 주소 검색
				PostSearch postSearch = new PostSearch();
				String address = textField.getText();
				if (address.length()>1) {
					String result = postSearch.postSearch(address);
					textArea.append(result);
				}else {
					JOptionPane.showMessageDialog(PostSearchJFrameEx01.this, "두 글자 이상 입력하십시오.", "우편번호 검사 오류", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		btn.setBounds(360, 10, 118, 34);
		contentPane.add(btn);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 52, 466, 323);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setText("결과 창");
		scrollPane.setViewportView(textArea);
	}
}