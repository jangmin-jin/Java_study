package ex04;

public class MyThread1 extends Thread {
	@Override
	public void run() {
		for(int i = 0; i<300; i++) {
			System.out.print( "-" );
		}
	}
}