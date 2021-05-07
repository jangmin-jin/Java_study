package ex07;

import java.io.IOException;

public class ExceptionEx09 {

	// 위임의 대상 - JVM
	public static void main(String[] args) throws IOException {
		ProcessBuilder processBuilder = new ProcessBuilder("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "www.google.com");
		
		processBuilder.start();
	}
}