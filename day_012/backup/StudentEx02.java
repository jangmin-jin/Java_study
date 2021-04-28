// 기존에 선언 되어있던 Student class 가 자동으로 참조 된다.

public class StudentEx02 {
    public static void main(String[] args){
        
        Student s2 = new Student();

        s2.name = "잠양원픽";
        s2.hakbun = "1002";
        s2.height = 132.82;
        s2.weight = 35.7;

        System.out.println( s2.name );
        System.out.println( s2.hakbun );
        System.out.println( s2.height );
        System.out.println( s2.weight );

        System.out.println( s2 );
    }
}