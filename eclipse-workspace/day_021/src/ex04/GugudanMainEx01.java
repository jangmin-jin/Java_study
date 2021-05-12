package ex04;

public class GugudanMainEx01 {

	public static void main(String[] args) {
		// 클래스
		Gugudan g1 = new Gugudan(2);
		Gugudan g2 = new Gugudan(5);
		
		g1.setName("2단 스레드!");
		g2.setName("5단 스레드!");
		
		g1.start();
		g2.start();
		
		// 인터페이스
		InterGugudan ig1 = new InterGugudan(3);
		InterGugudan ig2 = new InterGugudan(6);
		
		Thread t1 = new Thread(ig1);
		Thread t2 = new Thread(ig2);
		
		t1.start();
		t2.start();
	}
}