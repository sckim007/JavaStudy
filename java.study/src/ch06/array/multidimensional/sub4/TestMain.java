package ch06.array.multidimensional.sub4;

public class TestMain {

	public static void main(String[] args) {
		/** 2차원 배열 생성 */
		String[][] array = {{"a001", "김선철", "010-1111-1111"},
							{"a002", "김미균", "010-2222-2222"},
							{"a003", "김형순", "010-3333-3333"},
							{"a003", "김범수", "010-4444-4444"}};
		
		/** 인덱스를 이용한 for문으로 접근하기 */
		for (int i = 0;i<array.length;i++) {
			for (int j = 0;j<array[i].length;j++) {
				String data = array[i][j];
				System.out.println("arr[" + i + "[]" + j + "] = " + data);
			}
		}
		
		/** 향상된 for문으로 조회 */
		System.out.println("향상된 for 문으로 조회하기");
		for (String[] array1 : array) {
			for (String s : array1) {
				System.out.println("arr 자료접근 = " + s);
			}
		}
	}
}
