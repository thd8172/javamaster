package fruit;

<<<<<<< HEAD
import java.util.*;

public class FruitManager {

	Scanner sc = new Scanner(System.in);
	FruitDAO dao = new FruitDAO();
	String logId;

	public void exe() {
		boolean run = true;

		while (run) {
			System.out.println("-------------------------------------");
			System.out.println("1.고객 2.회원 3.쇼핑 4.종료");
			System.out.println("-------------------------------------");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			// 고객
			case 1:
				customerFunc();
				break;
			// 회원 아이디
			case 2:
				memberFunc();
				break;
			case 3:	
				customer();
			case 4:
				System.out.println("종료합니다.");
				run = false;
			}
		}
		System.out.println("end of prog.");
	}// end of exe.

	void customerFunc() {
		
		while (true) {
			
			System.out.println("---------------------------------------------");
			System.out.println("1.로그인 2.회원가입 3.회원탈퇴 4.종료");
			System.out.println("---------------------------------------------");
			System.out.print("메뉴선택>>");
			int custom = Integer.parseInt(sc.nextLine());
			switch (custom) {
			case 1:
				System.out.println("아이디 >");
				String custid = sc.nextLine();
				System.out.println("비밀번호 >");
				String custpw = sc.nextLine();

				Customer cust1 = new Customer();
				cust1.setCustid(custid);
				cust1.setCustpw(custpw);

				if (dao.loginCustomer(cust1)) {
					System.out.println("로그인");
					logId = custid;
					return;

				} else {
					System.out.println("로그인실패");
					break;
				}

			case 2:
				System.out.print("아이디 >> ");
				custid = sc.nextLine();
				System.out.print("비밀번호  >> ");
				custpw = sc.nextLine();
				System.out.print("이름  >> ");
				String custname = sc.nextLine();

				Customer cust = new Customer();

				cust.setCustid(custid);
				cust.setCustpw(custpw);
				cust.setCustName(custname);

				if (dao.insertCustomer(cust)) {
					System.out.println("정상등록");
				} else {
					System.out.println("예외발생");
				}
				break;
			case 3:
				System.out.print("탈퇴할 아이디 >>");
				 custid = sc.nextLine();
	
				
				if (dao.deleteCustomer(custid)) {
					System.out.println("삭제 완료");
				} else {
					System.out.println("삭제 실패");
				}
				break;

			case 4:
				System.out.println("종료");
				return;
			}
		}
	} // end of customerFunc.

	void memberFunc() {
		if (logId == null) {
			System.out.println("로그인을 하세요.");
			return;
		}
		while (true) {
			System.out.println("---------------------------------");
			System.out.println("1.상품정보 2.상품등록 3.상품수정 4.상품삭제 5.종료");
			System.out.println("---------------------------------");
			System.out.print("선택>>");
			int fruits = Integer.parseInt(sc.nextLine());

			int fruitNumber;
			switch (fruits) {

			case 1:
				List<Fruit> fruit = dao.fruitList();

				System.out.println("상품번호 상품명 상품가격 상품갯수");
				System.out.println("---------------------------");
				for (Fruit fruit1 : fruit) {
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
				sc.nextLine();
				Fruit fruit1 = new Fruit();

				fruit1.setFruitName(fruitName);
				fruit1.setFruitPrice(fruitPrice);
				fruit1.setFruitSurplus(fruitSurplus);

				if (dao.insertfruit(fruit1)) {
					System.out.println("정상등록");
				} else {
					System.out.println("예외발생");
				}

				break;
			case 3:
				System.out.println("상품명>>");
				fruitName = sc.nextLine();
				System.out.println("상품가격>>");
				fruitPrice = sc.nextInt();
				System.out.println("상품갯수>>");
				fruitSurplus = sc.nextInt();
				sc.nextLine();
				fruit1 = new Fruit();

				fruit1.setFruitName(fruitName);
				fruit1.setFruitPrice(fruitPrice);
				fruit1.setFruitSurplus(fruitSurplus);

				if (dao.insertfruit(fruit1)) {
					System.out.println("수정 완료");
				} else {
					System.out.println("수정 실패");
				}
				;
				break;
			case 4:
				System.out.println("삭제할 상품 >>");
				fruitNumber = sc.nextInt();
				sc.nextLine();
				if (dao.deletefruit(fruitNumber)) {
					System.out.println("삭제 완료");
				} else {
					System.out.println("삭제 실패");
				}
				break;

			case 5:
				System.out.println("종료");
				return;
			}
		}
	} // end of memberFunc.
	
	void customer() {
		while(true) {
			System.out.println("-----------------------------------------");
			System.out.println("1.상품전체목록 2.상품목록 3.상품 구매 4.쇼핑종료");
			System.out.println("-----------------------------------------");
			System.out.print("번호를 선택하세요 >");
			int shoping = Integer.parseInt(sc.nextLine());

			switch(shoping) {
			case 1:
				List<Fruit> fruit = dao.fruitList();

				System.out.println("상품번호 상품명 상품가격 상품갯수");
				System.out.println("---------------------------");
				for (Fruit fruit1 : fruit) {
					System.out.println(fruit1.toString());
				}
				break;
			case 2:
				System.out.print("상품명을 가져올 상품 번호를 입력하세요:");
				int fruitNumber = Integer.parseInt(sc.nextLine());				
				// 수정된 purchaseinfo 메소드 호출
				PurchaseInfo fr = new PurchaseInfo();
				fr.setFruitNumber(fruitNumber);
				String fruitInfo = dao.getFruitInfo(fruitNumber);

				if (fruitInfo != null) {
				    System.out.println(fruitInfo);
				} else {
				    System.out.println("해당 상품 번호에 대한 상품이 없습니다.");
				}
				break;
			case 3:
				System.out.println("과일 번호를 입력하세요:");
				int fruitNumber1 = Integer.parseInt(sc.nextLine());
				System.out.println("수량을 입력하세요:");
				int quantity = Integer.parseInt(sc.nextLine());

				String fruitInfo1 = dao.getFruitInfo(fruitNumber1, quantity);

				if (fruitInfo1 != null) {
				    System.out.println(fruitInfo1);
				} else {
				    System.out.println("해당 상품 번호에 대한 상품이 없습니다.");
				}
				break;
			case 4:	
				System.out.println("쇼핑종료");
				return;
			}
		}
	}

}
=======
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
>>>>>>> branch 'master' of https://github.com/thd8172/javamaster.git
