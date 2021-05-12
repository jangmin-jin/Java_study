package ex08;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JFrameEx03 extends JFrame {
	// Pane = Panel ( 다른 위젯을 올릴 수 있는 영역 : 집합 영역 )
	private JPanel contentPane;
	
	public JFrameEx03() {
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 1024, 768 );
		
		contentPane = new JPanel();
		// Panel 띄어주는데 눈에 안띄니까 여러가지 해줌
		contentPane.setBorder( new EmptyBorder(5, 5, 5, 5) );
		contentPane.setBackground(Color.GRAY);
		
		// layout(좌표계 : null(absolute) layout) 위젯 배치에 대한 것
		contentPane.setLayout( null );
		
		// widget 위젯
		JButton btn = new JButton( "난 버튼!" );
		btn.setBounds( 10, 10, 100, 25 );
		contentPane.add( btn );
		
		setContentPane( contentPane );
	}
	
	public static void main(String[] args) {
		
		// 스레드 형식으로 처리
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				try {
				JFrameEx03 frame = new JFrameEx03();
				frame.setVisible(true);
				}catch(Exception e) {
					System.out.println( "에러 : " + e.getMessage() );
				}
			}
		});

	}
}