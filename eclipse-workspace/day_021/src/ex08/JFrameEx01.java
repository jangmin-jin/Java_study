package ex08;

import javax.swing.JFrame;

public class JFrameEx01 {

	public static void main(String[] args) {
		
		// has - a, is - a 기법을 다 쓴다
		// 창 하나 만들렵니다.
		// JFrame frame = new JFrame( "김제목" );
		JFrame frame = new JFrame();
		frame.setTitle("박제목");
		System.out.println( frame.getTitle() ); // 제목출력
		
		// frame.setSize(1024, 768);
		// frame.setLocation(100, 100);
		frame.setBounds(100, 100, 1024, 768);
		
		frame.setVisible(true);
	}
}