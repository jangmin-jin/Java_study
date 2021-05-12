package ex06;

public class DeamonEx01 {

	public static void main(String[] args) {
		System.out.println( "시작" );
		
		Thread t1 = new Thread(new Gugudan(2));
		Thread t2 = new Thread(new Gugudan(5));
		
		// setDaemon 하면 main에 종속되서 메인이 종료되면 실행안함
		// 근데 컴터 상황에 따라 좀 달라짐
		t1.setDaemon(true);
		t2.setDaemon(true);
		
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println( "종료" );
	}
}