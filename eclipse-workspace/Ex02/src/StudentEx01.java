
public class StudentEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student();
		Student s2 = new Student("1001", "홍길동");
		Student s3 = new Student("1001", "홍길동", 35, 180.1);
		
		System.out.println(s3.getHakbun());
		System.out.println(s3.getName());
		
	}

}
