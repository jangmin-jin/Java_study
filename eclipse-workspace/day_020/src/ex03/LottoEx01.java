package ex03;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class LottoEx01 {

	public static void main(String[] args) {
		Workbook workbook = null;
		
		try {
			// Workbook 써서 읽어옴. BufferedRead는 파일이 깨짐.
			workbook = Workbook.getWorkbook(new File("./lotto.xls"));		
			Sheet sheet = workbook.getSheet(0);
			
			// 변수 선언
			int sheetCol = sheet.getColumns(); // 20
			int sheetRow = sheet.getRows(); // 965
			int strarLottoCol = 13;
			int startLottoRow = 3;
			int[] CountResult = new int[45];
			int[][] result = new int [sheetCol][sheetRow];
			
			// 번호가 적혀있는 시트 구간을 2중 for문으로 돌면서 긁음
			for(int row = 0; row<sheetRow-startLottoRow; row++) {
				for(int col = 0; col<sheetCol-strarLottoCol; col++) {
					// 번호가 적혀있는 cell 안에 담겨져있는 숫자 읽어오고
					Cell cell = sheet.getCell(col + strarLottoCol, row + startLottoRow);
					
					// 결과값 저장하는 변수에 다 넣어줌
					result[col][row] = Integer.parseInt(cell.getContents());
					
					// 결과감 내에서 돌리면서 각 번호별 횟수 통계
					for (int i=0; i<CountResult.length; i++) {
						if (result[col][row] == (i+1)) {
							CountResult[i] += 1;
						}
					}
				}
			}
			
			// 결과값과 횟수 통계 토대로 결과 출력
			for (int i=0; i<CountResult.length; i++) {
				System.out.println( (i+1) + "번 당첨횟수 : " + CountResult[i] );
			}
			
		} catch (BiffException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} catch (IndexOutOfBoundsException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} catch (IOException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} finally {
			if ( workbook != null ) workbook.close();
		} 
	}
}