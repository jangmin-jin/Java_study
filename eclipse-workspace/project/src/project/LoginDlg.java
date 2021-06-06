package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class LoginDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	
	// 아이디와 비밀번호
	public String loginID = "";
	public String loginPW = "";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginDlg dialog = new LoginDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginDlg() {
		setTitle("로그인");
		setBounds(100, 100, 280, 180);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("아이디");
			lblNewLabel.setBounds(12, 33, 51, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel = new JLabel("비밀번호");
			lblNewLabel.setBounds(12, 69, 51, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			textField = new JTextField();
			textField.setBounds(71, 27, 160, 21);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			passwordField = new JPasswordField();
			passwordField.setBounds(71, 66, 160, 21);
			contentPanel.add(passwordField);
		}
		
		JLabel lblID = new JLabel("아이디 찾기");
		lblID.setForeground(Color.BLUE);
		lblID.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FindIdDlg findId = new FindIdDlg();
				findId.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				findId.setModal(true);
				findId.setVisible(true);
			}
		});
		lblID.setBounds(100, 5, 74, 15);
		contentPanel.add(lblID);
		{
			JLabel lblPW = new JLabel("비밀번호 찾기");
			lblPW.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					FindPwDlg findPw = new FindPwDlg();
					findPw.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					findPw.setModal(true);
					findPw.setVisible(true);
				}
			});
			lblPW.setForeground(Color.BLUE);
			lblPW.setBounds(170, 5, 87, 15);
			contentPanel.add(lblPW);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("/");
			lblNewLabel_3.setBounds(164, 5, 28, 15);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnNewButton = new JButton("회원가입");
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						SignUpDlg signUpDlg = new SignUpDlg();
						signUpDlg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						signUpDlg.setModal(true);
						signUpDlg.setVisible(true);
					}
				});
				buttonPane.add(btnNewButton);
			}
			{
				JButton okButton = new JButton("로그인");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						DataDAO dao = new DataDAO();
						
						String id = textField.getText();
						String pw = new String(passwordField.getPassword());
						
						// 로그인 결과 체크
						int idcheck = dao.logInCheck(id, pw);
						
						 // 검사 로직 : 동일한 아이디와 패스워드인지 검색
						switch(idcheck){
							case 0 : 
								loginID = id;
								loginPW = pw;
								LoginDlg.this.dispose();
								break;
							default :
								JOptionPane.showMessageDialog(LoginDlg.this, "로그인 정보를 다시 확인해주세요.",
										"로그인 오류", JOptionPane.ERROR_MESSAGE);
								break;
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
						
						LoginDlg.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
