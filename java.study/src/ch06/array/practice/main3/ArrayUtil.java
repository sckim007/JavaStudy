package ch06.array.practice.main3;

public class ArrayUtil {
	
	/**
	 * 배역(array)의 마지막 자료를 삭제하기 위한 함수
	 * @param array
	 * @param value
	 * @return
	 */
	public static int[] add(int[] array, int value) {
		/** NullPointerExecption의 에러처리 - 기존배열 그대로 반환 */
		if (array == null) return array;
		
		int[] array2 = new int[array.length + 1];
		System.arraycopy(array, 0, array2, 0, array.length);
		array2[array2.length - 1] = value;
		return array2;
	}
	
	/**
	 * 배역(array)의 인덱스(index)의 자료를 중간 삽입하기 위한 함수
	 * @param array
	 * @param index
	 * @param value
	 * @return
	 */
	public static int[] add(int[] array, int index, int value) {
		/** NullPointerExecption의 에러처리 - 기존배열 그대로 반환 */
		if (array == null) return array;

		/** ArrayIndexOutOfBoundsException 에러처리 - 기존배열 그대로 반환 */
		if (index < 0 || index > array.length) return array;
		
		int[] array2 = new int[array.length + 1];
		int row = 0; /* 복사할 array의 인수 */
		for (int i=0;i<array2.length;i++) {
			if (i == index) {
				array2[i] = value;
			} else {
				array2[i] = array[row]; /* array의 인덱스 row를 증가시키면서 복사 */
				row++;
			}
		}
		return array2;
	}
	
	/**
	 * 배역(array)의 인덱스(index)의 자료를 삭제하기 위한 함수
	 * @param array
	 * @param index
	 * @return
	 */
	public static int[] remove(int[] array, int index) {

		/** NullPointerExecption의 에러처리 - 기존배열 그대로 반환 */
		if (array == null) return array;

		/** ArrayIndexOutOfBoundsException 에러처리 - 기존배열 그대로 반환 */
		if (index < 0 || index > array.length) return array;
		
		int[] array2 = new int[array.length -1];
		int row = 0; /** 복사할 array의 인덱스 */
		for (int i=0;i<array.length;i++) {
			if (i != index) {
				array2[row] = array[i]; /** array의 인덱스 row를 증가시키면서 복사 */
				row ++;
			}
		}
		return array2;
	}
}
