package ch07.classes.element.main1;

import java.lang.reflect.Array;

public class ArrayUtil {
	/** �迭, �ڷ� --> �迭 �������� �ڷ��߰� �� �űԹ迭 ��ȯ */
	public static<T> T[] add(T[] arr, T t) {
		if (arr==null) return null;
		T[] newInstance = (T[])Array.newInstance(t.getClass(), arr.length+1);
		System.arraycopy(arr, 0, newInstance, 0, arr.length);
		newInstance[arr.length] = t;
		return newInstance;
	}
	
	/** �迭, �ε��� --> �迭 �ε��� �ڷᰡ ������ �űԹ迭 ��ȯ */
	public static<T> T[] remove(T[] arr, int removeIndex){
		if (arr==null) return null;
		if(removeIndex < 0 || removeIndex >= arr.length) return arr;
		
		T[] newInstance = (T[]) Array.newInstance(arr[0].getClass(), arr.length -1);
		int index = 0;
		for (int i=0;i<arr.length;i++) {
			if (i != removeIndex) {
				newInstance[index++] = arr[i];
			}
		}
		return newInstance;
	}
	
	/** int Ÿ�� �迭, �ڷ� --> �迭 �������� �ڷ��߰� �� �űԹ迭 ��ȯ */
	public static int[] add (int[] arr, int t) {
		if (arr==null) return null;
		int[] arr2 = new int[arr.length + 1];
		System.arraycopy(arr, 0, arr2, 0, arr.length);
		arr2[arr.length] = t;
		return arr2;
	}
	
	/** int Ÿ�� �迭, �ε��� --> �迭 �ε��� �ڷᰡ ������ �űԹ迭 ��ȯ */
	public static int[] remove(int[] arr, int removeIndex) {
		if (arr==null) return null;
		if(removeIndex < 0 || removeIndex >= arr.length) return arr;
		
		int[] newInstance = new int[arr.length -1];
		int index = 0;
		for (int i=0;i<arr.length;i++) {
			if (i != removeIndex) {
				newInstance[index++] = i;
			}
		}
		return newInstance;		
	}
}
