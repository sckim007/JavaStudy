package ch03.method.accessibilit.main1.vo;

public class ProductVo1 {
	/** 전역변수 -타입의 속성 */
	public String productNo;		/** public - 모두 허용 */
	protected String productName;	/** protected - 동일패키지, 상속 */
	private int price;				/** private - 동일 클래스 */
	int type;						/** Default 접근 - 동일패키지 */
}
