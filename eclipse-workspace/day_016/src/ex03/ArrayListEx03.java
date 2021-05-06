package ex03;

import java.util.ArrayList;

public class ArrayListEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList al = new ArrayList( );
		
		Student stu1 = new Student( "1001", "홍길동" );
		Student stu2 = new Student( "1002", "박문수" );
		Student stu3 = new Student( "1003", "이몽룡" );
		
		// 참조 주소만 집어넣는다
		// 2차 배열 구조
		al.add( stu1 );
		al.add( stu2 );
		al.add( stu3 );
		
		System.out.println( al );
		
		for( int i = 0; i < al.size( ); i++ ) {
			Student stu = ( Student )al.get( i );
			System.out.println( stu.getHakbun( ) + " / " + stu.getName( ) );
		}
		
		for( Object obj : al ) {
			Student stu = (Student)obj;
			System.out.println( stu.getHakbun( ) + " / " + stu.getName( ) );
		}
	}
}