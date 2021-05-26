package day_030;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class JFileChooserEx01 extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFileChooserEx01 frame = new JFileChooserEx01();
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
	public JFileChooserEx01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn = new JButton("자바파일 열기");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// open / save
				JFileChooser fileChooser = new JFileChooser("c:\\");
				
				// 필터
				// 자바라는 확장자를 가진 파일만을 검색할 수 있게 한다.
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Java Source", "java");
				fileChooser.setFileFilter(filter);
				
				int result = fileChooser.showOpenDialog(JFileChooserEx01.this);
				if(result == JFileChooser.APPROVE_OPTION) {
					System.out.println("확인욤");
					
					//  정보 / 이름 / 경로
					File seletedFile = fileChooser.getSelectedFile();
					System.out.println(seletedFile.getName());
					System.out.println(seletedFile.getAbsolutePath());
					
					BufferedReader br = null;
					textArea.setText("");
					
					try {
						br = new BufferedReader(new FileReader(seletedFile));
						String data = null;
						while( (data = br.readLine()) != null ) {
							textArea.append(data + "\n");
						}
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					} finally {
						if(br != null) try {br.close();} catch(IOException e1) {}
					}
					
				// } else if(result == JFileChooser.CANCEL_OPTION) {
				} else {
					System.out.println("취소여");
				}
			}
		});
		btn.setBounds(12, 10, 145, 23);
		contentPane.add(btn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 43, 984, 676);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JButton btn2 = new JButton("저장");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 저장용 츄져를 열겠다. 
				// new JFileChooser();안에 인자가 없으면 my document 위치가 디폴트.
				// JFileChooser fileChooser = new JFileChooser();
				
				JFileChooser fileChooser = new JFileChooser("c:\\");
				int result = fileChooser.showSaveDialog(JFileChooserEx01.this);
				
				BufferedWriter bw = null;

				if(result == JFileChooser.APPROVE_OPTION) {
					
					try {
						// 입력한 파일이름으로 저장
						String pathAndName = fileChooser.getSelectedFile().getAbsolutePath();
						bw = new BufferedWriter(new FileWriter(pathAndName));
						String data = textArea.getText();
						
						bw.write(data);
						
					} catch (IOException e1) {
						e1.printStackTrace();
					} finally {
						if(bw != null) try {bw.close();} catch(IOException e1) {}
					}
					
				} else {
					
				}
			}
		});
		btn2.setBounds(169, 10, 145, 23);
		contentPane.add(btn2);
	}
}
