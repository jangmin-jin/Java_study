package day_030;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.table.AbstractTableModel;

public class CustomTableModelZipcode extends AbstractTableModel {
	// 변수 선언
	private String addressSearch[][] = null;
	private String searchResult[][] = null;
	
	public CustomTableModelZipcode(String address) {
		// 2개의 버퍼 선언 (row계산, 주소 결과 출력)
		BufferedReader getAddress = null;
		BufferedReader getRowNum = null;
		
		// 조건에 맞는 Row갯수 추출
		try {
			getRowNum = new BufferedReader(new FileReader("./zipcode_seoul_utf8_type2.csv"));
			String data = null;
			
			int rowNum = 0;
			while( (data = getRowNum.readLine()) != null) {
				String arr[] = data.split(",");
				if(arr[3].contains(address)){
					rowNum ++;
				}
			}
			
			// 각 변수 초기화
			addressSearch = new String[rowNum][7];
			searchResult = new String[rowNum][7];
		
		// 예외 처리
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(getRowNum!=null) try { getRowNum.close(); } catch (IOException e) { }
		}
		
		// 입력한 주소 찾기
		try {
			getAddress = new BufferedReader(new FileReader("./zipcode_seoul_utf8_type2.csv"));
			String data = null;
			
			int line = 0;
			while( (data = getAddress.readLine()) != null ) {
				String arr[] = data.split(",");
				if(arr[3].contains(address)) {
					for(int i=0; i<arr.length; i++) {
						addressSearch[line][i] = arr[i];
					}
					line ++;
				}
			}
					
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(getAddress!=null) try { getAddress.close(); } catch (IOException e) { }
		}
		
		// 예외 처리
		for(int i = 0; i<addressSearch.length; i++) {
			for(int j = 0; j<addressSearch[0].length; j++) {
				searchResult[i][j] = addressSearch[i][j];
			}
		}
	}

	// 컬럼 관련 정보 선언
	private String[] columnNames = new String[] {
			"우편번호", "시 / 도", "구 / 군", "동 / 면 / 읍", "리", "번지", "번호"
	};
	
	// ColNames 정보
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	// 데이터 행, 열정보
	@Override
	public int getRowCount() {
		return searchResult.length;
	}
	@Override
	public int getColumnCount() {
		return searchResult[0].length;
	}

	// 최종 결과 출력
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return searchResult[rowIndex][columnIndex];
	}
}