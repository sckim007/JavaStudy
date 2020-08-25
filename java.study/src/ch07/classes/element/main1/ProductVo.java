package ch07.classes.element.main1;

public class ProductVo {
	/** ����(static)���� - ��ü���� �����ϱ� ���� �������� ���� */
	private static int count;
	
	/** enum Ÿ�� */
	public enum DataType{
		INSERT, UPDATE, DELETE, NORMAL
	};
	
	/** �������� */
	private String productNo;	/* ǰ���ȣ */
	private String productName;	/* ǰ��� */
	private int price;
	
	/** �������� - �ڷᱸ��: �⺻������ NORMAL�� ������ */
	private DataType dataType = DataType.NORMAL;
	
	/** ����(static) �ʱ�ȭ ���� */
	static {
		System.out.println("ProductVo - ���� �ʱ�ȭ ���� ����");
		System.out.println("ProductVo - count = " + count);
	}
	
	/** �ʱ�ȭ ��� */
	{
		/** ��ü ���� �� ���� ȣ���� �Ͼ�� count�� ���� 1�� ������Ŵ */
		count++;
		System.out.println("ProductVo - �ʱ�ȭ ���� ���� count[" + count + "]");
		
		/** count�� �̿��Ͽ� ��ü ǰ���ȣ�� ������ */
		if (count < 10) {
			productNo = "a00" + count;
		} else if (count < 100) {
			productNo = "a0" + count;
		}  else if (count < 1000) {
			productNo = "a" + count;
		}
		System.out.println("ProductVo - productNo[" + productNo +"]");
	}
	
	/** ������ �Լ� (1)*/
	public ProductVo() {
		System.out.println("ProductNo - �������Լ�(1) ����");
	}
	
	/** ������ �Լ� (2)*/
	public ProductVo(String productName, int price) {
		this.productName = productName;
		this.price = price;
		System.out.println("ProductNo - �������Լ�(2) ����");
	}

	/** getter/setter �Լ� */
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

	/** toString �Լ� */
	public String toString() {
		return productNo + "\t" + productName + "\t" + price;
	}
	
	/** ProductVo�� �׸��� String[]�� ��Ÿ���� ���� �Լ� */
	public String[] getData() {
		return new String[] {productNo, productName, Integer.toString(price)};
	}
	
	/** ���� Ŭ���� - ���̺� �׸� ���� */
	public static class TableInfo{
		public static final String[] HEADER_NAME_INFO = new String[] {"ǰ���ȣ", "ǰ���", "�ܰ�", "����"};
		/** final static�� �����ڴ� �ٲپ ����ص� ������� */
		public final static int[] WIDTH_INFO = {100, 400, 100, 80};
	}
}
