package ex03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SearchZipcodeEx02 {

	public static void main(String[] args) {
		String strDong ="신사";
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader("./zipcode_seoul_utf8_type2.csv"));
			String address = null;
			
			while ( (address =br.readLine() ) != null ) {
				String[] addresses = address.split( "," );
				if( addresses[3].startsWith(strDong) ) {
					System.out.println( address );
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} catch (IOException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} finally {
			if ( br != null ) try { br.close(); } catch(IOException e) {}
		}
	}
}