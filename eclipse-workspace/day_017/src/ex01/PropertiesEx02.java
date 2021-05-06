package ex01;

import java.util.Enumeration;
import java.util.Properties;

public class PropertiesEx02 {

	public static void main(String[] args) {
		Properties pros = System.getProperties( );
		Enumeration e = pros.propertyNames( );
		
		while( e.hasMoreElements( ) ) {
			String name = (String)e.nextElement( );
			System.out.println( name );
		}
		
		System.out.println( System.getProperty( "java.vm.version" ) );
		System.out.println( System.getProperty( "java.runtime.name" ) );
	}
}