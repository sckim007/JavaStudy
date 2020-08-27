package ch13.javafx.application_stage_scene.main4;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.layout.Pane;

public class DataContainer {
	/** 메인화면을 저장하기 위한 변수 paneMap 전역변수 정의 */
	public static final Map<Class<? extends Pane>, Pane> paneMap = new HashMap<Class<? extends Pane>, Pane>();
	
	/** 화면을 추가하기 위한 addPane() 함수 정의 */
	public static final void addPane(Pane pane) {
		if (pane==null) return;
		paneMap.put(pane.getClass(), pane);
	}
	
	/** 제네릭스를 이용하여 해당 타입 객체 조회 getPane() 함수 정의 */
	public static final <T extends Pane> T getPane(Class<T> clazz) {
		return (T) paneMap.get(clazz);
	}
}
