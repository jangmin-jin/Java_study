package ex01;

public class Parent {
	public String p = "Parent";
	
//	public Parent() {
//		// TODO Auto-generated constructor stub
//		System.out.println("Parent 생성자 호출");
//	}
	
	public Parent(String data1) {
		System.out.println("Parent 생성자 호출(String data1)");
	}
	
	public void viewParent1() {
		System.out.println("viewParent1() 호출");
	}

	public void viewParent2() {
		System.out.println("viewParent2() 호출");
	}
}