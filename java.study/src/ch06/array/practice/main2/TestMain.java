package ch06.array.practice.main2;

import java.util.Arrays;

public class TestMain {

	public static void main(String[] args) {

		int[] array = {1,2,3,4,5};
		System.out.println("자료원본\t" + Arrays.toString(array));
		
		int[] array2 = ArrayUtil.add(array,6);
		if (array2 == null) {
			System.out.println ("return : null, so exit");
			return;
		} else {
			System.out.println("자료추가 6\t" + Arrays.toString(array2));
		}

		int[] array3 = ArrayUtil.add(array2,2,7);
		if (array3 == null) {
			System.out.println ("return : null, so exit");
			return;
		} else {
			System.out.println("중간삽입 7\t" + Arrays.toString(array3));
		}
		
		int[] array4 = ArrayUtil.remove(array3,2);
		if (array4 == null) {
			System.out.println ("return : null, so exit");
			return;
		} else {
			System.out.println("자료삭제\t" + Arrays.toString(array4));
		}
	}

}
