class Util {

    void doGugudan(int...Dan){
        
        for(int DanNum : Dan){
            for(int i = 1; i < 10; i++){
                // System.out.print(DanNum + "X" + i + "=" + (DanNum*i) + "\t");
                System.out.printf("%d X %d = %d\t", DanNum, i, (DanNum*i));
            }
            System.out.println();
        }

    }
}

public class UtilEx02 {
    public static void main(String[] args){

        Util util = new Util();
        util.doGugudan(1, 3, 5, 7, 9);
    
    }
}