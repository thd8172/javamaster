package fruit;

public class PurchaseInfo {
<<<<<<< HEAD
	private int purNo;
	private String custId;
	private int fruitNumber;
	public int getPurNo() {
		return purNo;
	}
	public void setPurNo(int purNo) {
		this.purNo = purNo;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public int getFruitNumber() {
		return fruitNumber;
	}
	public void setFruitNumber(int fruitNumber) {
		this.fruitNumber = fruitNumber;
	}
	@Override
	public String toString() {
		return "PurchaseInfo [purNo=" + purNo + ", custId=" + custId + ", fruitNumber=" + fruitNumber + "]";
	}
=======
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
	
>>>>>>> branch 'master' of https://github.com/thd8172/javamaster.git
	
}
