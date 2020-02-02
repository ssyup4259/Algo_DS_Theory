package DataStructure;

import java.util.Scanner;

public class Solution {
	// 이론적인
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; ++test_case) {
			int node = sc.nextInt();
			int edge = sc.nextInt();

			Tree tree = new Tree(node);

			for (int i = 0; i < edge; i++) {
				int parent = sc.nextInt();
				int child = sc.nextInt();
				tree.addChild(parent, child);
			}
			int root = tree.getRoot();
			System.out.printf("#%d ", test_case);
			tree.preOrder(root);
			System.out.printf("\n");
		}

		sc.close();

	}

}
