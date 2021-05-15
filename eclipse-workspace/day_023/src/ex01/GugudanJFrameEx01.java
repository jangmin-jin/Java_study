package ex01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class GugudanJFrameEx01 extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBoxStartDan;
	private JComboBox comboBoxEndDan;
	private JTextArea textArea;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GugudanJFrameEx01 frame = new GugudanJFrameEx01();
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
	public GugudanJFrameEx01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBoxStartDan = new JComboBox();
		comboBoxStartDan.setModel(new DefaultComboBoxModel(new String[] {"시작단", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		comboBoxStartDan.setBounds(12, 10, 137, 23);
		contentPane.add(comboBoxStartDan);
		
		comboBoxEndDan = new JComboBox();
		comboBoxEndDan.setModel(new DefaultComboBoxModel(new String[] {"끝단", "1", "2", "3", "4", "5", "6", "8", "9"}));
		comboBoxEndDan.setBounds(161, 10, 137, 23);
		contentPane.add(comboBoxEndDan);
		
		JButton btn = new JButton("결과 출력");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// textArea 초기화
				textArea.setText("");
				
				// 예외 처리 : 시작단, 끝단을 선택하지 않음
				if(comboBoxStartDan.getSelectedIndex() == 0 && comboBoxEndDan.getSelectedIndex() == 0) {
					textArea.append("시작단과 끝단을 선택해주세요!");
					return;
				}
				if(comboBoxStartDan.getSelectedIndex() == 0) {
					textArea.append("시작단을 선택해주세요!");
					return;
				}
				if(comboBoxEndDan.getSelectedIndex() == 0) {
					textArea.append("끝단을 선택해주세요!");
					return;
				}
				
				// 예외 처리가 끝난뒤 값을 가져옴
				int startDan = Integer.parseInt((String)comboBoxStartDan.getSelectedItem());
				int endDan = Integer.parseInt((String)comboBoxEndDan.getSelectedItem());
				
				// 결과를 result에 저장하여 출력
				String result = "";
				for(int i=startDan; i<=endDan; i++) {
					for(int j=1; j<=9; j++) {
						result += (String)(i + " X " + j + " = " + ( i * j ) + "\n");
					}
				}
				textArea.append(result);
			}
		});
		btn.setBounds(309, 10, 119, 23);
		contentPane.add(btn);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 43, 416, 346);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}

}
