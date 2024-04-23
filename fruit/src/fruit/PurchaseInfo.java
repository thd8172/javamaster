package fruit;

public class PurchaseInfo {
	private int purchaseNo;
	private int customerId;
	private int fruitNumber;
	private int qty;
	public int getPurchaseNo() {
		return purchaseNo;
	}
	public void setPurchaseNo(int purchaseNo) {
		this.purchaseNo = purchaseNo;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getFruitNumber() {
		return fruitNumber;
	}
	public void setFruitNumber(int fruitNumber) {
		this.fruitNumber = fruitNumber;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "PurchaseInfo [purchaseNo=" + purchaseNo + ", customerId=" + customerId + ", fruitNumber=" + fruitNumber
				+ ", qty=" + qty + "]";
	}
	
	
}
