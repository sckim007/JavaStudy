package ch13.javafx.application_stage_scene.main4;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.layout.Pane;

public class DataContainer {
	/** ����ȭ���� �����ϱ� ���� ���� paneMap �������� ���� */
	public static final Map<Class<? extends Pane>, Pane> paneMap = new HashMap<Class<? extends Pane>, Pane>();
	
	/** ȭ���� �߰��ϱ� ���� addPane() �Լ� ���� */
	public static final void addPane(Pane pane) {
		if (pane==null) return;
		paneMap.put(pane.getClass(), pane);
	}
	
	/** ���׸����� �̿��Ͽ� �ش� Ÿ�� ��ü ��ȸ getPane() �Լ� ���� */
	public static final <T extends Pane> T getPane(Class<T> clazz) {
		return (T) paneMap.get(clazz);
	}
}
