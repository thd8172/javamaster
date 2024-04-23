package fruit;

import java.util.List;

public class FruitApptest {
	public static void main(String[] args) {
		FruitDAO dao = new FruitDAO();
		Fruit fruit = new Fruit();
		
		fruit.setFruitName("딸기");
		fruit.setFruitPrice(3000);
		fruit.setFruitSurplus(20);
		
		 if(dao.equals(fruit)) {
    		 System.out.println("정상등록");
    	 }else {
    		 System.out.println("예외발생.");
    	 };
    	 
	}
}
