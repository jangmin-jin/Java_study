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
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FindPwDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldName;
	private JTextField textFieldJuminFront;
	private JPasswordField textFieldJuminBack;
	private JTextField textFieldID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FindPwDlg dialog = new FindPwDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FindPwDlg() {
		setTitle("비밀번호 찾기");
		setBounds(100, 100, 260, 200);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblId = new JLabel("아이디, 이름, 주민번호를 입력하세요");
			lblId.setBounds(12, 10, 215, 15);
			contentPanel.add(lblId);
		}
		{
			JLabel lblName = new JLabel("이름");
			lblName.setBounds(12, 66, 57, 15);
			contentPanel.add(lblName);
		}
		{
			textFieldName = new JTextField();
			textFieldName.setColumns(10);
			textFieldName.setBounds(68, 63, 145, 21);
			contentPanel.add(textFieldName);
		}
		{
			JLabel lblJumin = new JLabel("주민번호");
			lblJumin.setBounds(12, 94, 57, 15);
			contentPanel.add(lblJumin);
		}
		{
			textFieldJuminFront = new JTextField();
			textFieldJuminFront.setColumns(10);
			textFieldJuminFront.setBounds(68, 91, 68, 21);
			contentPanel.add(textFieldJuminFront);
		}
		{
			textFieldJuminBack = new JPasswordField();
			textFieldJuminBack.setBounds(145, 91, 68, 21);
			contentPanel.add(textFieldJuminBack);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("-");
			lblNewLabel_1.setBounds(137, 94, 30, 15);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblName = new JLabel("아이디");
			lblName.setBounds(12, 38, 57, 15);
			contentPanel.add(lblName);
		}
		{
			textFieldID = new JTextField();
			textFieldID.setColumns(10);
			textFieldID.setBounds(68, 35, 145, 21);
			contentPanel.add(textFieldID);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("찾기");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						// textfield에 입력한 값을을 담아줄 변수
						String id = textFieldID.getText().trim();
						String name = textFieldName.getText().trim();
						String juminFront = textFieldJuminFront.getText().trim();
						String juminBack = new String(textFieldJuminBack.getPassword()).trim();
						String jumin = juminFront + juminBack;
						
						DataDAO dao = new DataDAO();
						String findResult = dao.findPw(id, name, jumin);
						
						// 결과가 없으면 결과없음 출력
						if(findResult == "") {
							JOptionPane.showMessageDialog(FindPwDlg.this, "일치하는 정보가 없습니다.",
									"일치하는 정보 없음", JOptionPane.ERROR_MESSAGE);
							textFieldID.setText("");
							textFieldName.setText("");
							textFieldJuminFront.setText("");
							textFieldJuminBack.setText("");
						}else {
							JOptionPane.showMessageDialog(FindPwDlg.this, findResult,
									"비밀번호 찾기 결과", JOptionPane.QUESTION_MESSAGE);
							FindPwDlg.this.dispose();
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
						FindPwDlg.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
