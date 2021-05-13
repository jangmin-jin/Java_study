package ex01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class JFrameEx06 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameEx06 frame = new JFrameEx06();
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
	public JFrameEx06() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(12, 10, 445, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btn = new JButton("출력");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CapitalizeName cn = new CapitalizeName();
				
				lbl.setText( cn.capitalizeName( textField.getText() ) );
			}
		});
		btn.setBounds(469, 9, 97, 23);
		contentPane.add(btn);
		
		lbl = new JLabel("결과");
		lbl.setBackground(new Color(255, 255, 255));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setBounds(12, 54, 554, 46);
		contentPane.add(lbl);
	}
}
