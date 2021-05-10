package ex03;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataInputStreamEx02 {

	public static void main(String[] args) {
		DataInputStream dis = null;
		
		try {
			dis = new DataInputStream(new FileInputStream("./value2.dat"));
			
			// 반드시 순서대로 읽어야 한다.
			for( int i = 0; i < 3; i++) {
				System.out.print( dis.readUTF() + " " );
				System.out.print( dis.readInt() + " " );
				System.out.print( dis.readDouble() );
				System.out.println( );
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(" 에러 : " + e.getMessage());
		} catch (IOException e) {
			System.out.println(" 에러 : " + e.getMessage());
		} finally {
			if ( dis != null ) try {dis.close();} catch(IOException e) {}
		}
	}
}