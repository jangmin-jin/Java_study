package com.exam.member01;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MemberModifyDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	MemberTO to = new MemberTO();
	private JTextField textField21;
	private JTextField textField31;
	private JTextField textField32;
	private JTextField textField41;
	private JTextField textField51;
	private JTextField textField52;
	private JTextField textField53;
	private JTextField textField54;
	private JTextField textField61;
	private JTextField textField71;
	private JTextArea textArea;
	
	public int seq;
	
	/**
	 * Create the dialog.
	 */
	// 생성자 오버로딩
	public MemberModifyDialog(int seq) {
		this();
		//System.out.println(seq);
		this.seq = seq;
		
		MemberTO to = new MemberTO();
		to.setSeq(seq);
		
		MemberDAO dao = new MemberDAO();
		to = dao.viewMember(to);
		
		textField21.setText(to.getName());
		
		String phones[] = to.getPhone().split("-");
		textField31.setText(phones[1]);
		textField32.setText(phones[2]);
		
		textField41.setText(to.getEmail());
		
		String zipcodes[] = to.getZipcode().split("-");
		textField51.setText(zipcodes[0]);
		textField52.setText(zipcodes[1]);
		
		textField53.setText(to.getAddress1());
		textField54.setText(to.getAddress2());
		
		textField61.setText(to.getEtc1());
		textField71.setText(to.getEtc2());
		
		textArea.setText(to.getMemo());
	}
	
	public MemberModifyDialog() {
		setResizable(false);
		setBounds(100, 100, 454, 537);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lbl1 = new JLabel("소속 그룹");
		lbl1.setBounds(12, 14, 57, 15);
		contentPanel.add(lbl1);
		
		JComboBox comboBox1 = new JComboBox();
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {"기본"}));
		comboBox1.setBounds(81, 10, 186, 23);
		contentPanel.add(comboBox1);
		
		JLabel lbl2 = new JLabel("이       름");
		lbl2.setBounds(12, 49, 57, 15);
		contentPanel.add(lbl2);
		
		textField21 = new JTextField();
		textField21.setBounds(81, 46, 345, 21);
		contentPanel.add(textField21);
		textField21.setColumns(10);
		
		JLabel lbl3 = new JLabel("전화 번호");
		lbl3.setBounds(12, 84, 57, 15);
		contentPanel.add(lbl3);
		
		JComboBox comboBox2 = new JComboBox();
		comboBox2.setModel(new DefaultComboBoxModel(new String[] {"010"}));
		comboBox2.setBounds(81, 80, 57, 23);
		contentPanel.add(comboBox2);
		
		textField31 = new JTextField();
		textField31.setBounds(151, 81, 116, 21);
		contentPanel.add(textField31);
		textField31.setColumns(10);
		
		textField32 = new JTextField();
		textField32.setBounds(279, 81, 116, 21);
		contentPanel.add(textField32);
		textField32.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("이  메  일");
		lblNewLabel.setBounds(12, 119, 57, 15);
		contentPanel.add(lblNewLabel);
		
		textField41 = new JTextField();
		textField41.setBounds(81, 116, 345, 21);
		contentPanel.add(textField41);
		textField41.setColumns(10);
		
		JLabel lbl4 = new JLabel("주      소");
		lbl4.setBounds(12, 153, 57, 15);
		contentPanel.add(lbl4);
		
		textField51 = new JTextField();
		textField51.setBounds(81, 150, 95, 21);
		contentPanel.add(textField51);
		textField51.setColumns(10);
		
		textField52 = new JTextField();
		textField52.setBounds(188, 150, 95, 21);
		contentPanel.add(textField52);
		textField52.setColumns(10);
		
		JButton btn = new JButton("우편번호검색");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btn.setBounds(295, 149, 116, 23);
		contentPanel.add(btn);
		
		textField53 = new JTextField();
		textField53.setBounds(81, 184, 345, 21);
		contentPanel.add(textField53);
		textField53.setColumns(10);
		textField53.setText(to.getAddress1());
		
		textField54 = new JTextField();
		textField54.setBounds(81, 218, 345, 21);
		contentPanel.add(textField54);
		textField54.setColumns(10);
		textField54.setText(to.getAddress2());
		
		JLabel lbl5 = new JLabel("기  타  1");
		lbl5.setBounds(12, 255, 57, 15);
		contentPanel.add(lbl5);
		
		textField61 = new JTextField();
		textField61.setBounds(81, 252, 345, 21);
		contentPanel.add(textField61);
		textField61.setColumns(10);
		textField61.setText(to.getEtc1());
		
		JLabel lbl6 = new JLabel("기  타  2");
		lbl6.setBounds(12, 289, 57, 15);
		contentPanel.add(lbl6);
		
		textField71 = new JTextField();
		textField71.setBounds(81, 286, 345, 21);
		contentPanel.add(textField71);
		textField71.setColumns(10);
		textField71.setText(to.getEtc2());
		
		JLabel lbl10 = new JLabel("메      모");
		lbl10.setBounds(12, 320, 57, 15);
		contentPanel.add(lbl10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 345, 414, 110);
		contentPanel.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setText(to.getMemo());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("수정");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String groupName = (String)comboBox1.getSelectedItem();
						String name = textField21.getText();
						String phone = (String)comboBox2.getSelectedItem() + "-" + textField31.getText() + "-" + textField32.getText();
						String email = textField41.getText();
						String zipcode = textField51.getText() + "-" + textField52.getText();
						String address1 = textField53.getText();
						String address2 = textField54.getText();
						String etc1 = textField61.getText();
						String etc2 = textField71.getText();
						String memo = textArea.getText();
						
//						System.out.println(groupName);
						
						// 입력값 검사
						if(name.equals("")) {
							JOptionPane.showMessageDialog(MemberModifyDialog.this, "필수 항목을 입력해야합니다.", "에러", JOptionPane.WARNING_MESSAGE);
							
						}else {
							MemberTO to = new MemberTO();
							
							// 그룹 처리 : 이름 ->  번호
							to.setSeq(seq);
							to.setName(name);
							to.setPhone(phone);
							to.setEmail(email);
							to.setZipcode(zipcode);
							to.setAddress1(address1);
							to.setAddress2(address2);
							to.setEtc1(etc1);
							to.setEtc2(etc2);
							to.setMemo(memo);

							MemberDAO dao = new MemberDAO();
							if(dao.modifyMember(to)){
								MemberModifyDialog.this.dispose();
							} else {
								JOptionPane.showMessageDialog(MemberModifyDialog.this, "입력 에러.", "에러", JOptionPane.WARNING_MESSAGE);
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
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MemberModifyDialog.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
