package fruit;

import java.util.*;




public class FruitManager {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		boolean run  = true;
		FruitDAO dao = new FruitDAO();
		
		
		while(run) {
			System.out.println("---------------------------------");
			System.out.println("1.상품정보 2.상품등록 3.상품수정 4.상품삭제");
			System.out.println("---------------------------------");
			System.out.print("선택>>");
			int menu = Integer.parseInt(sc.nextLine());
		
		switch(menu) {
		
		case 1:
			List<Fruit> fruit = dao.fruitList();
			
			System.out.println("상품번호 상품명 상품가격 상품갯수");
			System.out.println("---------------------------");
			for(Fruit fruit1 : fruit) {
				System.out.println(fruit1.toString());
			}
			break;
		case 2:
		 System.out.println("상품명>>");
       	 String fruitName = sc.nextLine();
       	 System.out.println("상품가격>>");
       	 int fruitPrice = sc.nextInt();
       	 System.out.println("상품갯수>>");
       	 int fruitSurplus = sc.nextInt();
        	 
       	 Fruit fruit1 = new Fruit();
       	 
       	 fruit1.setFruitName(fruitName);
       	 fruit1.setFruitPrice(fruitPrice);
       	 fruit1.setFruitSurplus(fruitSurplus);
       	 
       	 if(dao.insertfruit(fruit1)) {
       		 System.out.println("정상등록");
       	 } else {
       		 System.out.println("예외발생");
       	 };
       	 break;
		case 3:
			System.out.println("상품명>>");
	       	  fruitName = sc.nextLine();
	       	 System.out.println("상품가격>>");
	       	 fruitPrice = sc.nextInt();
	       	 System.out.println("상품갯수>>");
	       	 fruitSurplus = sc.nextInt();
	        	 
	       	 fruit1 = new Fruit();
	       	 
	       	 fruit1.setFruitName(fruitName);
	       	 fruit1.setFruitPrice(fruitPrice);
	       	 fruit1.setFruitSurplus(fruitSurplus);
	       	 
	       	 if(dao.insertfruit(fruit1)) {
	       		 System.out.println("수정 완료");
	       	 } else {
	       		 System.out.println("수정 실패");
	       	 };
	       	 break;
		case 4:
			
			break;
			}
		}
	}
}
