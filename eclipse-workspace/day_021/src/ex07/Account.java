package ex07;

public class Account {
	// 통장 계좌 balance 선언
	private int balance = 1000;
	
	public int getBalance() {
		return balance;
	}
	
//	일반적인 출금 메서드
//	public void withdraw (int money ) {
	// 동기화 시켜서 잔액이 -가 되는것을 방지한다.
	// 하나가 진입해서 작업하고 있을때 하나는 못들어오게 방지함
	public synchronized void withdraw (int money ) {
		if ( balance >= money ) {
			try {
				Thread.sleep(500);
				
				// 돈을 뺀다
				balance -= money;
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}