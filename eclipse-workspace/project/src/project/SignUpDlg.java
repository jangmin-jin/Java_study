package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class SignUpDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldID;
	private JTextField textFieldName;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textFieldJuminFront;
	private JTextField textFieldEmailFront;
	private JTextField textFieldEmailBack;
	private JTextField textFieldZipcode;
	private JTextField textFieldExtraAddress;
	private JRadioButton rdbtnWoman;
	private JRadioButton rdbtnMan;
	private JPasswordField textFieldPW;
	private JTextPane textPaneAddress;
	private JPasswordField textFieldJuminBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SignUpDlg dialog = new SignUpDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SignUpDlg() {
		setTitle("회원가입");
		setBounds(100, 100, 481, 423);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textFieldID = new JTextField();
			textFieldID.setEditable(false);
			textFieldID.setBounds(80, 23, 116, 21);
			contentPanel.add(textFieldID);
			textFieldID.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("아이디");
			lblNewLabel.setBounds(12, 26, 57, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel = new JLabel("비밀번호");
			lblNewLabel.setBounds(12, 54, 57, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel = new JLabel("이름");
			lblNewLabel.setBounds(12, 82, 57, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			textFieldName = new JTextField();
			textFieldName.setColumns(10);
			textFieldName.setBounds(80, 79, 116, 21);
			contentPanel.add(textFieldName);
		}
		
		rdbtnWoman = new JRadioButton("여성");
		rdbtnWoman.setSelected(true);
		buttonGroup.add(rdbtnWoman);
		rdbtnWoman.setBounds(80, 106, 57, 23);
		contentPanel.add(rdbtnWoman);
		
		rdbtnMan = new JRadioButton("남성");
		buttonGroup.add(rdbtnMan);
		rdbtnMan.setBounds(141, 106, 57, 23);
		contentPanel.add(rdbtnMan);
		
		JLabel lblNewLabel = new JLabel("성별");
		lblNewLabel.setBounds(12, 110, 57, 15);
		contentPanel.add(lblNewLabel);
		{
			JButton btnNewButton = new JButton("중복확인");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					IdCheckDlg idCheckDlg = new IdCheckDlg();
					idCheckDlg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					idCheckDlg.setModal(true);
					idCheckDlg.setVisible(true);
					
					String idCheckResult = idCheckDlg.idCheckResult;
					textFieldID.setText(idCheckResult);
				}
			});
			btnNewButton.setBounds(208, 22, 97, 23);
			contentPanel.add(btnNewButton);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("주민번호");
			lblNewLabel_1.setBounds(12, 138, 57, 15);
			contentPanel.add(lblNewLabel_1);
		}
		{
			textFieldJuminFront = new JTextField();
			textFieldJuminFront.setColumns(10);
			textFieldJuminFront.setBounds(80, 135, 75, 21);
			contentPanel.add(textFieldJuminFront);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("-");
			lblNewLabel_2.setBounds(162, 138, 14, 15);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("이메일");
			lblNewLabel_1.setBounds(12, 166, 57, 15);
			contentPanel.add(lblNewLabel_1);
		}
		{
			textFieldEmailFront = new JTextField();
			textFieldEmailFront.setColumns(10);
			textFieldEmailFront.setBounds(80, 163, 116, 21);
			contentPanel.add(textFieldEmailFront);
		}
		{
			textFieldEmailBack = new JTextField();
			textFieldEmailBack.setColumns(10);
			textFieldEmailBack.setBounds(214, 163, 116, 21);
			contentPanel.add(textFieldEmailBack);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("@");
			lblNewLabel_2.setBounds(198, 166, 14, 15);
			contentPanel.add(lblNewLabel_2);
		}
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					// 0번 선택은 공백
					if(comboBox.getSelectedIndex() == 0) {
						textFieldEmailBack.setText("");
					}else {
						// 이메일 목록을 선택하면 textfield에 자동으로 채워줌
						textFieldEmailBack.setText((String)comboBox.getSelectedItem());
					}
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"직접입력", "naver.com", "daum.net", "google.com"}));
		comboBox.setBounds(338, 163, 116, 21);
		contentPanel.add(comboBox);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uC8FC\uC18C", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(6, 206, 453, 138);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("우편번호");
			lblNewLabel_1.setBounds(6, 21, 57, 15);
			panel.add(lblNewLabel_1);
			
			textFieldZipcode = new JTextField();
			textFieldZipcode.setEditable(false);
			textFieldZipcode.setBounds(74, 18, 116, 21);
			panel.add(textFieldZipcode);
			textFieldZipcode.setColumns(10);
			
			JButton btnZipcodeSearch = new JButton("우편번호 검색");
			btnZipcodeSearch.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// 우편번호 검색기 Dlg 실행
					ZipcodeSearchDlg zipcodeDlg = new ZipcodeSearchDlg();
					zipcodeDlg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					zipcodeDlg.setModal(true);
					zipcodeDlg.setVisible(true);
					
					// 우편번호 결과를 회원가입창 필드에 자동 입력
					String zipcode = zipcodeDlg.zipcode1 + zipcodeDlg.zipcode2;
					String address = zipcodeDlg.address;
					textFieldZipcode.setText(zipcode);
					textPaneAddress.setText(address);
				}
			});
			btnZipcodeSearch.setBounds(202, 17, 122, 23);
			panel.add(btnZipcodeSearch);
			
			JLabel lblNewLabel_1_1 = new JLabel("상세 주소");
			lblNewLabel_1_1.setBounds(6, 49, 57, 15);
			panel.add(lblNewLabel_1_1);
			{
				JLabel lblNewLabel_1_2 = new JLabel("나머지 주소");
				lblNewLabel_1_2.setBounds(6, 101, 75, 15);
				panel.add(lblNewLabel_1_2);
			}
			{
				textFieldExtraAddress = new JTextField();
				textFieldExtraAddress.setBounds(74, 98, 373, 21);
				panel.add(textFieldExtraAddress);
				textFieldExtraAddress.setColumns(10);
			}
			
			textPaneAddress = new JTextPane();
			textPaneAddress.setEditable(false);
			textPaneAddress.setBounds(74, 49, 372, 42);
			panel.add(textPaneAddress);
		}
		
		textFieldPW = new JPasswordField();
		textFieldPW.setBounds(80, 51, 116, 21);
		contentPanel.add(textFieldPW);
		{
			textFieldJuminBack = new JPasswordField();
			textFieldJuminBack.setBounds(177, 135, 75, 21);
			contentPanel.add(textFieldJuminBack);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("가입");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// DAO 호출
						DataDAO dao = new DataDAO();
						
						// 필수 요소들이 없으면 에러 - 데이터베이스에 추가 되지 않아야함.
						String id = textFieldID.getText();
						String pw = new String(textFieldPW.getPassword());
						String name = textFieldName.getText().trim();
						
						// 성별 판단
						String sex = "";
						if(rdbtnWoman.getSelectedObjects() != null) {
							sex = rdbtnWoman.getText();
						} else {
							sex = rdbtnMan.getText();
						}

						// 주민번호는 형식 체크
						String juminFront = textFieldJuminFront.getText().trim();
						String juminBack = new String(textFieldJuminBack.getPassword()).trim();
						String jumin = juminFront + juminBack;
						String juminSex = juminBack.substring(0, 1);
						
						Boolean juminResult = dao.jumincheck(jumin);
						
						// 입력 자유 항목들
						String email = textFieldEmailFront.getText().trim() + "@" + textFieldEmailBack.getText().trim();
						String zipcode = textFieldZipcode.getText().trim();
						String address = textPaneAddress.getText().trim();
						String extraAddress = textFieldExtraAddress.getText().trim();
						System.out.println(sex);
						System.out.println(juminSex);
						
						// 필수 입력 항목 검사
						if(id.length() == 0) {
							// 아이디 검사
							JOptionPane.showMessageDialog(SignUpDlg.this, "아이디를 입력해 주세요.",
									"아이디 입력 누락", JOptionPane.WARNING_MESSAGE);
						}else if(pw.length() == 0) {
							// 비밀번호 검사 - 입력이 누락된 경우
							JOptionPane.showMessageDialog(SignUpDlg.this, "비밀번호를 입력해 주세요.",
									"비밀번호 입력 누락", JOptionPane.WARNING_MESSAGE);
						}else if(pw.contains(" ")) {
							// 비밀번호 검사 - 공백이 포함된 경우
							JOptionPane.showMessageDialog(SignUpDlg.this, "비밀번호에는 공백이 포함될 수 없습니다.",
									"비밀번호 입력 누락", JOptionPane.WARNING_MESSAGE);
						}else if(name.length() == 0) {
							// 이름 검사 - 이름이 누락된 경우
							JOptionPane.showMessageDialog(SignUpDlg.this, "이름 입력해 주세요.",
									"이름 입력 누락", JOptionPane.WARNING_MESSAGE);
						}else if(juminResult == false) {
							// 주민번호 검사 - 주민번호가 틀린 경우
							JOptionPane.showMessageDialog(SignUpDlg.this, "주민번호를 확인해 주세요.",
									"주민번호 검사", JOptionPane.WARNING_MESSAGE);
						}else if(sex.equals("여성") && juminSex.equals("1") || sex.equals("여성") && juminSex.equals("3")) {
							// 성별 검사 - 주민번호와 성별이 다른경우
							JOptionPane.showMessageDialog(SignUpDlg.this, "주민번호 혹은 성별을 확인해 주세요.",
									"성별 불일치", JOptionPane.WARNING_MESSAGE);
						}else if(sex.equals("남성") && juminSex.equals("2") || sex.equals("남성") && juminSex.equals("4")) {
							JOptionPane.showMessageDialog(SignUpDlg.this, "주민번호 혹은 성별을 확인해 주세요.",
									"성별 불일치", JOptionPane.WARNING_MESSAGE);
						}else {
							// 자유 항목들 입력 안했으면 null 값으로 바꿈
							if(email.length() == 1) {
								email = null;
							} 
							if(zipcode.length() == 0) {
								zipcode = null;
							}
							if(address.length() == 0) {
								address = null;
							}
							if(extraAddress.length() == 0) {
								extraAddress = null;
							}
							
							// 최종 확인
							int result = JOptionPane.showConfirmDialog(SignUpDlg.this, "회원가입 하시겠습니까?",
									"회원가입 확인", JOptionPane.WARNING_MESSAGE);
							
							if(result == 0) {
								// 완료 창 출력
								JOptionPane.showConfirmDialog(SignUpDlg.this, "회원가입이 완료되었습니다",
										"회원가입 확인", JOptionPane.PLAIN_MESSAGE);
								// 데이터베이스에 정보 전달
								// id, pw, name, sex, jumin, email, zipcode, address, extraAddress;
								// 회원 가입 절차 진행
								dao.signUp(id, pw, name, sex, jumin, email, zipcode, address, extraAddress);
							}else {
								return;
							}
							
							SignUpDlg.this.dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("취소");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						SignUpDlg.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
