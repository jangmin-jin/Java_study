class Constructor{

    // Constructor (생성자)
    // 멤버 변수에 대한 초기화
    // 클래스명과 동일 / 리턴 없음 (void, 자료형)
    // 생성자에 대한 선언이 없으면 컴파일러 자동생성 - 디폴트 생성자

    String data;

    // void가 없으면 생성자
    // Constructor(){
    //     System.out.println("Consturctor() 호출");
    //     this.data = "홍길동";
    // }

    // 외부의 값을 받아서 만들어주는 생성자
    // 파라메터가 변경될 시에 수동 생성
    Constructor(String data){
        System.out.println("Consturctor() 호출");
        this.data = data;
    }
}

public class ConstructorEx01{
    public static void main(String[] args){
        
        // Constructor c;
        // // Constructor() - 생성자(Constructor)
        // c = new Constructor();
        // System.out.println(c.data);

        Constructor c;
        c = new Constructor("박문수");
        System.out.println(c.data);
    }
}