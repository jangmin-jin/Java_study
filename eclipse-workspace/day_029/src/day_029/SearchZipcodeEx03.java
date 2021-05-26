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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ItemEvent;

public class SearchZipcodeEx03 extends JFrame {

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
					SearchZipcodeEx03 frame = new SearchZipcodeEx03();
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
	public SearchZipcodeEx03() {
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
		
		/*
		 	*  콤보박스1 
		 */
		comboBox1 = new JComboBox();
		comboBox1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					// 0번 인덱스외 다른 인덱스가 선택되었을 때만 동작
					if( comboBox1.getSelectedIndex() != 0 ) {
						String strSido = (String)comboBox1.getSelectedItem();
						
						ZipcodeDAO dao = new ZipcodeDAO();
						ArrayList<ZipcodeTo> guguns = dao.listGugun(strSido);
						
						ArrayList<String> strGugun = new ArrayList<String>();
						for(ZipcodeTo to : guguns) {
							strGugun.add( to.getGugun() );
						}
						
						comboBox2.setModel( new DefaultComboBoxModel( strGugun.toArray( ) ) );
					}
				}
			}
		});
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {"시도"}));
		comboBox1.setBounds(26, 24, 118, 23);
		panel.add(comboBox1);
		
		/*
	 		*  콤보박스2
	 	*/
		comboBox2 = new JComboBox();
		comboBox2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					// 0번 인덱스외 다른 인덱스가 선택되었을 때만 동작
					if( comboBox2.getSelectedIndex() != 0 ) {
						String strSido = (String)comboBox1.getSelectedItem();
						String strGugun = (String)comboBox2.getSelectedItem();
						
						ZipcodeDAO dao = new ZipcodeDAO();
						ArrayList<ZipcodeTo> dongs = dao.listDong(strSido, strGugun);
						
						ArrayList<String> strDong = new ArrayList<String>();
						for(ZipcodeTo to : dongs) {
							strDong.add( to.getDong() );
						}
						
						comboBox3.setModel( new DefaultComboBoxModel( strDong.toArray( ) ) );
					}
				}
			}
		});
		comboBox2.setModel(new DefaultComboBoxModel(new String[] {"구군"}));
		comboBox2.setBounds(170, 24, 118, 23);
		panel.add(comboBox2);
		
		/*
 			*  콤보박스3
 		*/
		comboBox3 = new JComboBox();
		comboBox3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					if( comboBox3.getSelectedIndex() != 0 ) {
						String strSido = (String)comboBox1.getSelectedItem();
						String strGugun = (String)comboBox2.getSelectedItem();
						String strDong = (String)comboBox3.getSelectedItem();
						
						textArea.setText("");
						
						ZipcodeDAO dao = new ZipcodeDAO();
						ArrayList<ZipcodeTo> addresses = dao.listAddress(strSido, strGugun, strDong);
						for(ZipcodeTo to : addresses) {
							String strAddress = String.format("[%s] %s %s %s %s %s \n", 
									to.getZipcode(), to.getSido(), to.getGugun(),
									to.getDong(), to.getRi(), to.getBunji());
							
							textArea.append(strAddress);
						}
					}
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
		
		// comboBox1 초기화
		ZipcodeDAO dao = new ZipcodeDAO();
		ArrayList<ZipcodeTo> sidos = dao.listSido();
		
		ArrayList<String> strSidos = new ArrayList<String>();
		for(ZipcodeTo to : sidos) {
			strSidos.add( to.getSido() );
		}
		
		comboBox1.setModel( new DefaultComboBoxModel( strSidos.toArray( ) ) );
	}
}