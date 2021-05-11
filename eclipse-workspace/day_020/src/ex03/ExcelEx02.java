package ex03;

import java.io.File;
import java.io.IOException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelEx02 {

	public static void main(String[] args) {
		Workbook workbook = null;
		
		try {
			workbook = Workbook.getWorkbook(new File("./jxlrwtest.xls"));		
			Sheet sheet = workbook.getSheet(0);
			
			// 열, 행 위치의 cell값 가져오기
			// Cell cell1 = sheet.getCell( 0, 2 );
			// System.out.println(cell1.getContents());
			
			for(int row=0; row<20; row++) {
				Cell cell0 = sheet.getCell( row , 0 );
				Cell cell1 = sheet.getCell( row , 1 );
				Cell cell2 = sheet.getCell( row , 2 );
				Cell cell3 = sheet.getCell( row , 3 );
				Cell cell4 = sheet.getCell( row , 4 );
				Cell cell5 = sheet.getCell( row , 5 );
				System.out.printf( 
						"%s\t%s\t%s\t%s\t%s\t\n", 
						cell0.getContents(),
						cell1.getContents(),
						cell2.getContents(),
						cell3.getContents(),
						cell4.getContents(),
						cell5.getContents() 
						);
			}
			
		} catch (BiffException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} catch (IOException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} finally {
				if ( workbook != null ) workbook.close();
		} 
	}
}