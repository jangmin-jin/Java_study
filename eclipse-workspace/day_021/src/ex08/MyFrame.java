package ex08;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	public MyFrame() {
		
		// 닫기 버튼 기능
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1024, 768);
		this.setLocation(100, 100);
		this.setTitle("인스턴스화 시킴 is - a 의 관계");
	}
	
	// 직접 넣어줘도 되긴함, 인스턴스화 바로 해서 써먹는 식으로
//	public static void main(String[] args) {
//		MyFrame frame = new MyFrame();
//		frame.setVisible(true);
//	}
}