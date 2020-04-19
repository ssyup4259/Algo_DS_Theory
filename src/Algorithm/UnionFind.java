package Algorithm;

import java.util.Scanner;

public class UnionFind {
	static int n, m, p[];

	static int find(int node) {
		if (p[node] != node) {
			p[node] = find(p[node]);
		}
		return p[node];
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			if (a < b) {
				p[b] = a;
			} else {
				p[a] = b;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		p = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			p[i] = i;
		}

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			union(a, b);
		}
	}

}
