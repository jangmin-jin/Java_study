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

public class IdCheckDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	public String idCheckResult = "";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IdCheckDlg dialog = new IdCheckDlg();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IdCheckDlg() {
		setTitle("아이디 중복확인");
		setBounds(100, 100, 220, 150);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("아이디 입력");
			lblNewLabel.setBounds(12, 10, 159, 15);
			contentPanel.add(lblNewLabel);
		}
		{
			textField = new JTextField();
			textField.setBounds(12, 35, 159, 21);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("확인");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						DataDAO dao = new DataDAO();
						String fieldId = textField.getText();
						
						// 아이디에는 공백이 포함될 수 없습니다.
						if(fieldId.contains(" ")) {
							JOptionPane.showMessageDialog(IdCheckDlg.this, "공백은 사용할 수 없습니다.", 
									"아이디 중복확인", JOptionPane.ERROR_MESSAGE);
							// 아이디는 공백이 될 수 없습니다.
						}else if(fieldId.equals("")) {
							JOptionPane.showMessageDialog(IdCheckDlg.this, "사용할 아이디를 입력하세요.", 
									"아이디 중복확인", JOptionPane.ERROR_MESSAGE);
						}else {
							// 정상인 경우
							Boolean idCheck = dao.idCheck(fieldId);
							
							// 검색결과가 이미 있는 경우 = 중복되는 아이디
							if(idCheck != true) {
								JOptionPane.showMessageDialog(IdCheckDlg.this, "중복되는 아이디 입니다.", 
										"아이디 중복확인", JOptionPane.ERROR_MESSAGE);
								textField.setText("");
								// 검색결과가 없는 경우 = 새로운 아이디 (가입가능)
							}else {
								idCheckResult = fieldId;
								JOptionPane.showMessageDialog(IdCheckDlg.this, "사용할 수 있는 아이디 입니다.", 
										"아이디 중복확인", JOptionPane.PLAIN_MESSAGE);
								IdCheckDlg.this.dispose();
							}
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
						IdCheckDlg.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
