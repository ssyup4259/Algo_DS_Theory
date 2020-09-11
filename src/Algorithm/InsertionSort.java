package Algorithm;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 15, 3, 29, 32, 13, 17, 19, 22 };

		for (int i = 1; i < arr.length; i++) {
			int target = arr[i]; // 삽입해야할 원소
			int idx = i - 1; // 정렬된 구간중 비교할 위치

			// 정렬된 구간 오른쪽에서부터 왼쪽으로 한칸씩 비교하며
			// 타겟보다 클 경우 한칸씩 오른쪽으로
			while (idx >= 0 && target < arr[idx]) {
				arr[idx + 1] = arr[idx];
				idx--;
			}
			arr[idx + 1] = target;
			System.out.println(target + " : " + Arrays.toString(arr));
		}
	}

}
