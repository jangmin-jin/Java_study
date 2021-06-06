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

public class FindIdDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldName;
	private JTextField textFieldJuminFront;
	private JPasswordField textFieldJuminBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FindIdDlg dialog = new FindIdDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FindIdDlg() {
		setTitle("아이디 찾기");
		setBounds(100, 100, 260, 175);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblName = new JLabel("이름");
			lblName.setBounds(12, 42, 57, 15);
			contentPanel.add(lblName);
		}
		{
			JLabel lblJumin = new JLabel("주민번호");
			lblJumin.setBounds(12, 70, 57, 15);
			contentPanel.add(lblJumin);
		}
		
		textFieldName = new JTextField();
		textFieldName.setBounds(68, 39, 145, 21);
		contentPanel.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldJuminFront = new JTextField();
		textFieldJuminFront.setColumns(10);
		textFieldJuminFront.setBounds(68, 67, 68, 21);
		contentPanel.add(textFieldJuminFront);
		
		JLabel lblNewLabel = new JLabel("이름과 주민번호를 입력하세요.");
		lblNewLabel.setBounds(12, 10, 215, 15);
		contentPanel.add(lblNewLabel);
		{
			JLabel lblNewLabel_1 = new JLabel("-");
			lblNewLabel_1.setBounds(137, 70, 30, 15);
			contentPanel.add(lblNewLabel_1);
		}
		
		textFieldJuminBack = new JPasswordField();
		textFieldJuminBack.setBounds(145, 67, 68, 21);
		contentPanel.add(textFieldJuminBack);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("찾기");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						String name = textFieldName.getText();
						String juminFront = textFieldJuminFront.getText();
						String juminBack = new String(textFieldJuminBack.getPassword());
						String jumin = juminFront + juminBack;
						
						DataDAO dao = new DataDAO();
						String findResult = dao.findId(name, jumin);
						
						if(findResult == "") {
							JOptionPane.showMessageDialog(FindIdDlg.this, "일치하는 정보가 없습니다.",
									"가입 정보 없음", JOptionPane.ERROR_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(FindIdDlg.this, findResult.split("/"),
									"가입된 아이디", JOptionPane.QUESTION_MESSAGE);
						}
						
						FindIdDlg.this.dispose();
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
						FindIdDlg.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
