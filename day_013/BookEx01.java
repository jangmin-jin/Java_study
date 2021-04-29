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

public class BookEx01{
    public static void main(String[] args){
        
        // 배열의 선언
        int arr1[] = new int[3];
        // 배열의 선언 응용
        Book arr2[] = new Book[3];

        Book b1 = new Book("java", "홍길동", 1000);
        Book b2 = new Book("jsp", "박문수", 2000);
        Book b3 = new Book("sprint", "이몽룡", 3000);

        arr2[0] = b1;
        arr2[1] = b2;
        arr2[2] = b3;

        System.out.println(arr2.length);

        System.out.println("기본 데이터 출력 방법");
        Book b = arr2[0];
        System.out.println(b.title);
        System.out.println(b.author);
        System.out.println(b.price);

        System.out.println("배열을 이용한 값 출력 방법");
        System.out.println(arr2[1].title);
        System.out.println(arr2[1].author);
        System.out.println(arr2[1].price);

        System.out.println("for문을 이용한 전체값 출력");
        for(int i = 0; i < arr2.length; i++){
            System.out.println(arr2[i].title);
            System.out.println(arr2[i].author);
            System.out.println(arr2[i].price);
        }

        System.out.println("향상된 for문 출력");
        for(Book data : arr2){
            System.out.println(data.title);
            System.out.println(data.author);
            System.out.println(data.price);
        }
    }
}