package fruit;

public class PurchaseInfo {
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
	
}
