package ch13.javafx.control.main4;

public class ProductVo {
	
	/** productNo, productName, price �Ӽ� ���� */
	private String productNo;
	private String productName;
	private int price;
	
	/** �������Լ� ���� */
	public ProductVo(String productNo, String productName, int price) {
		this.productNo = productNo;
		this.productName = productName;
		this.price = price;
	}

	/** getter setter �Լ� ���� */
	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
