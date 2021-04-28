// 기존에 선언 되어있던 Student class 가 자동으로 참조 된다.

public class StudentEx03 {
    public static void main(String[] args){
        
        Student s1 = new Student();
        System.out.println( s1 );

        s1.name = "홍길동";

        // 얕은 복사(shadow copy)
        Student s2 = s1;
        System.out.println( s1.name );
        System.out.println( s2.name );

        s2.name = "장선우";

        System.out.println( s1.name );
        System.out.println( s2.name );

    }
}