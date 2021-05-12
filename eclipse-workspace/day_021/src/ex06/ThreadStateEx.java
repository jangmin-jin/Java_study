package ex06;

public class ThreadStateEx {

	public static void main(String[] args) {
		PrintStateThread printStateThread = new PrintStateThread(new TargetThread() );
		printStateThread.start();
	}
}