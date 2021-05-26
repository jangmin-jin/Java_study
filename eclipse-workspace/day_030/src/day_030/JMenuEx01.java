package day_030;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class JMenuEx01 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JMenuEx01 frame = new JMenuEx01();
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
	public JMenuEx01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 363);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		/*
		 * 
		 */
		JMenu mn1 = new JMenu("menu1");
		menuBar.add(mn1);
		
		JMenuItem mntm1 = new JMenuItem("item1");
		mntm1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("메뉴 1 클릭");
			}
		});
		mn1.add(mntm1);
		
		JMenuItem mntm2 = new JMenuItem("item2");
		mntm2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("메뉴 2 클릭");
			}
		});
		mn1.add(mntm2);
		
		/*
		 * 
		 */
		JMenu mn2 = new JMenu("menu2");
		menuBar.add(mn2);
		
		JMenuItem mntm3 = new JMenuItem("item3");
		mn2.add(mntm3);
		
		JMenuItem mntm4 = new JMenuItem("item4");
		mn2.add(mntm4);
		
		JMenu mn3 = new JMenu("File");
		menuBar.add(mn3);
		
		JMenuItem mntmOpen = new JMenuItem("open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// open / save
				JFileChooser fileChooser = new JFileChooser("c:\\");
				
				// 필터
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Java Source", "java");
				fileChooser.setFileFilter(filter);
				
				int result = fileChooser.showOpenDialog(JMenuEx01.this);
				if(result == JFileChooser.APPROVE_OPTION) {
					System.out.println("확인욤");
					
					//  정보 / 이름 / 경로
					File seletedFile = fileChooser.getSelectedFile();
					System.out.println(seletedFile.getName());
					System.out.println(seletedFile.getAbsolutePath());
					
					BufferedReader br = null;
//					textArea.setText("");
					
					try {
						br = new BufferedReader(new FileReader(seletedFile));
						String data = null;
						while( (data = br.readLine()) != null ) {
//							textArea.append(data + "\n");
						}
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					} finally {
						if(br != null) try {br.close();} catch(IOException e1) {}
					}
				} else {
					System.out.println("취소여");
				}
			}
		});
		mn3.add(mntmOpen);
		
		// 저장용 츄져 호출
		JMenuItem mntmSave = new JMenuItem("save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser = new JFileChooser("c:\\");
				int result = fileChooser.showSaveDialog(JMenuEx01.this);
				
				BufferedWriter bw = null;

				if(result == JFileChooser.APPROVE_OPTION) {
					
					try {
						// 입력한 파일이름으로 저장
						String name = fileChooser.getSelectedFile().getAbsolutePath();
						bw = new BufferedWriter(new FileWriter(name));
						// String data = textArea.getText();
						
						// bw.write(data);
						
					} catch (IOException e1) {
						e1.printStackTrace();
					} finally {
						if(bw != null) try {bw.close();} catch(IOException e1) {}
					}
					
				} else {
					
				}
			}
		});
		mn3.add(mntmSave);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
