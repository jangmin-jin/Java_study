package ex03;

import java.io.File;
import java.io.IOException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ExcellEx04 {

	public static void main(String[] args) {
		File file = new File("./zipcode.xls");
		Workbook adressBook = null;
		WritableWorkbook writableAdressbook = null;
		try {
			adressBook = Workbook.getWorkbook(new File("./zipcode_seoul_utf8_type2.xls"));
			
			Sheet sheet1 = adressBook.getSheet(0);
			int sheet1Columns = (int)sheet1.getColumns();
			int sheet1Rows = (int)sheet1.getRows();
			
			for( int i = 0; i<sheet1Rows; i++) {
				Cell sheet1Cell = sheet1.getCell( 2, i );
				if (sheet1Cell.getContents().equals("서울")) {
					
				}
			}

//			Cell[] addresses = {};
//			for( int i=0; i<sheet1Rows ; i++) {
//				addresses[i] = sheet1.getCell( 2, i );
//				System.out.println( addresses[i].getContents() );
//			}
			
//			writableAdressbook = Workbook.createWorkbook( file );
//			
//			WritableSheet adressSheet1 = writableAdressbook.createSheet("서울", 0);
//			WritableSheet adressSheet2 = writableAdressbook.createSheet("인천", 1);
//			WritableSheet adressSheet3 = writableAdressbook.createSheet("경기", 2);
//			
//			Label label = new Label(0, 0, "데이터 0, 0");
//			adressSheet1.addCell(label);
//			
//			writableAdressbook.write();
//			
//			System.out.println( "파일 생성 성공" );
//		} catch (WriteException e) {
//			System.out.println( "에러 : " + e.getMessage() );
		} catch (BiffException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} catch (IOException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} finally {
			if (writableAdressbook != null) try { writableAdressbook.close(); } catch (Exception e) {}
		}
	}
}