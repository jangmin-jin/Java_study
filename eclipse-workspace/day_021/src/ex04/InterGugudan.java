package ex04;

public class InterGugudan implements Runnable {
	
	private int dan;
	
	public InterGugudan(int dan) {
		this.dan = dan;
	};
	
	@Override
	public void run() {
		for(int i = 1; i<=9; i++) {
			System.out.printf("%d X %d = %d\t\n", dan, i, (dan*i) );
		}
	}
}