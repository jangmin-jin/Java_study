package ex01;

public class MainEx {

	public static void main(String[] args) {
		// 싱글스레드
		System.out.println( "시작" );
		
		// 절차적 수행
		Go g = new Go();
		Come c = new Come();
		
		g.run();
		c.run();
		
		System.out.println( "끝" );
	}
}