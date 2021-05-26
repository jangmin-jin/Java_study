package day_030;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ZipcodeSearchLogic {
	
	private String address="";
	private String[] result;
	private int col = 0;
	
	public ZipcodeSearchLogic (String address, int col) {
		this.address = address;
		this.col = col;
	}
	
	public String searchZipcode () {
		BufferedReader br = null;
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
			
			// 변수 초기화
			this.result = new String[rowNum];
		
		// 예외 처리
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(getRowNum!=null) try { getRowNum.close(); } catch (IOException e) { }
		}
		
		// 주소 추출
		try {
			br = new BufferedReader(new FileReader("./zipcode_seoul_utf8_type2.csv"));
			
			String data = "";
			int count = 0;
			while ((data=br.readLine()) != null) {
				String[] adress = data.split(",");
				if (adress[3].startsWith(address)) {
					this.result[count] = data;
					count++;
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("에러 : "+e.getMessage());
		} catch (IOException e) {
			System.out.println("에러 : "+e.getMessage());
		} finally {
			if (br != null) try { br.close();} catch (IOException e) {}
		}
		
		// 클릭한 부분에 해당하는 행을 반환 
		return result[col];
		}
	}