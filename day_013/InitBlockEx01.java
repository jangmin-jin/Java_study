class InitBlock{

    String name1;
    static String name2;

    // 초기화 블럭
    // 초기화 블럭 : 클래스 블럭
    static {
        System.out.println("static 블럭");
        InitBlock.name2 = "장자인";
    }

    // 초기화 블럭 : 인스턴스 블럭
    {
        System.out.println("instance 블럭");
        this.name1 = "장선우";
    }

    // 초기화 블럭 : {}
    InitBlock(){
        System.out.println("InitBlock() 호출");
        System.out.println(this.name1);
        System.out.println(this.name2);
    }
}
public class InitBlockEx01{
    public static void main(String[] args){

        InitBlock i = new InitBlock();
    }
}