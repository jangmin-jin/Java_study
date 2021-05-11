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

public class LottoEx02 {

	public static void main(String[] args) {
		Workbook workbook = null;
		WritableWorkbook writeLottoStatistics = null;
		
		try {
			workbook = Workbook.getWorkbook(new File("./lotto.xls"));		
			
			// 엑셀파일 하나 만들어서 파일에 저장시킬거임
			writeLottoStatistics = Workbook.createWorkbook(new File("./lottoStatistics.xls"));
			WritableSheet writableSheet = writeLottoStatistics.createSheet("lottoStatistics", 0);
			
			// 변수선언
			Sheet sheet = workbook.getSheet(0);
			int sheetRow = sheet.getRows(); // 965
			int sheetCol = sheet.getColumns(); // 20
			int startLottoRow = 3;
			int strarLottoCol = 13;
			int[] CountResult = new int[45];
			int[][] result = new int [sheetCol][sheetRow];
			
			// 번호가 적혀있는 시트 구간을 2중 for문으로 돌면서 긁음
			for(int row = 0; row<sheetRow-startLottoRow; row++) {
				for(int col = 0; col<sheetCol-strarLottoCol; col++) {
					Cell cell = sheet.getCell(col + strarLottoCol, row + startLottoRow);
					result[col][row] = Integer.parseInt(cell.getContents());
					
					for (int i=0; i<CountResult.length; i++) {
						if (result[col][row] == (i+1)) {
							CountResult[i] += 1;
						}
					}
				}
			}
			
			// 결과 통계값 저장할때 그 숫자 스트링으로 변환해서 셀하나하나에 넣어줌
			for (int i=0; i<CountResult.length; i++) {
				System.out.println( (i+1) + "번 당첨횟수 : " + CountResult[i] );
				String CountResultStr = Integer.toString(CountResult[i]);
				Label label = new Label(0, i, CountResultStr);
				writableSheet.addCell( label );
			}
			
			// 출력
			writeLottoStatistics.write();
			
		} catch (WriteException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} catch (BiffException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} catch (IndexOutOfBoundsException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} catch (IOException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} finally {
			if ( workbook != null ) workbook.close();
			if (writeLottoStatistics != null) try { writeLottoStatistics.close(); } catch (Exception e) {}
		} 
	}
}