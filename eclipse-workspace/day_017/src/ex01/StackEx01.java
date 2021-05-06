package ex01;

import java.util.Stack;

public class StackEx01 {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>( );
		stack.push("홍길동");
		stack.push("박문수");
		stack.push("이몽룡");
		
		System.out.println( stack.toString( ) );
		stack.pop();
		stack.push("삼몽룡");
		
		System.out.println( stack.pop( ) );
		System.out.println( stack.toString( ) );
	}
}