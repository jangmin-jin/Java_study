package project2;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TodoListMain extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TodoListMain frame = new TodoListMain();
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
	public TodoListMain() {
		setTitle("Todo 관리");
		setFont(new Font("돋움", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 768);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnTodo = new JButton("할일 목록");
		btnTodo.setBounds(158, 10, 120, 40);
		contentPane.add(btnTodo);
		
		JButton btnComTodo = new JButton("완료 목록");
		btnComTodo.setBounds(290, 10, 120, 40);
		contentPane.add(btnComTodo);
		
		JButton btnDelTodo = new JButton("삭제 목록");
		btnDelTodo.setBounds(422, 10, 120, 40);
		contentPane.add(btnDelTodo);
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginDlg loginDlg = new LoginDlg();
				loginDlg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//				loginDlg.setModal(false);
				loginDlg.setVisible(true);
			}
		});
		btnLogin.setBounds(749, 10, 120, 40);
		contentPane.add(btnLogin);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(158, 78, 711, 641);
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"\uD560\uC77C", "\uC785\uB825 \uB0A0\uC9DC", "\uC644\uB8CC \uB0A0\uC9DC"
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
		
		JButton btnInsert = new JButton("추가");
		btnInsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String addTodo = null;
				addTodo = JOptionPane.showInputDialog(TodoListMain.this, "텍스트를 입력하세요",
						"추가", JOptionPane.QUESTION_MESSAGE);
				System.out.println(addTodo);
			}
		});
		btnInsert.setBounds(12, 78, 120, 40);
		contentPane.add(btnInsert);
		
		JButton btnModify = new JButton("수정");
		btnModify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String modifyTodo = null;
				modifyTodo = JOptionPane.showInputDialog(TodoListMain.this, "수정할 텍스트를 입력하세요",
						"수정", JOptionPane.QUESTION_MESSAGE);
				System.out.println(modifyTodo);
			}
		});
		btnModify.setBounds(12, 128, 120, 40);
		contentPane.add(btnModify);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showConfirmDialog(TodoListMain.this, "정말 삭제하시겠습니까?",
						"삭제확인", JOptionPane.WARNING_MESSAGE);
				JOptionPane.showMessageDialog(TodoListMain.this, "삭제 목록으로 이동합니다.",
						"삭제확인", JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnDelete.setBounds(12, 178, 120, 40);
		contentPane.add(btnDelete);
		
		JButton btnComplete = new JButton("완료");
		btnComplete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(TodoListMain.this, "완료 목록으로 이동합니다.",
						"완료", JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnComplete.setBounds(12, 287, 120, 40);
		contentPane.add(btnComplete);
	}
}
