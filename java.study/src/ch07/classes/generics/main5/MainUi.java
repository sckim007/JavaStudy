package ch07.classes.generics.main5;

import javax.swing.JFrame;

public class MainUi extends JFrame {
	public MainUi() {
		this.setSize(300,300);
	}
	
	public static void main(String[] args) {
		MainUi mainUi = new MainUi();
		mainUi.setVisible(true);
	}
}
