package ex09;

import java.io.File;
import java.util.Date;

public class FileEx06 {

	// CMD 창 만들기
	public static void main(String[] args) {
		// 파일의 경로 지정
		File f1 = new File("c:/java");
		
		// 파일 이름별로 배열에 저장
		File[] f1Lists = f1.listFiles( );
		
		for(File list : f1Lists) {
			// 파일 수정 날짜 확인
			long fileModified = list.lastModified( );
			String fileDate = new Date(fileModified).toLocaleString();
			
			// DIR확인후 변경을 위한 변수
			String isDIR = "";
			long fileSize = 0;
			
			// 각 list의 이름을 저장
			String fileName = list.getName();
			
			if( list.isDirectory( ) ) {
				isDIR = "<DIR>";
				System.out.printf("%-25s\t", fileDate);
				System.out.printf("%-20s\t", isDIR);
				System.out.println("[" + fileName + "]" );
			}else {
				fileSize = list.length( );
				System.out.printf("%-25s\t", fileDate);
				System.out.printf("%20s\t", fileSize);
				System.out.println(fileName);
			}
		}
	}
}