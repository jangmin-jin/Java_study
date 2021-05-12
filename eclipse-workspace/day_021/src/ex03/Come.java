package ex03;

public class Come implements Runnable {

	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			System.out.println( "Come : " + i );
		}
	}
}