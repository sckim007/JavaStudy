package ch08.method.dynamicandgenerics.main1;

public class A {
	/** 동적파라메터 사용 */
	public void print(String ... msg) {
		
		if(msg == null) return;
		
		String[] message = msg;
		for(String s : message) {
			System.out.println(s);
		}
	}
}
