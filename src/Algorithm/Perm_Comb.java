package Algorithm;

import java.util.Arrays;

//순열 and 조합

public class Perm_Comb {
	static int[] arr = { 1, 2, 7, 6, 4 };
	static int[] order;
	static boolean[] visit;
	static int cnt;

	public static void main(String[] args) {
		order = new int[3];
		visit = new boolean[5];
		// solve1(0);
		// solve2(0,0);
		// solve3(0);
		cnt = 0;
		solve4(0, 0);
		System.out.println(cnt);

	}

	// 중복o, 순서o = 중복순열(111/112/121)
	static void solve1(int idx) {
		if (idx == 3) {
			System.out.println(Arrays.toString(order));
			return;
		}

		for (int i = 0; i < 5; i++) {
			order[idx] = arr[i];
			solve1(idx + 1);
		}
	}

	// 중복o, 순서x = 중복조합(111/112/122)
	static void solve2(int idx, int start) {
		if (idx == 3) {
			System.out.println(Arrays.toString(order));
			return;
		}

		for (int i = start; i < 5; i++) {
			order[idx] = arr[i];
			solve2(idx + 1, i);
		}
	}

	// 중복X, 순서O = 순열(123/132)
	static void solve3(int idx) {
		if (idx == 3) {
			System.out.println(Arrays.toString(order));
			return;
		}

		for (int i = 0; i < 5; i++) {
			if (!visit[i]) {
				visit[i] = true;
				order[idx] = arr[i];
				solve3(idx + 1);
				visit[i] = false;
			}
		}
	}

	// 중복X, 순서X = 조합(123/124/134)
	static void solve4(int idx, int start) {
		if (idx == 3) {
			System.out.println(Arrays.toString(order));
			return;
		}
		for (int i = start; i < 5; i++) {
			order[idx] = arr[i];
			solve4(idx + 1, i + 1);
		}
	}
}