package ex04;

public class MyThread2 extends Thread {
	@Override
	public void run() {
		for(int i = 0; i<300; i++) {
			System.out.print( "|" );
		}
	}
}