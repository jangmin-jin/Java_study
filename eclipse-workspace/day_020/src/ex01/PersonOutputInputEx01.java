package ex01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class PersonOutputInputEx01 {

	public static void main(String[] args) {
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		
		try {
			// ObjectOutputStream 파일생성
			oos = new ObjectOutputStream(new FileOutputStream("./serial3.dat"));
			Person p1 = new Person("홍길동", "010-1111-1111", 10, "서울시");
			Person p2 = new Person("박문수", "010-1111-2222", 20, "경기도");
			Person p3 = new Person("박하늘", "010-1111-3333", 30, "인천시");
			
			// 생성한 Person들 쓰기
			ArrayList<Person> personList = new ArrayList<Person>(Arrays.asList(p1, p2, p3));
			oos.writeObject(personList);
			
			// ObjectInputStream 파일읽기
			ois = new ObjectInputStream(new FileInputStream("./serial3.dat"));
			ArrayList<Person> personListRead = (ArrayList<Person>)ois.readObject();
			
			// 향상된 for문을 이용한다
			for( Person p : personListRead) {
				System.out.println( p.getName() );
				System.out.println( p.getPhone() );
				System.out.println( p.getAge() );
				System.out.println( p.getAddress() );
			}
			
		} catch (FileNotFoundException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} catch (ClassNotFoundException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} catch (IOException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} finally {
			if( ois != null ) try { ois.close(); } catch(IOException e) {}
			if( oos != null ) try { oos.close(); } catch(IOException e) {}
		}
	}
}