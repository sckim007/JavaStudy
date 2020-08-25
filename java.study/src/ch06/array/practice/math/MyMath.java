package ch06.array.practice.math;

public class MyMath {
	public static float total(int[] array) {
		float total = 0;
		for (float t : array) {
			total += t;
		}
		return total;
	}
	
	public static float ave(int[] array) {
		float total = 0;
		for (float t : array) {
			total += t;
		}
		
		float ave = total/array.length;
		
		return ave;
	}
	
	public static float variance(int[] array) {
		float total = 0;
		for (float t : array) {
			total += t;
		}
		
		float ave = total/array.length;
		
		float tt = 0;
		for (float t : array) {
			tt += Math.pow((t-ave), 2);
		}
		float variance = tt / array.length;
		
		return variance;
	}

	public static float stdev(int[] array) {
		float total = 0;
		for (float t : array) {
			total += t;
		}
		
		float ave = total/array.length;
		
		float tt = 0;
		for (float t : array) {
			tt += Math.pow((t-ave), 2);
		}
		float variance = tt / array.length;
		
		float stdev = (float)Math.sqrt((double)variance);
		
		return stdev;
	}
}
