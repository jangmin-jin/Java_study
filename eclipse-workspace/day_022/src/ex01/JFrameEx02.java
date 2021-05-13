package ex01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;

public class JFrameEx02 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameEx02 frame = new JFrameEx02();
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
	public JFrameEx02() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn1 = new JButton("난 뻐뜬~");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("클릭햇워요!");
			}
		});
		btn1.setForeground(new Color(128, 0, 0));
		btn1.setBackground(new Color(135, 206, 235));
		btn1.setBounds(12, 10, 125, 23);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("난 빠른2~");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println( "클릭했네요" );
			}
		});
		btn2.setForeground(new Color(123, 104, 238));
		btn2.setBackground(new Color(50, 205, 50));
		btn2.setBounds(12, 43, 125, 23);
		contentPane.add(btn2);
		
		JToggleButton tglbtn = new JToggleButton("");
		tglbtn.setIcon(new ImageIcon("C:\\java\\catcon.PNG"));
		tglbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println( "상태 : " + tglbtn.isSelected() );
				System.out.println( "라벨 : " + tglbtn.getText() );
			}
		});
		tglbtn.setBounds(12, 94, 92, 85);
		contentPane.add(tglbtn);
	}
}
