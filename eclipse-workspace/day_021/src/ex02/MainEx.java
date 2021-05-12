package ex02;

public class MainEx {

	public static void main(String[] args) {

		System.out.println( "시작" );
				
		Go g = new Go();
		Come c = new Come();

		// 병렬적 수행
		// 스레드를 실행하는 메서드
		g.start();
		c.start();
		
		// g.run();
		// c.run();
				
		System.out.println( "끝" );
	}
}