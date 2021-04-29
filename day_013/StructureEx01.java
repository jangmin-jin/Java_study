class Structure{

    // 멤버 필드
    // 인스턴스 / 클래스(스태틱)
    // 지역변수 (메서드 안에 선언된 변수 + 초기화)
    String instanceVar = "instance";
    static String classVar = "class";

    // 메서드
    // 인스턴스 / 클래스(스태틱)

    void doFunc_1() {
        // this.
        // overloading
        System.out.println("doFunc_1() 호출");
    }

    static void doFunc_2() {
        System.out.println("doFunc_2() 호출");
    }
}
public class StructureEx01{
    // 특수 메서드
    public static void main(String[] args){
        System.out.println(Structure.classVar);
        Structure.doFunc_2();

        Structure s = new Structure();
        System.out.println(s.instanceVar);
        s.doFunc_1();
    }
}