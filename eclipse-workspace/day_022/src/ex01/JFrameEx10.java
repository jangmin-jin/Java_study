package ex01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFrameEx10 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameEx10 frame = new JFrameEx10();
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
	public JFrameEx10() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn1 = new JButton("알람 버튼");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// JOptionPane.showMessageDialog(외부 클래스명.this, "메세지 내용"); 
				// JOptionPane.showMessageDialog(외부 클래스명.this, "메세지 내용", "타이틀", JOptionPane.WARNING_MESSAGE);
				JOptionPane.showMessageDialog(JFrameEx10.this, "알람", "타이틀", JOptionPane.WARNING_MESSAGE);
			}
		});
		btn1.setBounds(12, 10, 97, 23);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("확인 버튼");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(JFrameEx10.this, "확인", "타이틀", JOptionPane.OK_CANCEL_OPTION);
				System.out.println(result); // 0 : ok/ 1 : no/ 2 : cancel/ x : -1
			}
		});
		btn2.setBounds(12, 43, 97, 23);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("확인 버튼");
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				JOptionPane.showInputDialog("메시지 내용");
				String result = JOptionPane.showInputDialog("메시지 내용");
				
				if(result != null) {
					System.out.println("결과 : " + result);
				}else {
					System.out.println( "취소!" );
				}
			}
		});
		btn3.setBounds(12, 76, 97, 23);
		contentPane.add(btn3);
		
		JButton btn4 = new JButton("확인 버튼");
		btn4.setBounds(12, 109, 97, 23);
		contentPane.add(btn4);
	}

}
