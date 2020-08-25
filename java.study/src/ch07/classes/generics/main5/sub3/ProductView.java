package ch07.classes.generics.main5.sub3;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ProductView extends JFrame {
	
	public ProductView(){
		
		/** 화면 사이즈 설정 */
		this.setSize(300,300);
		
		/** 테이블 자료 **/
		ProductVo v1 = new ProductVo("a001", "아메리카노", 3000);
		ProductVo v2 = new ProductVo("a002", "카페라떼", 3500);
		ProductVo v3 = new ProductVo("a003", "카페모카", 4000);
		
		/** 테이블 정보 만들기 */
		String[] header = ProductVo.getHeaderInfo();
		Object[][] data = new Object[][] {v1.getData(), v2.getData(), v3.getData()};
		
		/** 테이블 컴포넌트 구성ㅎ기 */
		JTable table = new JTable(data, header);
		JScrollPane pane = new JScrollPane();
		pane.setViewportView(table);
		
		/** 화면에 추가하기 */
		this.add(pane);
		
	}
	/*
	public static void main(String[] args) {
		ProductView view = new ProductView();
		view.setVisible(true);

	}
	*/

}
