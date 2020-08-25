package ch07.classes.generics.main5.sub3;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ProductView extends JFrame {
	
	public ProductView(){
		
		/** ȭ�� ������ ���� */
		this.setSize(300,300);
		
		/** ���̺� �ڷ� **/
		ProductVo v1 = new ProductVo("a001", "�Ƹ޸�ī��", 3000);
		ProductVo v2 = new ProductVo("a002", "ī���", 3500);
		ProductVo v3 = new ProductVo("a003", "ī���ī", 4000);
		
		/** ���̺� ���� ����� */
		String[] header = ProductVo.getHeaderInfo();
		Object[][] data = new Object[][] {v1.getData(), v2.getData(), v3.getData()};
		
		/** ���̺� ������Ʈ �������� */
		JTable table = new JTable(data, header);
		JScrollPane pane = new JScrollPane();
		pane.setViewportView(table);
		
		/** ȭ�鿡 �߰��ϱ� */
		this.add(pane);
		
	}
	/*
	public static void main(String[] args) {
		ProductView view = new ProductView();
		view.setVisible(true);

	}
	*/

}
