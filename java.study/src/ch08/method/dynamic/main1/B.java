package ch08.method.dynamic.main1;

public class B {
	/** 배열파라메터 사용 */
	public void print(String[] msg) {
		
		if(msg == null) return;
		
		for(String s : msg) {
			System.out.println(s);
		}
	}
}
