package ex01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JuminJFrameEx01 extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JuminJFrameEx01 frame = new JuminJFrameEx01();
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
	public JuminJFrameEx01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(12, 43, 344, 187);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("주민번호검사기");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				textArea.setText("");
				String msg = JOptionPane.showInputDialog("주민등록 번호 입력 : XXXXXX-XXXXXXX");
				JuminCheck juminCheck = new JuminCheck();
				String result = juminCheck.jumincheck(msg);
				
				if(msg != null) {
					textArea.append(result);
				}else {
					textArea.append("입력실패!");
				}
			}
		});
		btnNewButton.setBounds(12, 10, 344, 23);
		contentPane.add(btnNewButton);
	}
}
