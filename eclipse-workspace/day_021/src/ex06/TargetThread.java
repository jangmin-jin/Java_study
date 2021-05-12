package ex06;

public class TargetThread extends Thread {
	// 실행하기 위한 스레드
	@Override
	public void run() {
		try {
			for(long i=0; i<1_000_000_000; i++) { }
			
			Thread.sleep(1500);

			for(long i=0; i<1_000_000_000; i++) { }
		} catch (InterruptedException e) {
			System.out.println( "에러 : " + e.getMessage() );
		}
	}
}