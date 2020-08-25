package ch07.classes.generics.main5.sub2;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MainUi extends JFrame {

	public MainUi() {
		this.setSize(300,300);
		
		/** ���� 1 : ���̺� ����� �ڷ����� �����Ѵ�. */
		String[] header = {"�׸�1", "�׸�2", "�׸�3"};
		String[][] data = {{"��11", "��12", "��13"},{"��21", "��22", "��23"},{"��31", "��32", "��33"}};
		
		/** ����2 : ���̺��� ���� �� ȭ�鿡 �߰��Ѵ�. */
		JTable table = new JTable(data, header);
		
		/** ���� 3 : ���̺� ���ѷѰ� ����� ��Ÿ������ ��ũ�� �г��� �����Ѵ�. */
		JScrollPane pane = new JScrollPane();
		
		/** ���� 4 : ���̺��� ��ũ�� �гο� �߰��Ѵ�. */
		pane.setViewportView(table);
		
		/** ���� 5 : �г��� ����ȭ�鿡 �߰��Ѵ�. */
		this.add(pane);
	}
	
	public static void main(String[] args) {
		MainUi mainUi = new MainUi();
		mainUi.setVisible(true);
	}

}
