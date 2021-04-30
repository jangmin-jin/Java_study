// com 안에 naver 안에 Student를 임포트
import com.naver.Student;

public class StudentEx01{
    public static void main(String[] args){
        
        // Student s = new Student();

        // 기본적인 방법

        // s.hakbun = "1001";
        // s.name = "홍길동";
        // s.age = 29;
        // s.height = 180.2;
        // System.out.println(s.hakbun);

        // setter / getter 를 이용한 출력
        // s.setHakbun("1001");
        // s.setName("홍길동");
        // s.setAge(29);
        // s.setHeight(180.2);
        // System.out.println(s.getHakbun());

        Student s = new Student("1001", "홍길동", 29, 180.2);
        System.out.println(s.getHakbun());
    }
}