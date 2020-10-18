package Algorithm;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Kruskal {
	static int n, m, p[];
	static PriorityQueue<Info> pq = new PriorityQueue<>();
	
	// 우선순위큐에 간선이 짧은 기준으로 넣기 위해
	static class Info implements Comparable<Info> {
		int st, en, w;

		public Info(int st, int en, int w) {
			super();
			this.st = st;
			this.en = en;
			this.w = w;
		}

		@Override
		public int compareTo(Info o) {
			return Integer.compare(this.w, o.w);
		}
	}

	static int find(int node) {
		if (p[node] != node) {
			p[node] = find(p[node]);
		}
		return p[node];
	}

	static void union(int a, int b) {
		if (a != b) {
			if (a < b) {
				p[b] = a;
			} else {
				p[a] = b;
			}
		}
	}

	static void kruskal() {
		int cnt = 0;
		int sum = 0;
		while (!pq.isEmpty()) {
			Info now = pq.poll();
			int st = now.st;
			int en = now.en;

			st = find(st);
			en = find(en);

			if (st != en) {
				union(st, en);
				sum += now.w;
				cnt++;
			} else {
				continue;
			}

			if (cnt == n - 1) {
				break;
			}
		}
		System.out.println(sum);
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
			int start = sc.nextInt();
			int end = sc.nextInt();
			int w = sc.nextInt();
			pq.add(new Info(start, end, w));
		}
		
		kruskal();
	}

}
