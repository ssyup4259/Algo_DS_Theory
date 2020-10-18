package Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra {
	static int[] dist;
	static List<Info>[] adj;
	static PriorityQueue<Info> pq;

	static class Info implements Comparable<Info> {
		int node, w;

		public Info(int node, int w) {
			this.node = node;
			this.w = w;
		}

		@Override
		public int compareTo(Info o) {
			return Integer.compare(this.w, o.w);
		}

	}

	static void dijkstra() {
		while (!pq.isEmpty()) {
			int nowN = pq.peek().node;
			int nowW = pq.poll().w;

			// 인접한 행렬 탐색
			for (int i = 0; i < adj[nowN].size(); i++) {
				int nextW = adj[nowN].get(i).w;
				int nextN = adj[nowN].get(i).node;

				// 가중치의 합이 원래 적힌 숫자 보다 작다면 갱신하고 우선순위큐에 삽입
				if (nowW + nextW < dist[nextN]) {
					dist[nextN] = nowW + nextW;
					pq.add(new Info(nextN, nowW + nextW));
				}
			}

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int start = sc.nextInt();
		adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			adj[a].add(new Info(b, c));
		}

		for (int i = 1; i <= n; i++) {
			if (i == start) {
				dist[i] = 0;
			} else {
				dist[i] = Integer.MAX_VALUE;
			}
		}

		dijkstra();

		for (int i = 1; i <= n; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}

}
