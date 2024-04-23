package fruit;

public class Customer {
	private int customerId;
	private String custName;
	private String custPhone;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", custName=" + custName + ", custPhone=" + custPhone + "]";
	}
}
