package fruit;

public class Fruit {
	private int fruitNumber;
	private String fruitName;
	private int fruitPrice;
	private int fruitSurplus;
	public int getFruitNumber() {
		return fruitNumber;
	}
	public void setFruitNumber(int fruitNumber) {
		this.fruitNumber = fruitNumber;
	}
	public String getFruitName() {
		return fruitName;
	}
	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}
	public int getFruitPrice() {
		return fruitPrice;
	}
	public void setFruitPrice(int fruitPrice) {
		this.fruitPrice = fruitPrice;
	}
	public int getFruitSurplus() {
		return fruitSurplus;
	}
	public void setFruitSurplus(int fruitSurplus) {
		this.fruitSurplus = fruitSurplus;
	}
	@Override
	public String toString() {
		return "상품번호 :" + fruitNumber + ", 상품이름 :" + fruitName + ", 상품가격 : " + fruitPrice
				+ ", 상품갯수=" + fruitSurplus ;
	}
	
	
	
}
