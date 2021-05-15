package ex01;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class JFrameEx03 extends JFrame {

	private JPanel contentPane;
	private JSpinner spinner;
	private JSpinner spinner_1;
	private JSpinner spinner_1_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameEx03 frame = new JFrameEx03();
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
	public JFrameEx03() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 347, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				System.out.println((Integer)spinner.getValue());
			}
		});
		SpinnerNumberModel model = (new SpinnerNumberModel(50, 0, 100, 10));
		spinner.setModel(model);
//		spinner.setModel(new SpinnerNumberModel(50, 0, 100, 10));
		spinner.setBounds(12, 36, 174, 23);
		contentPane.add(spinner);
		
		spinner_1 = new JSpinner();
		String[] items= new String[] {"사과","참외","수박","앵두"};
		SpinnerListModel slm = new SpinnerListModel(items);
		spinner_1.setModel(slm);
//		spinner_1.setModel(new SpinnerListModel(new String[] {"떠들썩", "뚸들석", "들썩", "듈썩", "떠듈석"}));
		spinner_1.setBounds(12, 69, 174, 23);
		contentPane.add(spinner_1);
		
		spinner_1_1 = new JSpinner();
		spinner_1_1.setModel(new SpinnerDateModel(new Date(1620918000000L), new Date(1620572400000L), new Date(1621436400000L), Calendar.HOUR));
		spinner_1_1.setBounds(12, 102, 174, 23);
		contentPane.add(spinner_1_1);
		
		JButton btn = new JButton("New button");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println((Integer)spinner.getValue());
				System.out.println(spinner_1.getValue());
			}
		});
		btn.setBounds(204, 16, 97, 23);
		contentPane.add(btn);
	}
}
