// 클래스 선언
class Student {
    String name;
    String hakbun;
    double height;
    double weight;
}

public class StudentEx01 {
    public static void main(String[] args){
        
        // 정수형 변수 i를 선언하고 10이란 값으로 초기화
        int i;
        i = 10;

        // 객체 변수 선언 / 참조 변수 선언 / 인스턴스 선언
        // 인스턴스화
        Student s1;

        // 메모리 생성
        // new 메모리 생성(할당) 연산자
        s1 = new Student();

        // 객체 변수 초기화
        // 객체 참조 연산자
        s1.name = "홍길동";
        s1.hakbun = "1001";
        s1.height = 175.52;
        s1.weight = 70.12;

        System.out.println( s1.name );
        System.out.println( s1.hakbun );
        System.out.println( s1.height );
        System.out.println( s1.weight );

        // 한번에 선언과 메모리 생성
        Student s2 = new Student();
        // 초기화
        s2.name = "잠양원픽";
        s2.hakbun = "1002";
        s2.height = 132.82;
        s2.weight = 35.7;

        System.out.println( s2.name );
        System.out.println( s2.hakbun );
        System.out.println( s2.height );
        System.out.println( s2.weight );

        // 주소값 출력
        System.out.println( s1 );
        System.out.println( s2 );
    }
}