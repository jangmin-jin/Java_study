package ex03;

public class MainEx {

	public static void main(String[] args) {
		System.out.println( "시작" );
		
		Go g = new Go();
		Come c = new Come();

		// 인터페이스를 이용한 멀티 스레드
		Thread t1 = new Thread(g);
		Thread t2 = new Thread(c);
		
		t1.start();
		t2.start();
	}
}