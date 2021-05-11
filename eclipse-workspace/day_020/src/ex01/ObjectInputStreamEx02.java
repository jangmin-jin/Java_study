package ex01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamEx02 {

	public static void main(String[] args) {
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream("./serial.dat"));
			
			Person p = (Person)ois.readObject();
			
			System.out.println( p.getName() );
			System.out.println( p.getPhone() );
			System.out.println( p.getAge() );
			System.out.println( p.getAddress() );
		} catch (FileNotFoundException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} catch (ClassNotFoundException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} catch (IOException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} finally {
			if( ois != null ) try { ois.close(); } catch(IOException e) {}
		}
	}
}