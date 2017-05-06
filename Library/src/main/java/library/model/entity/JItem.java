package library.model.entity;

public class JItem {
	private String name;
	private int orderNo;

	public JItem() {

	}

	public JItem(String name, int orderNo){
		this.name = name;
		this.orderNo = orderNo;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
}
