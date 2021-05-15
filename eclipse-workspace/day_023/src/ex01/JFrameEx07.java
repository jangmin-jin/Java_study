package ex01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFrameEx07 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameEx07 frame = new JFrameEx07();
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
	public JFrameEx07() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 460, 290);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println( table.getSelectedColumn() );
				System.out.println( table.getSelectedRow() );
				System.out.println( table.getValueAt( table.getSelectedRow(),  table.getSelectedColumn() ));
			}
		});
		scrollPane.setViewportView(table);
		
		// 클래스화 선언
//		table.setModel(new CustomTableModel());
//		table.setModel(new CustomTableModel2());
//		table.setModel(new CustomTableModel3());
		
		// 기존 선언
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "2", "3", "4", "5"},
				{"6", "7", "8", "9", "10"},
				{"11", "12", "13", "14", "15"},
				{"16", "17", "18", "19", "20"},
				{"21", "22", "23", "24", "25"},
			},
			new String[] {
				"\uCEEC\uB7FC1", "\uCEEC\uB7FC2", "\uCEEC\uB7FC3", "\uCEEC\uB7FC4", "\uCEEC\uB7FC5"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				System.out.println( table.getSelectedColumn() );
//				System.out.println( table.getSelectedRow() );
//				System.out.println( table.getValueAt( table.getSelectedRow(),  table.getSelectedColumn() ));
			}
		});
		btnNewButton.setBounds(12, 310, 460, 41);
		contentPane.add(btnNewButton);
	}
}
