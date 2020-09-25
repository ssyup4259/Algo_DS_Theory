package Algorithm;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = { 3, 5, 7, 13, 19, 22, 27, 44, 57, 87 };
		int target = 5; // 찾는값

		int min = 0;
		int max = arr.length - 1;
		int result = -1;

		// min이 max보다 커진다면 비교해볼 원소가 없고
		// 그때까지 간다면 찾는 값은 없는 것이다.
		while (min <= max) {
			int mid = (min + max) / 2;
			if (arr[mid] == target) {
				result = mid;
				break;
			}
			// 현재 중앙 값이 타겟보다 크다는 것은
			// 다음 비교해볼 범위는 지금 중앙 보다 작아야 한다.
			// 현재 중앙 값이 타겟보다 작다는 것은
			// 다음 비교해볼 범위는 지금 중앙보다 커야 한다.
			if (arr[mid] < target) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}
		System.out.println(result + " 인덱스");
	}

}
