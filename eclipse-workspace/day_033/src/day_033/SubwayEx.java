package day_033;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ItemEvent;
import javax.swing.table.DefaultTableModel;

public class SubwayEx extends JFrame {

	private JPanel contentPane;
	private JComboBox cmbLocal;
	private JComboBox cmbLine;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubwayEx frame = new SubwayEx();
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
	public SubwayEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cmbLocal = new JComboBox();
		cmbLocal.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// index 0에는 제목 ('지역')이 들어가있어 에러가 발생하므로 검사
				// != 가 아닌 >로 검사하는 이유는 -1 (not selected) 인 경우도 거르기 위해서
				if( cmbLocal.getSelectedIndex() > 0 ) {
					// cmbLocal에서 선택한 값 가져와서 콤보박스 모델 생성
					String strLocal = (String)cmbLocal.getSelectedItem();
					cmbLine.setModel( new LineComboBoxModel(strLocal) );
					cmbLine.setSelectedIndex(0);
				}
			}
		});
		cmbLocal.setModel( new LocalComboBoxModel() );
		cmbLocal.setSelectedIndex(0);
		cmbLocal.setBounds(12, 10, 141, 23);
		contentPane.add(cmbLocal);
		
		cmbLine = new JComboBox();
		cmbLine.setModel(new DefaultComboBoxModel(new String[] {"노선"}));
		cmbLine.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// index 0에는 제목 ('지역', '노선')이 들어가있어 에러가 발생하므로 검사
				// != 가 아닌 >로 검사하는 이유는 -1 (not selected) 인 경우도 거르기 위해서
				// 두 콤보박스 모두 값이 선택되어야 하기 때문에 &&
				if( cmbLocal.getSelectedIndex() != 0 && cmbLine.getSelectedIndex() > 0 ) {
					// cmbLocal과 cmbLine에서 선택한 값 가져와서 테이블 모델 생성
					String strLocal = (String)cmbLocal.getSelectedItem();
					String strLine = (String)cmbLine.getSelectedItem();
					table.setModel( new SubwayTableModel( strLocal, strLine ) );
				}
			}
		});
		cmbLine.setBounds(172, 10, 141, 23);
		contentPane.add(cmbLine);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 43, 422, 297);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"지역", "노선", "역이름"
			}
		));
		scrollPane.setViewportView(table);
		
	}
}
