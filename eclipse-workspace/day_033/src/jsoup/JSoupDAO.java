package jsoup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class JSoupDAO {
	
	BufferedReader br = null;
	String lines = null;
	
	public JSoupDAO() {
		
	}
	
	public ArrayList<JSoupTO> newsLists() {
		
		ArrayList<JSoupTO> newsLists = new ArrayList<JSoupTO>();
		
		/*
		// 가상 데이터 => 데이터 처리 구문		
		JSoupTO to1 = new JSoupTO();
		to1.setSource( "출처 2" );
		to1.setSubject( "제목 2" );
		to1.setContent( "내용 2" );
		*/
		
		/*
		JSoupTO to2 = new JSoupTO();
		to2.setSource( "출처 2" );
		to2.setSubject( "제목 2" );
		to2.setContent( "내용 2" );
		*/
		
		// newsLists.add( to1 );
		// newsLists.add( to2 );
		
		return newsLists;
	}
}