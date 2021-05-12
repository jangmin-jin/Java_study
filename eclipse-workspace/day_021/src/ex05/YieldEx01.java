package ex05;

public class YieldEx01 {

	public static void main(String[] args) {
		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();
		
		try {
			threadA.start();
			threadB.start();
			
			Thread.sleep( 3000 );
			
			threadA.work = false;
			
			Thread.sleep( 3000 );
			
			threadB.work = false;
			
			Thread.sleep( 3000 );
			
			threadA.stop = true;
			threadB.stop = true;
			
		} catch (InterruptedException e) {
			System.out.println( "에러 : " +e.getMessage() );
		}
	}
}