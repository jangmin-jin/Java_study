package ex04;

public class Gugudan extends Thread {
	private int dan;
	
	public Gugudan(int dan) {
		this.dan = dan;
	};
	
	@Override
	public void run() {
		
		System.out.println(this.getName());
		for(int i = 1; i<=9; i++) {
			System.out.printf("%d X %d = %d\t\n", dan, i, (dan*i) );
		}
	}
}