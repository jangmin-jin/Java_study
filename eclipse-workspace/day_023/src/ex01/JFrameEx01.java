package ex01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFrameEx01 extends JFrame {

	private JPanel contentPane;
	private JProgressBar progressBar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameEx01 frame = new JFrameEx01();
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
	public JFrameEx01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 96);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setValue(50);
		progressBar.setBounds(12, 10, 350, 41);
		contentPane.add(progressBar);
		
		JButton btn1 = new JButton("↓");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(progressBar.getValue() <= 0) {
					JOptionPane.showMessageDialog(JFrameEx01.this, "더이상 감소할 값이 없습니다.", "로딩바", JOptionPane.WARNING_MESSAGE);
				}else {
					progressBar.setValue(progressBar.getValue() - 10);
				}
			}
		});
		btn1.setBounds(374, 10, 41, 41);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("↑");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(progressBar.getValue() >= 100) {
					JOptionPane.showMessageDialog(JFrameEx01.this, "더이상 증가할 값이 없습니다.", "로딩바", JOptionPane.WARNING_MESSAGE);
				}else {
					progressBar.setValue(progressBar.getValue() + 20);
				}
			}
		});
		btn2.setBounds(430, 10, 41, 41);
		contentPane.add(btn2);
	}
}
