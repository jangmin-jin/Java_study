package ex01;

import java.io.IOException;

public class ProcessBuilderEx01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 경로 사이에 \\ 두개씩 넣어줘야함 \ 한개는 안됨
		// /로 써서 하나만 써줘두 상관없음
		ProcessBuilder processBuilder = new ProcessBuilder("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe", "www.google.com");
		processBuilder.start();
		
		// 메모장 실행해줘
		ProcessBuilder processBuilder2 = new ProcessBuilder("C:/Windows/System32/notepad.exe");
		processBuilder2.start();
	}
}