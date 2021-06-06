package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class ZipcodeSearchDlg extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldDlg;
	private JTable table;

	// return data set -> main
	public String zipcode1 = "";
	public String zipcode2 = "";
	public String address = "";
	
	/**
	 * Create the dialog.
	 */
	public ZipcodeSearchDlg() {
		setTitle("우편번호 검색");
		setBounds(100, 100, 500, 600);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textFieldDlg = new JTextField();
			textFieldDlg.setBounds(12, 10, 316, 21);
			contentPanel.add(textFieldDlg);
			textFieldDlg.setColumns(10);
		}
		{
			JButton btn1 = new JButton("검색");
			btn1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String strDong = textFieldDlg.getText();
					System.out.println("집코드 검색기 : " + strDong);
					
					// 입력조건 : 2글자 이상 입력
					// 예외처리
					if(strDong.length() < 2) {
						JOptionPane.showMessageDialog(ZipcodeSearchDlg.this, "두글자 이상 입력해야합니다.",
								"에러메시지", JOptionPane.WARNING_MESSAGE);
					} else {
						// table에 주소 검색 결과 표시
						table.setModel( new CustomZipcodeModel(strDong) );
					}
				}
			});
			btn1.setBounds(340, 9, 132, 23);
			contentPanel.add(btn1);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 41, 460, 477);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"\uC6B0\uD3B8\uBC88\uD638", "\uC2DC\uB3C4", "\uAD6C\uAD70", "\uB3D9", "\uB9AC", "\uBC88\uC9C0"
			}
		));
		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("선택");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						// ***-*** 형식의 zipcode를 -를 기준으로 찢어서 넣어준다.
						String zipcode[] = ((String)table.getValueAt(table.getSelectedRow(), 0)).split("-");
						zipcode1 = zipcode[0];
						zipcode2 = zipcode[1];
						
						// 주소는 다 합쳐준다.
						address = String.format("%s %s %s %s", 
								(String) table.getValueAt(table.getSelectedRow(), 1),
								(String) table.getValueAt(table.getSelectedRow(), 2),
								(String) table.getValueAt(table.getSelectedRow(), 3),
								(String) table.getValueAt(table.getSelectedRow(), 4));
						
						ZipcodeSearchDlg.this.dispose();
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
						ZipcodeSearchDlg.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}