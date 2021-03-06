class Book {
    
    String title;
    String author;
    int price;

    Book(String title, String author, int price){
        
        this.title = title;
        this.author = author;
        this.price = price;
    }
}

public class ArrayEx01{
    public static void main(String[] args){
        
        // 기본 자료형의 2차원 배열 구조
        int[][] arr1 = new int[3][];
        arr1[0] = new int[] {10, 20, 30};
        arr1[1] = new int[] {40, 50, 60};
        arr1[2] = new int[] {70, 80, 90};

        // 일차원 <- 객체 --> 사실은 2차원 배열
        Book[] arr2 = new Book[3];
        arr2[0] = new Book("java", "홍길동", 1000);
        arr2[1] = new Book("jsp", "박문수", 2000);
        arr2[2] = new Book("sprint", "이몽룡", 3000);

        System.out.println(arr1);
        System.out.println(arr2);

        System.out.println(arr1[0]);
        System.out.println(arr2[0]);
    }
}