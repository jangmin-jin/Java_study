package day_032;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ItemEvent;
import javax.swing.table.DefaultTableModel;

public class SearchSubwayMain extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JComboBox comboBox1;
	private JComboBox comboBox2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchSubwayMain frame = new SearchSubwayMain();
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
	public SearchSubwayMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 416, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uC9C0\uD558\uCCA0 \uC5ED \uAC80\uC0C9", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(6, 10, 384, 53);
		contentPane.add(panel);
		panel.setLayout(null);
		
		comboBox1 = new JComboBox();
		comboBox1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					// 0번째 인덱스는 선택해도 이벤트가 발생하지 않도록 한다.
					if(comboBox1.getSelectedIndex() != 0) {
						
						// comboBox1에 선택된 지역정보를 이용하여 노선을 검색한다.
						String local = (String)comboBox1.getSelectedItem();
						SubwayDAO dao = new SubwayDAO();
						ArrayList<SubwayTO> station = dao.searchLine( local );
						
						ArrayList<String> strStation = new ArrayList<String>();
						
						// comboBox2 0번째 Item은 "노선"으로 함.
						strStation.add("노선");
						for(SubwayTO to : station) {
							strStation.add(to.getLine());
						}
						System.out.println(strStation);
						
						// comboBox2의 모델을 초기화.
						comboBox2.setModel(new DefaultComboBoxModel(strStation.toArray()));
					}
				}
			}
		});
		// 지역 선언
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {"지역", "수도권", "부산", "대구", "광주", "대전"}));
		comboBox1.setBounds(6, 17, 180, 23);
		panel.add(comboBox1);
		
		comboBox2 = new JComboBox();
		comboBox2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// 0번째 인덱스는 선택해도 이벤트가 발생하지 않도록 한다.
				if(comboBox1.getSelectedIndex() != 0) {
					// 각 comboBox에 선택된 데이터를 이용하여 table의 값을 초기화 한다.
					String strLocal = (String)comboBox1.getSelectedItem();
					String strLine = (String)comboBox2.getSelectedItem();
					
					table.setModel(new CustomSubwayModel(strLocal, strLine));
				}
			}
		});
		comboBox2.setModel(new DefaultComboBoxModel(new String[] {"노선"}));
		comboBox2.setBounds(198, 17, 180, 23);
		panel.add(comboBox2);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 70, 372, 381);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"\uC77C\uB828\uBC88\uD638", "\uC9C0\uC5ED", "\uB178\uC120", "\uC5ED\uC774\uB984"
			}
		));
		scrollPane.setViewportView(table);
	}
}
