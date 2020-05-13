package Algorithm;

import java.util.Arrays;

public class MergeSort {
	static int[] res;

	public static void merge(int[] arr, int left, int mid, int right) {
		int l = left; // 왼쪽 탐색 위치
		int r = mid + 1; // 오른쪽 탐색 위치
		int k = left; // 정렬된 원소 위치

		System.out.println("왼쪽 : " + left + " 오른쪽 : " + right + " : " + Arrays.toString(arr));
		// 왼쪽 오른쪽 모두 탐색이 끝나지 않았으면 계쏙
		while (l <= mid && r <= right) {
			if (arr[l] <= arr[r]) {
				res[k] = arr[l];
				l++;
			} else {
				res[k] = arr[r];
				r++;
			}
			k++;
		}

		if (l > mid) { // 왼쪽 탐색 끝, 오른쪽 남은거 모두 입력
			for (int t = r; t <= right; t++) {
				res[k] = arr[t];
				k++;
			}
		} else { // 오른쪽 탐색 끝, 왼쪽 남은거 모두 입력
			for (int t = l; t <= mid; t++) {
				res[k] = arr[t];
				k++;
			}
		}

		for (int t = left; t <= right; t++) {
			arr[t] = res[t];
		}
	}

	public static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid); // 왼쪽 부분에 대한 분할 작업 수행
			mergeSort(arr, mid + 1, right); // 오른쪽 부분에 대한 분할 작업 수행
			merge(arr, left, mid, right); // 나눠집 배열 정렬과 병합 작업 수행
		}
	}

	public static void main(String[] args) {
		int[] arr = { 19, 20, 14, 32, 28, 42, 32, 98 };
		res = new int[arr.length];
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(res));
	}

}
