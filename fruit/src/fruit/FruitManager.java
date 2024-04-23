package fruit;

import java.util.List;
import java.util.Scanner;

import cd.yedam.Memberloyee;



public class FruitManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		boolean run  = true;
		FruitDAO dao = new FruitDAO();
		
		
		while(run) {
			System.out.println("---------------------------------");
			System.out.println("1.상품등록 2.상품정보 3.상품관리 4.로그아웃");
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
       	 String fruitPrice = sc.nextLine();
       	 System.out.println("상품갯수>>");
       	 String fruitSurplus = sc.nextLine();
 
    
//       	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
       	 
       	 Fruit fruit1 = new Fruit();
       	
       	 fruit1.setFruitName(fruitName);;
       	 fruit1.setFruitPrice(fruit);
       	 sw.setBirth(birth);
       	 sw.setGd(gd);
       	 if(dao.insertEmp(sw)) {
       		 System.out.println("정상등록");
       	 }else {
       		 System.out.println("예외발생.");
       	 };
           break;
		case 3:
		  
		case 4:
			
			break;

		
		}
		}
	}
}
