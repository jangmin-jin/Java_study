package ex03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class SearchZipcodeEx01 {

	public static void main(String[] args) {
		BufferedReader br = null;
		WritableWorkbook writableWorkbook = null;
		
		try {
			br = new BufferedReader(new FileReader("./zipcode_seoul_utf8_type2.csv"));
			writableWorkbook = Workbook.createWorkbook(new File("./zipcode.xls"));
			WritableSheet writableSheet = null;
			
			String address = null;
			String sido = "";
			int sheet = 0;
			int row = 0;
			
			while( (address = br.readLine() ) != null) {
				String[] addresses = address.split(",");
				if( !addresses[1].equals(sido)) {
					sido = addresses[1];
					writableSheet = writableWorkbook.createSheet(sido, sheet++);
					row = 0;
				}
				for (int col=0; col<addresses.length; col++) {
					Label label = new Label (col, row, addresses[col]);
					writableSheet.addCell( label );
				}
				row++;
			}
			writableWorkbook.write();
			System.out.println( "출력이 완료 되었습니다." );
			
		} catch (WriteException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} catch (FileNotFoundException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} catch (IOException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} finally {
			if (writableWorkbook != null) try { writableWorkbook.close(); } catch (Exception e) {}
			if (br != null) try { br.close(); } catch (IOException e) {}
		}
	}
}