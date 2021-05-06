package day_017_practice1;

import java.util.Scanner;

public class ProducManagerClient {
	
	private final String line ="*************************************************";
	String mainMenu = "현황조회(L)\t상품등록(R)\t상품판매(S)\t종료(X)";
	Scanner scanner = new Scanner(System.in);
	
	private void displayMainMenu() {


		do {
			System.out.println( line );
			System.out.println( mainMenu );
			System.out.println( line );
			String input = scanner.nextLine();
			
			if(input.equalsIgnoreCase("X")) {
				System.out.println("종료합니다.");
				return;
			}else if(input.equalsIgnoreCase("L")){
				System.out.println("현황을 조회합니다.");
			}else if(input.equalsIgnoreCase("R")){
				System.out.println("상품을 등록합니다.");
			}else if(input.equalsIgnoreCase("S")){
				System.out.println("상품을 판매합니다.");
			}else {
				System.out.println("적절한 메뉴가 아닙니다.");
			}
		}while(true);
	}
	
	public static void main(String[] args) {
		ProducManagerClient pmc = new ProducManagerClient();
		pmc.displayMainMenu();
	}
}