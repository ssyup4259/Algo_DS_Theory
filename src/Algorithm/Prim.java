package Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prim {
	static int n, m;
	static boolean[] visit;
	static List<Info>[] adj;
	static PriorityQueue<Info> pq = new PriorityQueue<>();

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

	static void prim() {
		int cnt = 0;
		int sum = 0;

		int start = 1; // 시작 노드 무작위(어차피 최소 스패닝 트리는 모든 노드를 거쳐야한다.)
		visit[start] = true;
		for (int i = 0; i < adj[start].size(); i++) { // 시작노드와 인접 노드를 힙에 저장
			Info now = adj[start].get(i);
			pq.add(now);
		}

		while (!pq.isEmpty()) {
			Info now = pq.poll();
			int st = now.st;
			int en = now.en;

			if (visit[en]) { // 만약 방문하여 연결 시킨 노드라면 패스
				continue;
			}

			visit[en] = true;
			cnt++;
			sum += now.w;
			if (cnt == n - 1) { // 최소스패닝트리는 노드 n에 대하여 n-1개의 간선 연결
				break;
			}

			for (int i = 0; i < adj[en].size(); i++) { // 다음 노드에 인접한 노드들을 힙에 저장
				Info next = adj[en].get(i);
				pq.add(next);
			}
		}
		System.out.println(sum);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		visit = new boolean[n + 1];
		adj = new ArrayList[n + 1]; // 인접 행렬
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int w = sc.nextInt();
			adj[start].add(new Info(start, end, w)); // 양방향
			adj[end].add(new Info(end, start, w));
		}

		prim();
	}

}
