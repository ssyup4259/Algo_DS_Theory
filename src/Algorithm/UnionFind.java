package Algorithm;

import java.util.Scanner;

public class UnionFind {
	static int n, m, p[];
	
	// 현재 원소의 부모를 찾는다.
	static int find(int node) {
		if (p[node] != node) {
			p[node] = find(p[node]);
		}
		return p[node];
	}
	
	// 연결되어 있지 않을때 연결 시킨다.
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
		
		// 초기에 각 원소들의 부모는 자기 자신이다.
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
