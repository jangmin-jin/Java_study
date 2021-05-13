package ex01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFrameEx09 extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextArea textArea;
	private JRadioButton rdbtn1;
	private JRadioButton rdbtn2;
	private JRadioButton rdbtn3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameEx09 frame = new JFrameEx09();
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
	public JFrameEx09() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rdbtn1 = new JRadioButton("사과");
		buttonGroup.add(rdbtn1);
		rdbtn1.setBounds(8, 6, 121, 23);
		contentPane.add(rdbtn1);
		
		rdbtn2 = new JRadioButton("참외");
		buttonGroup.add(rdbtn2);
		rdbtn2.setSelected(true);
		rdbtn2.setBounds(8, 31, 121, 23);
		contentPane.add(rdbtn2);
		
		rdbtn3 = new JRadioButton("수박");
		buttonGroup.add(rdbtn3);
		rdbtn3.setBounds(8, 56, 121, 23);
		contentPane.add(rdbtn3);
		
		textArea = new JTextArea();
		textArea.setBounds(8, 143, 495, 211);
		contentPane.add(textArea);
		
		JButton btn = new JButton("결과출력");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea.setText("");
				if(rdbtn1.isSelected()) {
					textArea.append(rdbtn1.getText());
				}
				if(rdbtn2.isSelected()) {
					textArea.append(rdbtn2.getText());
				}
				if(rdbtn3.isSelected()) {
					textArea.append(rdbtn3.getText());
				}
				
			}
		});
		btn.setBounds(8, 85, 495, 48);
		contentPane.add(btn);
	}

}
