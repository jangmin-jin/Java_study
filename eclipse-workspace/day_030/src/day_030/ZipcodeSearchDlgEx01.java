package day_030;

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

public class ZipcodeSearchDlgEx01 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldDlg;
	private JTable table;
	private String address;
	private String zipcode1;
	private String zipcode2;
	private String etcAddress;
	
	public String getZipcode1() {
		return zipcode1;
	}
	
	public String getZipcode2() {
		return zipcode2;
	}
	
	public String getEtcAddress() {
		return etcAddress;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public void setZipcode1(String zipcode1) {
		this.zipcode1 = zipcode1;
	}
	
	public void setZipcode2(String zipcode2) {
		this.zipcode2 = zipcode2;
	}
	
	public void setEtcAddress(String etcAddress) {
		this.etcAddress = etcAddress;
	}
	
	public ZipcodeSearchDlgEx01(String address) {
		this();
		this.address = address;
	}

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public ZipcodeSearchDlgEx01() {
		setBounds(200, 200, 500, 600);
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
					
					// 조건 : 2글자 미만으로 입력되면 알림창 띄움
					if(textFieldDlg.getText().split("").length <2) {
						JOptionPane.showMessageDialog(ZipcodeSearchDlgEx01.this, "두글자 이상 입력하세요", "우편번호 검사 오류", JOptionPane.INFORMATION_MESSAGE);
					} else {
						// 입력한 데이터를 이용하여 table 출력
						String address = textFieldDlg.getText();
						table.setModel(new CustomTableModelZipcode(address));
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
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						// 입력한 주소를 기반으로 해당 주소 검색
						String address = textFieldDlg.getText();
						int col = table.getSelectedRow();
						
						// 해당 주소를 추출
						ZipcodeSearchLogic zipcodeSearchLogic = new ZipcodeSearchLogic(address, col);
						String SearchAddress = zipcodeSearchLogic.searchZipcode();
						
						// 한줄로 되어있는 데이터를 각 텍스트필드에 맞게 재조합
						String[] Searchresult = SearchAddress.split(",");
						String addressResult = "";
						String[] zipcodeSplit = Searchresult[0].split("-");
						for(int i=1; i<Searchresult.length; i++) {
							addressResult += Searchresult[i] + " ";
						}
						
						// 해당 값을 부모에게 전달
						ZipcodeSearchDlgEx01.this.setZipcode1(zipcodeSplit[0]);
						ZipcodeSearchDlgEx01.this.setZipcode2(zipcodeSplit[1]);
						ZipcodeSearchDlgEx01.this.setEtcAddress(addressResult);
						
						// 창 닫기
						ZipcodeSearchDlgEx01.this.dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						ZipcodeSearchDlgEx01.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
