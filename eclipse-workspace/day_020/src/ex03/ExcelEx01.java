package ex03;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelEx01 {

	public static void main(String[] args) {
		// jxl 외부 라이브러리를 사용해서 선언
		Workbook workbook = null;
		
		try {
			// 엑셀 파일 가져오기
			workbook = Workbook.getWorkbook(new File("./jxlrwtest.xls"));
			
			// 파일 버전 체크
			System.out.println( workbook.getVersion() );
			
			// Sheet 이름 추출
			String[] names = workbook.getSheetNames();
			System.out.println( Arrays.toString(names) );
			
			// workSheet 하나의 정보			
			Sheet sheet = workbook.getSheet(0);
			System.out.println(sheet.getName());

			// 해당 workSheet의 행/열 수 뽑기
			System.out.println( sheet.getColumns() );
			System.out.println( sheet.getRows() );
		
		} catch (BiffException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} catch (IOException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} finally {
				if ( workbook != null ) workbook.hashCode();
		} 
	}
}