package jsoup;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class JSoupEx03 extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JSoupEx03 frame = new JSoupEx03();
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
	public JSoupEx03() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uB274\uC2A4 \uAC80\uC0C9", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(6, 4, 474, 54);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btn1 = new JButton("열독률 높은 뉴스");
		btn1.setBounds(24, 21, 131, 23);
		panel.add(btn1);
		
		JButton btn2 = new JButton("댓글 많은 뉴스");
		btn2.setBounds(167, 21, 131, 23);
		panel.add(btn2);
		
		JButton btn3 = new JButton("연령별 인기 뉴스");
		btn3.setBounds(310, 21, 131, 23);
		panel.add(btn3);
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 열독률 높은 뉴스
				String address = "https://news.daum.net/ranking/age";
				table.setModel(new CustomNewsModel(address));
			}
		});
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 댓글 많은 뉴스
				String address = "https://news.daum.net/ranking/bestreply";
				table.setModel(new CustomNewsModel(address));
			}
		});
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 연령별 인기 뉴스
				String address = "https://news.daum.net/ranking/kkomkkom";
				table.setModel(new CustomNewsModel(address));
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 79, 830, 442);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"\uCD9C\uCC98", "\uC81C\uBAA9", "\uB0B4\uC6A9"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
	}
}
