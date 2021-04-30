
public class Student {
	private String hakbun;
	private String name;
	private int age;
	private double height;
	
	// St + ctrl + space 입력하면 생성자 자동 생성
	public Student() {
		// TODO Auto-generated constructor stub
		System.out.println("디폴트 생성자");
		System.out.println("sysout + ctrlspace로 한번에 완성도 가능하다");
	}

	// 필드의 내용을 가지는 초기화 생성자를 만들고 싶다.
	// 빈 줄에 오른쪽 마우스 -> 소스 -> 제네레이터 컨스트럭터 유징필드
	public Student(String hakbun, String name, int age, double height) {
		this.hakbun = hakbun;
		this.name = name;
		this.age = age;
		this.height = height;
	}
	
	// getter도 부분적으로 만들어 줄 수 있다.
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getHakbun() {
		return hakbun;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getHeight() {
		return height;
	}
	
}
