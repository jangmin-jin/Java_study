package ex03;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ExcellEx03 {

	public static void main(String[] args) {
		File file = new File("./text.xls");
		WritableWorkbook writableWorkbook = null;
		try {
			writableWorkbook = Workbook.createWorkbook( file );
			
			WritableSheet writableSheet1 = writableWorkbook.createSheet("첫번째 시트", 0);
			WritableSheet writableSheet2 = writableWorkbook.createSheet("두번째 시트", 1);
			WritableSheet writableSheet3 = writableWorkbook.createSheet("세번째 시트", 2);
			
			Label label = new Label(0, 0, "데이터 0, 0");
			writableSheet1.addCell(label);
			
			writableWorkbook.write();
			
			System.out.println( "파일 생성 성공" );
		} catch (WriteException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} catch (IOException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} finally {
			if (writableWorkbook != null) try { writableWorkbook.close(); } catch (Exception e) {}
		}
	}
}