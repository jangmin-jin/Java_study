package ex02;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileEx01 {

	public static void main(String[] args) {
		
		// dir을 만들 수 있다.
		try {
			DirectoryStream<Path> directorySteStream = Files.newDirectoryStream( Paths.get(".") );
			
			for( Path path : directorySteStream) {
				String name = path.getFileName().toString();
				System.out.print( name + " " );
				
				long fileSize = Files.size(path);
				System.out.println( fileSize );
			}
		} catch (IOException e) {
			System.out.println( "에러 : " + e.getMessage() );
		} 
	}
}