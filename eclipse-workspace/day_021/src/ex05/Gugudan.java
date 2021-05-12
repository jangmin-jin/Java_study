package ex05;

public class Gugudan extends Thread {
	private int dan;
	
	public Gugudan(int dan) {
		this.dan = dan;
	};
	
	@Override
	public void run() {
		
		try {
			// 멈춰!
			Thread.sleep(2000);
			
			for(int i = 1; i<=9; i++) {
				System.out.printf("%d X %d = %d\t\n", dan, i, (dan*i) );
			}
		} catch (InterruptedException e) {
			System.out.println( "에러 : " + e.getMessage() );
		}
	}
}