import com.naver.Student;
// import 지워도 ctrl + shift + o 하면 애가 찾아줌

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Java");
		
		Student s = new Student();
		
		s.setHakbun("1001");
		s.setName("홍길동");
		s.setAge(35);
		s.setHeight(180.1);
		
		System.out.println(s.getHakbun());
	}

}
