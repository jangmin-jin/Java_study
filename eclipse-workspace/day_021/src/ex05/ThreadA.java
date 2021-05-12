package ex05;

public class ThreadA extends Thread {
	public boolean stop = false;
	public boolean work = true;
	
	@Override
	public void run() {
		while( !stop ) {	
			if( work ) {
				System.out.println("ThreadA 작업 중");
			}else {
				Thread.yield();
			}
		}
		System.out.println( "ThreadA 작업 종료" );
	}
}