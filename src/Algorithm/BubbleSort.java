package Algorithm;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = { 15, 3, 29, 32, 13, 17, 19, 22 };
		System.out.println(Arrays.toString(arr));

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j + 1] < arr[j]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}

		System.out.println(Arrays.toString(arr));
	}
}
