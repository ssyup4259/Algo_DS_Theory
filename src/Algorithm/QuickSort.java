package Algorithm;

import java.util.Arrays;

public class QuickSort {

	static int partition(int[] arr, int left, int right) {
		int pivot = arr[(left + right) / 2];
		while (left <= right) {
			// 피봇 보다 큰 원소 찾기
			while (arr[left] < pivot) {
				left++;
			}
			// 피봇 보다 작은 원소 찾기
			while (arr[right] > pivot) {
				right--;
			}
			// 찾은 원소들의 자리 변경
			if (left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static void quickSort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}

		int mid = partition(arr, left, right);
		quickSort(arr, left, mid - 1);
		quickSort(arr, mid, right);
	}

	public static void main(String[] args) {
		int[] arr = { 3, 5, 19, 3, 87, 32, 37 };
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}
