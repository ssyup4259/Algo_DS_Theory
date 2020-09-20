package Algorithm;

import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		int[] arr = { 0, 4, 1, 3, 1, 2, 4, 1 };

		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		// 카운팅 갯수 배열
		int[] counts = new int[max + 1];
		for (int i = 0; i < arr.length; i++) {
			counts[arr[i]]++;
		}
		System.out.println(Arrays.toString(counts));

		// 누적합 배열
		int[] countSum = new int[max + 1];
		int sum = 0;
		for (int i = 0; i < counts.length; i++) {
			sum += counts[i];
			countSum[i] = sum;
		}
		System.out.println(Arrays.toString(countSum));

		// 정렬된 배열을 넣을 자리
		int[] sorted = new int[arr.length];
		// 정렬 시작
		for (int i = 0; i < arr.length; i++) {
			sorted[countSum[arr[i]] - 1] = arr[i];
			countSum[arr[i]]--;
		}
		System.out.println(Arrays.toString(sorted));
	}

}
