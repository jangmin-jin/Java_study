package ex01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFrameEx04 extends JFrame {

	private JPanel contentPane;
	private JButton btn5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameEx04 frame = new JFrameEx04();
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
	public JFrameEx04() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn1 = new JButton("활성화");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btn5.setEnabled(true);
				System.out.println( "활성화 !" );
			}
		});
		btn1.setBounds(12, 10, 97, 23);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("비활성화");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btn5.setEnabled(false);
				System.out.println( "Be활성화 !" );
			}
		});
		btn2.setBounds(121, 10, 97, 23);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("보이기");
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btn5.setVisible(true);
				System.out.println( "비지블 !" );
			}
		});
		btn3.setBounds(230, 10, 97, 23);
		contentPane.add(btn3);
		
		JButton btn4 = new JButton("안보이닝");
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btn5.setVisible(false);
				System.out.println( "언비지블 !" );
			}
		});
		btn4.setBounds(339, 10, 97, 23);
		contentPane.add(btn4);
		
		btn5 = new JButton("결과버튼");
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btn5.isEnabled()) {
					System.out.println( "결과 : " + btn5.isEnabled() );
				}
			}
		});
		btn5.setBounds(12, 43, 424, 38);
		contentPane.add(btn5);
	}

}
