package ch07.classes.generics.main5.sub2;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MainUi extends JFrame {

	public MainUi() {
		this.setSize(300,300);
		
		/** 절차 1 : 테이블 헤더와 자료목록을 구성한다. */
		String[] header = {"항목1", "항목2", "항목3"};
		String[][] data = {{"값11", "값12", "값13"},{"값21", "값22", "값23"},{"값31", "값32", "값33"}};
		
		/** 절차2 : 테이블을 생성 후 화면에 추가한다. */
		JTable table = new JTable(data, header);
		
		/** 절차 3 : 테이블에 스ㅡ롤과 헤더가 나타나도록 스크롤 패널을 생성한다. */
		JScrollPane pane = new JScrollPane();
		
		/** 절차 4 : 테이블을 스크롤 패널에 추가한다. */
		pane.setViewportView(table);
		
		/** 절차 5 : 패널을 메인화면에 추가한다. */
		this.add(pane);
	}
	
	public static void main(String[] args) {
		MainUi mainUi = new MainUi();
		mainUi.setVisible(true);
	}

}
