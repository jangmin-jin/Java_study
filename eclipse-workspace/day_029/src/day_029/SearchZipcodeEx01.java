package day_029;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class SearchZipcodeEx01 extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JComboBox comboBox1;
	private JComboBox comboBox2;
	private JComboBox comboBox3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchZipcodeEx01 frame = new SearchZipcodeEx01();
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
	public SearchZipcodeEx01() {
		setTitle("우편번호 검색기\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uC6B0\uD3B8\uBC88\uD638 \uAC80\uC0C9\uAE30", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 5, 459, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		
		comboBox1 = new JComboBox();
		comboBox1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					System.out.println("보탄1");
				}
			}
		});
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {"시도"}));
		comboBox1.setBounds(26, 24, 118, 23);
		panel.add(comboBox1);
		
		comboBox2 = new JComboBox();
		comboBox2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					System.out.println("보탄2");
				}
			}
		});
		comboBox2.setModel(new DefaultComboBoxModel(new String[] {"구군"}));
		comboBox2.setBounds(170, 24, 118, 23);
		panel.add(comboBox2);
		
		comboBox3 = new JComboBox();
		comboBox3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					System.out.println("보탄3");
				}
			}
		});
		comboBox3.setModel(new DefaultComboBoxModel(new String[] {"동"}));
		comboBox3.setBounds(314, 24, 118, 23);
		panel.add(comboBox3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 68, 459, 529);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
}
