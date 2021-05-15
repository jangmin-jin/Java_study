package ex01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTextPane;

public class ColorPickerEx01 extends JFrame {

	private JPanel contentPane;
	private JPanel panel1;
	private JSlider sliderRed;
	private JSlider sliderGreen;
	private JSlider sliderBlue;
	private JTextPane textPaneRed;
	private JTextPane textPaneGreen;
	private JTextPane textPaneBlue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ColorPickerEx01 frame = new ColorPickerEx01();
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
	public ColorPickerEx01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "ColorPicker", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(6, 6, 556, 201);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// Red
		sliderRed = new JSlider();
		sliderRed.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (panel1 != null) {
					int red = sliderRed.getValue();
					int green = sliderGreen.getValue();
					int blue = sliderBlue.getValue();
					panel1.setBackground(new Color(red, green, blue)); 
					textPaneRed.setText(Integer.toString(red));
					textPaneGreen.setText(Integer.toString(green));
					textPaneBlue.setText(Integer.toString(blue));
				}
			}
		});
		sliderRed.setValue(0);
		sliderRed.setPaintTicks(true);
		sliderRed.setPaintLabels(true);
		sliderRed.setMajorTickSpacing(50);
		sliderRed.setMaximum(255);
		sliderRed.setBounds(95, 20, 352, 46);
		panel.add(sliderRed);
		
		JLabel lblRed = new JLabel("Red");
		lblRed.setForeground(Color.RED);
		lblRed.setBounds(23, 21, 60, 45);
		panel.add(lblRed);
		
		JLabel lblGreen = new JLabel("Green");
		lblGreen.setForeground(Color.GREEN);
		lblGreen.setBounds(23, 76, 74, 46);
		panel.add(lblGreen);
		
		// Green
		sliderGreen = new JSlider();
		sliderGreen.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (panel1 != null) {
					int red = sliderRed.getValue();
					int green = sliderGreen.getValue();
					int blue = sliderBlue.getValue();
					panel1.setBackground(new Color(red, green, blue)); 
					textPaneRed.setText(Integer.toString(red));
					textPaneGreen.setText(Integer.toString(green));
					textPaneBlue.setText(Integer.toString(blue));
				}
			}
		});
		sliderGreen.setValue(0);
		sliderGreen.setPaintTicks(true);
		sliderGreen.setPaintLabels(true);
		sliderGreen.setMajorTickSpacing(50);
		sliderGreen.setMaximum(255);
		sliderGreen.setBounds(95, 76, 352, 46);
		panel.add(sliderGreen);
		
		JLabel lblBlue = new JLabel("Blue");
		lblBlue.setForeground(Color.BLUE);
		lblBlue.setBounds(23, 134, 74, 46);
		panel.add(lblBlue);
		
		// Blue
		sliderBlue = new JSlider();
		sliderBlue.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (panel1 != null) {
					int red = sliderRed.getValue();
					int green = sliderGreen.getValue();
					int blue = sliderBlue.getValue();
					panel1.setBackground(new Color(red, green, blue)); 
					textPaneRed.setText(Integer.toString(red));
					textPaneGreen.setText(Integer.toString(green));
					textPaneBlue.setText(Integer.toString(blue));
				}
			}
		});
		sliderBlue.setValue(0);
		sliderBlue.setPaintTicks(true);
		sliderBlue.setPaintLabels(true);
		sliderBlue.setMajorTickSpacing(50);
		sliderBlue.setMaximum(255);
		sliderBlue.setBounds(95, 134, 352, 46);
		panel.add(sliderBlue);
		
		textPaneRed = new JTextPane();
		textPaneRed.setBounds(459, 20, 74, 46);
		panel.add(textPaneRed);
		
		textPaneGreen = new JTextPane();
		textPaneGreen.setBounds(459, 76, 74, 46);
		panel.add(textPaneGreen);
		
		textPaneBlue = new JTextPane();
		textPaneBlue.setBounds(459, 134, 74, 46);
		panel.add(textPaneBlue);
		
		panel1 = new JPanel();
		panel1.setBackground(new Color(0, 0, 0));
		panel1.setBounds(6, 219, 556, 75);
		contentPane.add(panel1);
		
		JButton btn = new JButton("초기화");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sliderRed.setValue(0);
				sliderGreen.setValue(0);
				sliderBlue.setValue(0);
				panel1.setBackground(new Color(0, 0, 0));
				textPaneRed.setText(Integer.toString(0));
				textPaneGreen.setText(Integer.toString(0));
				textPaneBlue.setText(Integer.toString(0));
			}
		});
		btn.setBounds(6, 304, 556, 49);
		contentPane.add(btn);
	}
}
