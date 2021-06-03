package project2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignUpDlg extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldPW;
	private JTextField textFieldName;
	private JTextField textFieldJuminFront;
	private JTextField textFieldJuminBack;
	private JTextField textFieldEmailFront;
	private JTextField textFieldEmailBack;
	private JTextField textFieldZipcode;
	private JTextField textFieldDetailAddress;
	private JTextField textFieldExtraAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpDlg frame = new SignUpDlg();
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
	public SignUpDlg() {
		setTitle("회원가입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 505);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(73, 21, 116, 21);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);
		
		JLabel LabelID = new JLabel("아이디");
		LabelID.setBounds(12, 27, 57, 15);
		contentPane.add(LabelID);
		
		JLabel LabelPW = new JLabel("비밀번호");
		LabelPW.setBounds(12, 57, 57, 15);
		contentPane.add(LabelPW);
		
		textFieldPW = new JTextField();
		textFieldPW.setColumns(10);
		textFieldPW.setBounds(73, 51, 116, 21);
		contentPane.add(textFieldPW);
		
		JLabel LabelName = new JLabel("이름");
		LabelName.setBounds(12, 88, 57, 15);
		contentPane.add(LabelName);
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(73, 82, 116, 21);
		contentPane.add(textFieldName);
		
		JButton btn1 = new JButton("중복확인");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String checkId = null;
				checkId = JOptionPane.showInputDialog(SignUpDlg.this, "사용할 아이디 입력하세요",
						"아이디 중복검사", JOptionPane.QUESTION_MESSAGE);
			}
		});
		btn1.setBounds(201, 20, 97, 23);
		contentPane.add(btn1);
		
		JLabel LabelSex_1_1_1 = new JLabel("성별");
		LabelSex_1_1_1.setBounds(12, 123, 57, 15);
		contentPane.add(LabelSex_1_1_1);
		
		JRadioButton rdbtnWoman = new JRadioButton("여성");
		rdbtnWoman.setSelected(true);
		rdbtnWoman.setBounds(73, 119, 57, 23);
		contentPane.add(rdbtnWoman);
		
		JRadioButton rdbtnMan = new JRadioButton("남성");
		rdbtnMan.setBounds(132, 119, 57, 23);
		contentPane.add(rdbtnMan);
		
		JLabel LabelJumin = new JLabel("주민번호");
		LabelJumin.setBounds(12, 154, 57, 15);
		contentPane.add(LabelJumin);
		
		textFieldJuminFront = new JTextField();
		textFieldJuminFront.setColumns(10);
		textFieldJuminFront.setBounds(73, 148, 70, 21);
		contentPane.add(textFieldJuminFront);
		
		JLabel LabelJuminSplit = new JLabel("-");
		LabelJuminSplit.setBounds(144, 154, 57, 15);
		contentPane.add(LabelJuminSplit);
		
		textFieldJuminBack = new JTextField();
		textFieldJuminBack.setColumns(10);
		textFieldJuminBack.setBounds(155, 148, 70, 21);
		contentPane.add(textFieldJuminBack);
		
		JLabel LabelEmail = new JLabel("이메일");
		LabelEmail.setBounds(12, 185, 57, 15);
		contentPane.add(LabelEmail);
		
		textFieldEmailFront = new JTextField();
		textFieldEmailFront.setColumns(10);
		textFieldEmailFront.setBounds(73, 179, 105, 21);
		contentPane.add(textFieldEmailFront);
		
		JLabel LabelEmailSplit = new JLabel("@");
		LabelEmailSplit.setBounds(182, 185, 57, 15);
		contentPane.add(LabelEmailSplit);
		
		textFieldEmailBack = new JTextField();
		textFieldEmailBack.setColumns(10);
		textFieldEmailBack.setBounds(201, 179, 105, 21);
		contentPane.add(textFieldEmailBack);
		
		JComboBox comboEmailAddress = new JComboBox();
		comboEmailAddress.setModel(new DefaultComboBoxModel(new String[] {"직접입력", "naver.com", "gmail.com", "daum.net"}));
		comboEmailAddress.setBounds(318, 179, 105, 21);
		contentPane.add(comboEmailAddress);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(6, 210, 423, 212);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel LabelAddress = new JLabel("주소");
		LabelAddress.setBounds(6, 21, 31, 15);
		panel.add(LabelAddress);
		
		JButton btn1_1 = new JButton("우편번호 검색");
		btn1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ZipcodeSearchDlg zipcodeDlg = new ZipcodeSearchDlg();
				zipcodeDlg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				zipcodeDlg.setModal(true);
				zipcodeDlg.setVisible(true);
				
			}
		});
		btn1_1.setBounds(67, 17, 116, 23);
		panel.add(btn1_1);
		
		JLabel LabelZipcode = new JLabel("우편번호");
		LabelZipcode.setBounds(6, 52, 57, 15);
		panel.add(LabelZipcode);
		
		textFieldZipcode = new JTextField();
		textFieldZipcode.setBounds(67, 46, 105, 21);
		panel.add(textFieldZipcode);
		textFieldZipcode.setEditable(false);
		textFieldZipcode.setColumns(10);
		
		JLabel LabelAddress2 = new JLabel("상세주소");
		LabelAddress2.setBounds(6, 77, 57, 15);
		panel.add(LabelAddress2);
		
		textFieldDetailAddress = new JTextField();
		textFieldDetailAddress.setBounds(6, 92, 411, 62);
		panel.add(textFieldDetailAddress);
		textFieldDetailAddress.setEditable(false);
		textFieldDetailAddress.setColumns(10);
		
		JLabel LabelAddress3 = new JLabel("나머지주소");
		LabelAddress3.setBounds(6, 164, 70, 15);
		panel.add(LabelAddress3);
		
		textFieldExtraAddress = new JTextField();
		textFieldExtraAddress.setBounds(6, 180, 411, 21);
		panel.add(textFieldExtraAddress);
		textFieldExtraAddress.setColumns(10);
		
		JButton btn1_2 = new JButton("가입");
		btn1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 주민번호 체크 로직이 들어가야함
				// 필수 요소들이 없으면 걸러내야함.
				
				SignUpDlg.this.dispose();
			}
		});
		btn1_2.setBounds(291, 430, 60, 30);
		contentPane.add(btn1_2);
		
		JButton btn1_2_1 = new JButton("취소");
		btn1_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUpDlg.this.dispose();
			}
		});
		btn1_2_1.setBounds(363, 430, 60, 30);
		contentPane.add(btn1_2_1);
	}
}
