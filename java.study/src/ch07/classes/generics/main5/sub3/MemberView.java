package ch07.classes.generics.main5.sub3;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MemberView extends JFrame {

	public MemberView() {
		/** ȭ�� ������ ���� */
		this.setSize(300,300);
	
		/** ���̺� �ڷ� **/
		MemberVo v1 = new MemberVo("a001", "�輱ö");
		MemberVo v2 = new MemberVo("a002", "��̱�");
		MemberVo v3 = new MemberVo("a003", "������");
		MemberVo v4 = new MemberVo("a004", "�����");
	
		/** ���̺� ���� ����� */
		String[] header = MemberVo.getHeaderInfo();
		Object[][] data = new Object[][] {v1.getData(), v2.getData(), v3.getData(), v4.getData()};
	
		/** ���̺� ������Ʈ �������� */
		JTable table = new JTable(data, header);
		JScrollPane pane = new JScrollPane();
		pane.setViewportView(table);
	
		/** ȭ�鿡 �߰��ϱ� */
		this.add(pane);
	}
		
	public static void main(String[] args){
		MemberView view = new MemberView();
		view.setVisible(true);
	}
}
