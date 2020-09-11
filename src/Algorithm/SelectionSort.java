package Algorithm;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 15, 3, 29, 32, 13, 17, 19, 22 };
		System.out.println(Arrays.toString(arr));

		// 첫번째 자리부터 비교 시작
		for (int i = 0; i < arr.length - 1; i++) {
			int min = arr[i];
			int min_loc = i;

			// 남은 숫자중에서 최소값을 찾는다.
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < min) {
					min = arr[j];
					min_loc = j;
				}
			}

			// 최소값을 해당하는 i번째 자리와 교환한다.
			int temp = arr[i];
			arr[i] = arr[min_loc];
			arr[min_loc] = temp;
		}

		System.out.println(Arrays.toString(arr));
	}

}
