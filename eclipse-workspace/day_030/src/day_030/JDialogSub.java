package day_030;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JDialogSub extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private String data;
	
	// getter/ setter 를이용한 데이터 주고받기
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	// 생성자를 통한 데이터 주고받기
	public JDialogSub(String data) {
		this();
		this.data = data;
	}
	
	/**
	 * Create the dialog.
	 */
	public JDialogSub() {
//		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						System.out.println(JDialogSub.this.getData());
						JDialogSub.this.setData("자식이 보낸데이터");
						// 닫기
						JDialogSub.this.dispose();
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
						
						// 닫기
						JDialogSub.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
