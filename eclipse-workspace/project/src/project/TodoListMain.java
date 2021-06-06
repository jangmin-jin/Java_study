package project;

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
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class TodoListMain extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnInsert;
	private JButton btnModify;
	private JButton btnDelete;
	private JButton btnComplete;
	private JButton btnTodo;
	private JButton btnComTodo;
	private JButton btnDelTodo;
	
	/*
	 *	현재 출력되고 있는 화면 종류
 	 *	0 - 할일 목록
	 *	1 - 완료 목록
	 *	2 - 삭제 목록
	 */
	private int listSelect = 0;
	private int buttonType = 0;
	private String id = "";
	private String pw = "";
	private JTextField textFieldNowLoginId;

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
		
		btnTodo = new JButton("할일 목록");
		btnTodo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// 할일 목록 표시
				listSelect = 0;
				// 버튼 활성화 유무 결정
				btnInsert.setEnabled(true);
				btnInsert.setText("추가");
				btnModify.setEnabled(true);
				btnModify.setText("수정");
				btnDelete.setEnabled(true);
				btnDelete.setText("삭제");
				btnComplete.setEnabled(true);
				btnComplete.setText("완료");
				
				// 로그인 검사 후 테이블 갱신
				if(id.equals("")) {
					JOptionPane.showMessageDialog(TodoListMain.this, "로그인 해주세요.",
							"로그인 정보 없음", JOptionPane.PLAIN_MESSAGE);
				}else {
					// 할일 목록 출력
					table.setModel(new CustomTodoModel(id, listSelect));
				}
			}
		});
		btnTodo.setBounds(160, 10, 120, 40);
		contentPane.add(btnTodo);
		
		btnComTodo = new JButton("완료 목록");
		btnComTodo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// 완료 목록 표시
				listSelect = 1;
				// 버튼 활성화 유무 결정
				btnInsert.setEnabled(true);
				btnInsert.setText("복구");
				btnModify.setEnabled(false);
				btnModify.setText("수정");
				btnDelete.setEnabled(true);
				btnDelete.setText("삭제");
				btnComplete.setEnabled(true);
				btnComplete.setText("전체삭제");
				
				// 로그인 검사 후 테이블 갱신
				if(id.equals("")) {
					JOptionPane.showMessageDialog(TodoListMain.this, "로그인 해주세요.",
							"로그인 정보 없음", JOptionPane.PLAIN_MESSAGE);
				}else {
					// 완료 목록 출력
					table.setModel(new CustomTodoModel(id, listSelect));
				}
				
			}
		});
		btnComTodo.setBounds(290, 10, 120, 40);
		contentPane.add(btnComTodo);
		
		btnDelTodo = new JButton("삭제 목록");
		btnDelTodo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// 삭제 목록 표시
				listSelect = 2;
				// 버튼 활성화 유무 결정
				btnInsert.setEnabled(true);
				btnInsert.setText("복구");
				btnModify.setEnabled(false);
				btnModify.setText("수정");
				btnDelete.setEnabled(true);
				btnDelete.setText("완전삭제");
				btnComplete.setEnabled(true);
				btnComplete.setText("전체 완전삭제");
				
				// 로그인 검사 후 테이블 갱신
				if(id.equals("")) {
					JOptionPane.showMessageDialog(TodoListMain.this, "로그인 해주세요.",
							"로그인 정보 없음", JOptionPane.PLAIN_MESSAGE);
				}else {
					// 삭제 목록 출력
					table.setModel(new CustomTodoModel(id, listSelect));
				}
				
			}
		});
		btnDelTodo.setBounds(420, 10, 120, 40);
		contentPane.add(btnDelTodo);
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// 로그인 Dlg 연결
				LoginDlg loginDlg = new LoginDlg();
				loginDlg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				loginDlg.setModal(true);
				loginDlg.setVisible(true);
				
				// 로그인 결과 저장 및 화면에 출력
				id = loginDlg.loginID;
				pw = loginDlg.loginPW;
				
				textFieldNowLoginId.setText(id);
				
				// 현재 보고 있는 목록 갱신
				table.setModel(new CustomTodoModel(id, listSelect));
			}
		});
		btnLogin.setBounds(620, 10, 120, 40);
		contentPane.add(btnLogin);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(160, 78, 710, 640);
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
		
		btnInsert = new JButton("추가");
		btnInsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// 로그인 검사 후 버튼 로직 실행
				if(id.equals("")) {
					JOptionPane.showMessageDialog(TodoListMain.this, "로그인 해주세요.",
							"로그인 정보 없음", JOptionPane.PLAIN_MESSAGE);
				}else {
					switch (listSelect) {
					// 할일 목록 - 추가버튼
					case 0:
						String addTodo = null;
						// 추가 사항을 입력받는 JOptionpane 생성
						addTodo = JOptionPane.showInputDialog(TodoListMain.this, "텍스트를 입력하세요",
								"추가", JOptionPane.QUESTION_MESSAGE);
						
						// 추가 시간을 기록하기 위한 addtime
						SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
						Calendar time = Calendar.getInstance();
						String addTime = format.format(time.getTime());
						
						// 추가항목은 NULL과 공백은 허용하지 않는다.
						if(addTodo != null) {
							if(addTodo.trim().equals("")) {
								return;
							}else {
								// 데이터베이스에 추가 후 목록 갱신
								DataDAO dao = new DataDAO();
								dao.addTodoList(id, addTodo, addTime);
								table.setModel(new CustomTodoModel(id, listSelect));
							}
						}
						break;
					
					// 완료목록 - 복구버튼
					// 삭제목록 - 복구버튼
					default :
						JOptionPane.showMessageDialog(TodoListMain.this, "복구 실행 완료.",
								"완료", JOptionPane.PLAIN_MESSAGE);
						
						// 선택된 행의 정보를 저장
						String selectTodoList = (String)table.getValueAt(table.getSelectedRow(), 0);
						String selectTodoTime = (String)table.getValueAt(table.getSelectedRow(), 1);
						String selectTodoComTime = (String)table.getValueAt(table.getSelectedRow(), 2);
						
						// 복구 실행 후 목록 갱신
						DataDAO dao = new DataDAO();
						dao.restoreTodo(id, selectTodoList, selectTodoTime, selectTodoComTime, listSelect);
						table.setModel(new CustomTodoModel(id, listSelect));
						break;
					}
					
				}
			}
		});
		btnInsert.setBounds(12, 78, 120, 40);
		contentPane.add(btnInsert);
		
		btnModify = new JButton("수정");
		btnModify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//로그인 검사 후 버튼 로직 실행
				if(id.equals("")) {
					JOptionPane.showMessageDialog(TodoListMain.this, "로그인 해주세요.",
							"로그인 정보 없음", JOptionPane.PLAIN_MESSAGE);
				}else {
					// 수정 사항을 받아오는 JOptionPane 생성
					String modifyTodo = null;
					modifyTodo = JOptionPane.showInputDialog(TodoListMain.this, "수정할 텍스트를 입력하세요",
					"수정", JOptionPane.QUESTION_MESSAGE);
					
					/*
					 * 실행 예외 조건
					 * 1. 수정하고자 하는 셀이 선택되어야함.
					 * 2. 수정하고자 하는 값은 NULL이 될 수 없다.
					 * 3. 수정하고자 하는 값은 공백이 될 수 없다.
					 */
					if(table.getSelectedRow() < 0 || modifyTodo == null || modifyTodo.trim().length() < 1) {
						System.out.println("실행 안함.");
					}else {
						// 선택된 행의 정보를 저장
						String selectTodoList = (String)table.getValueAt(table.getSelectedRow(), 0);
						String selectTodoTime = (String)table.getValueAt(table.getSelectedRow(), 1);
						
						// 수정된 시간을 기준으로 갱신
						SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
						Calendar time = Calendar.getInstance();
						String modifyTime = format.format(time.getTime());
						
						// 수정 실시
						DataDAO dao = new DataDAO();
						dao.modifyTodo(id, selectTodoList, selectTodoTime, modifyTodo, modifyTime);
						
						// 목록 갱신
						table.setModel(new CustomTodoModel(id, listSelect));
					}
				}
			}
		});
		btnModify.setBounds(12, 128, 120, 40);
		contentPane.add(btnModify);
		
		btnDelete = new JButton("삭제");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 로그인 검사 후 버튼 로직 실행
				if(id.equals("")) {
					JOptionPane.showMessageDialog(TodoListMain.this, "로그인 해주세요.",
							"로그인 정보 없음", JOptionPane.PLAIN_MESSAGE);
				}else {
					// 삭제 목록 - 완전 삭제
					switch (listSelect) {
					case 2:
						// 완전 삭제 확인을 위한 JOptionPane
						int del = 0;
						del = JOptionPane.showConfirmDialog(TodoListMain.this, "완전히 삭제하시겠습니까?",
								"완전삭제 확인", JOptionPane.WARNING_MESSAGE);
						
						// 확인 버튼을 눌렀을 시에만 완전 삭제 실행
						if(del == 0) {
							// 선택된 행의 정보를 저장
							String selectTodoList = (String)table.getValueAt(table.getSelectedRow(), 0);
							String selectTodoTime = (String)table.getValueAt(table.getSelectedRow(), 1);
							
							DataDAO dao = new DataDAO();
							dao.delComTodo(id, selectTodoList, selectTodoTime);
							table.setModel(new CustomTodoModel(id, listSelect));
						}else {
							return;
						}
						break;
						
					// 할일 목록 - 삭제
					// 완료 목록 - 삭제
					default:
						// 삭제 확인을 위한 JOptionPane
						del = 0;
						del = JOptionPane.showConfirmDialog(TodoListMain.this, "정말 삭제하시겠습니까?",
								"삭제 확인", JOptionPane.WARNING_MESSAGE);
						
						// 확인 버튼을 눌렀을 시에만 완전 삭제 실행
						if(del == 0) {
							// 선택된 행의 정보를 저장
							String selectTodoList = (String)table.getValueAt(table.getSelectedRow(), 0);
							String selectTodoTime = (String)table.getValueAt(table.getSelectedRow(), 1);
							
							DataDAO dao = new DataDAO();
							dao.deleteTodo(id, selectTodoList, selectTodoTime);
							table.setModel(new CustomTodoModel(id, listSelect));
						}else {
							return;
						}
						break;
					}
					
				}
			}
		});
		btnDelete.setBounds(12, 178, 120, 40);
		contentPane.add(btnDelete);
		
		btnComplete = new JButton("완료");
		btnComplete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				// 로그인 검사 후 버튼 로직 실행
				if(id.equals("")) {
					JOptionPane.showMessageDialog(TodoListMain.this, "로그인 해주세요.",
							"로그인 정보 없음", JOptionPane.PLAIN_MESSAGE);
				}else {		
					DataDAO dao = new DataDAO();
					int del = 0;
					
					// 할일 목록 - 완료 목록으로 이동
					switch (listSelect) {
					case 0:
						JOptionPane.showMessageDialog(TodoListMain.this, "완료 목록으로 이동합니다.",
								"완료", JOptionPane.PLAIN_MESSAGE);
						
						// 선택된 행의 정보를 저장
						String selectTodoList = (String)table.getValueAt(table.getSelectedRow(), 0);
						String selectTodoTime = (String)table.getValueAt(table.getSelectedRow(), 1);
						
						// 완료된 시간
						SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
						Calendar time = Calendar.getInstance();
						String comTime = format.format(time.getTime());
						
						// 완료 목록으로 이동
						dao.completeTodo(id, selectTodoList, selectTodoTime, comTime);
						// 목록 갱신
						table.setModel(new CustomTodoModel(id, listSelect));
						break;
						
					// 완료 목록 - 전체 삭제 목록으로 이동
					case 1:
						// 삭제 확인을 위한 JOptionPane
						del = JOptionPane.showConfirmDialog(TodoListMain.this, "완료 목록들을 삭제하시겠습니까?",
								"전체 삭제", JOptionPane.ERROR_MESSAGE);
						
						// 확인을 눌렀을 시에만 전체 삭제 실행
						if (del == 0) {
							dao.delAllcomTodo(id);
							table.setModel(new CustomTodoModel(id, listSelect));
						}else {
							return;
						}
						break;
					// 삭제 목록 - 전체 데이터 삭제
					case 2:
						// 완전 삭제 확인을 위한 JOptionPane
						del = JOptionPane.showConfirmDialog(TodoListMain.this, "모든 삭제목록을 비우시겠습니까?",
								"완전 삭제", JOptionPane.ERROR_MESSAGE);
						
						if (del == 0) {
							dao.delAlldelTodo(id);
							table.setModel(new CustomTodoModel(id, listSelect));
						}else {
							return;
						}
						break;
					}
				}
			}
		});
		btnComplete.setBounds(12, 287, 120, 40);
		contentPane.add(btnComplete);
		
		JLabel lblNewLabel = new JLabel("로그인 ID");
		lblNewLabel.setBounds(12, 10, 57, 15);
		contentPane.add(lblNewLabel);
		
		textFieldNowLoginId = new JTextField();
		textFieldNowLoginId.setEditable(false);
		textFieldNowLoginId.setBounds(12, 29, 116, 21);
		contentPane.add(textFieldNowLoginId);
		textFieldNowLoginId.setColumns(10);
		
		JButton btnLogout = new JButton("로그아웃");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 현재 유저 정보 초기화
				id = null;
				pw = null;
				textFieldNowLoginId.setText(id);
				// 목록 갱신
				table.setModel(new CustomTodoModel(id, listSelect));
			}
		});
		btnLogout.setBounds(750, 10, 120, 40);
		contentPane.add(btnLogout);
	}
}