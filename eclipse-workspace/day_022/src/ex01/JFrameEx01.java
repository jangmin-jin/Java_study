package ex01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class JFrameEx01 extends JFrame {

	private JPanel contentPane;
	private JLabel lbl1;
	private JLabel lbl1_1;
	private JLabel lbl1_2;

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
		setTitle("난 프레임!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbl1 = new JLabel("<html><body><font color ='red' >Hello label</font><br><font color ='red' >Hello label</font></body></html>");
		lbl1.setBounds(66, 10, 153, 55);
		contentPane.add(lbl1);
		
		lbl1_1 = new JLabel("새로운 라벨이어요");
		lbl1_1.setBounds(66, 75, 153, 15);
		contentPane.add(lbl1_1);
		
		lbl1_2 = new JLabel("");
		lbl1_2.setIcon(new ImageIcon("C:\\java\\doge.PNG"));
		lbl1_2.setBounds(66, 209, 203, 242);
		contentPane.add(lbl1_2);
	}
}
