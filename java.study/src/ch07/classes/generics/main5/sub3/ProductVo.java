package ch07.classes.generics.main5.sub3;

public class ProductVo {
	/** �Ӽ� ���� */
	private String productNo;
	private String productName;
	private int price;
	
	/** ������ �Լ� ���� */
	public ProductVo(String productNo, String productName, int price) {
		this.productNo = productNo;
		this.productName = productName;
		this.price = price;
	}
	/** �ڷ��� ������ ��ȯ�ϴ� �Լ� ���� */
	public Object[] getData() {
		return new Object[] {productNo, productName, price};
	}
	
	/** ���̺��� ��������� ��ȯ�ϴ� �Լ� ���� */
	public static String[] getHeaderInfo() {
		return new String[] {"ǰ���ȣ", "ǰ���", "�ܰ�"};
	}
}

