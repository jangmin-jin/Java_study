package ex04;

public class MainEx {

	public static void main(String[] args) {
		// 익명 내부클래스를 이용해서 스레드를 동작시킬 수 있다.
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=1; i<=10; i++) {
					System.out.println( "Go : " + i );
				};
			}
		});
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=1; i<=10; i++) {
					System.out.println( "Come : " + i );
				};
			}
		});
		
		t1.start();
		t2.start();
	}
}