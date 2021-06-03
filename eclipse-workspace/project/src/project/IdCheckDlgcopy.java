package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IdCheckDlgcopy extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldId;
	
	// return data set -> SignUpDlg
	public String idCheckResult = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IdCheckDlgcopy frame = new IdCheckDlgcopy();
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
	public IdCheckDlgcopy() {
		setTitle("아이디 중복확인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 150);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl = new JLabel("아이디를 입력하세요");
		lbl.setBounds(12, 10, 189, 15);
		contentPane.add(lbl);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(12, 35, 260, 21);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		
		JButton btnConfirm = new JButton("확인");
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DataDAO dao = new DataDAO();
				String fieldId = textFieldId.getText();
//				System.out.println(id);
				Boolean idCheck = dao.idCheck(fieldId);
				
				System.out.println("idcheckdlg : " + fieldId);
				System.out.println("idcheckdlg : " + idCheck);
				
				if(idCheck != true) {
					JOptionPane.showMessageDialog(IdCheckDlgcopy.this, "중복되는 아이디입니다 다시입력하세요!",
							"아이디 중복 확인", JOptionPane.ERROR_MESSAGE);
					textFieldId.setText("");
				}else {
					idCheckResult = fieldId;
					System.out.println("idcheckdlg : "+ idCheckResult);
				}
				
				IdCheckDlgcopy.this.dispose();
			}
		});
		btnConfirm.setBounds(137, 78, 65, 23);
		contentPane.add(btnConfirm);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IdCheckDlgcopy.this.dispose();
			}
		});
		btnCancel.setBounds(207, 78, 65, 23);
		contentPane.add(btnCancel);
	}
}
