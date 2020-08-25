package ch07.classes.generics.main5.sub3;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MemberView extends JFrame {

	public MemberView() {
		/** 화면 사이즈 설정 */
		this.setSize(300,300);
	
		/** 테이블 자료 **/
		MemberVo v1 = new MemberVo("a001", "김선철");
		MemberVo v2 = new MemberVo("a002", "김미균");
		MemberVo v3 = new MemberVo("a003", "김형순");
		MemberVo v4 = new MemberVo("a004", "김범수");
	
		/** 테이블 정보 만들기 */
		String[] header = MemberVo.getHeaderInfo();
		Object[][] data = new Object[][] {v1.getData(), v2.getData(), v3.getData(), v4.getData()};
	
		/** 테이블 컴포넌트 구성ㅎ기 */
		JTable table = new JTable(data, header);
		JScrollPane pane = new JScrollPane();
		pane.setViewportView(table);
	
		/** 화면에 추가하기 */
		this.add(pane);
	}
		
	public static void main(String[] args){
		MemberView view = new MemberView();
		view.setVisible(true);
	}
}
