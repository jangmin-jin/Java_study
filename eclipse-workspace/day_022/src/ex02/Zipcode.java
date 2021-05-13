package ex02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Zipcode {
	
	private String dong="";
	private String result = "";
	
	public Zipcode (String dong) {
		this.dong = dong;
	}
	
	public String searchZipcode () {
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("./zipcode_seoul_utf8_type2.csv"));
			
			String data = "";
			while ((data=br.readLine()) != null) {
				String[] adress = data.split(",");
				if (adress[3].startsWith(dong)) {
					this.result += data+"\n";
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("에러 : "+e.getMessage());
		} catch (IOException e) {
			System.out.println("에러 : "+e.getMessage());
		} finally {
			if (br != null) try { br.close();} catch (IOException e) {}
		}
		return result;
		}
	}