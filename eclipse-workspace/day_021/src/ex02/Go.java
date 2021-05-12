package ex02;

public class Go extends Thread {
	// 일을 시킬때는 특정 메서드 사용
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			System.out.println( "Go : " + i );
		}
	}
}