package ex01;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GugudanEx01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print( "시작단 끝단 입력 : ");
		int startDan = sc.nextInt();
		int endDan = sc.nextInt();
		
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("./gugudan.txt");
			
			for(int i = startDan; i <= endDan; i++ ) {
				for(int j = 1; j <= 9; j++) {
					String msg = String.format("%d X %d = %2d\t", i, j, (i*j));
					fw.write(msg);
				}
				fw.write("\n");
			}
			System.out.println( "출력 완료" );
		} catch (IOException e) {
			System.out.println( "에러 : " + e.getMessage() );
		}finally {
			if ( fw != null) try { fw.close(); } catch (IOException e) { }
		}
		
	}
}