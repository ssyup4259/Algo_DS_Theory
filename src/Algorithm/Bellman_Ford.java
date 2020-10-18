package Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

import Algorithm.Dijkstra.Info;

public class Bellman_Ford {
	static int[] dist;
	static List<Info> list;
	static PriorityQueue<Info> pq;
	static int N;

	static class Info {
		int start, end, w;

		public Info(int start, int end, int w) {
			this.start = start;
			this.end = end;
			this.w = w;
		}
	}

	static void bellman() {
		// 벨만은 최대 노드의 수 N -1 만큼 수행한다.
		// 노드의 갯수가 3일때 1에서 3을 가는 것은 많아봐여 2개를 들린다는 의미
		// 이보다 수행횟수가 많다는 것은 어딘가에 음의 폐로가 존재 하여 무한히 반복된다는 뜻
		for (int v = 0; v <= N; v++) {
			// 벨만 수행 횟수가 N이 된다면 음의폐로가 존재
			if (v == N) {
				System.out.println(-1);
				return;
			}

			int flag = 0; // 변경 작업이 잇는지 체크용
			for (int i = 0; i < list.size(); i++) {
				int start = list.get(i).start;
				int end = list.get(i).end;
				int w = list.get(i).w;

				// 지금 노드가 무한대가 아니고 다음 노드가 지금 노드 + 가중치 보다 크다면 갱신
				if (dist[start] != Integer.MAX_VALUE) {
					if (dist[start] + w < dist[end]) {
						dist[end] = dist[start] + w;
						flag++; // 변경 작업 횟수 증가
					}
				}
			}

			// 변경작업이 없었다면 벨만 종료
			if (flag == 0) {
				for (int i = 2; i <= N; i++) {
					if (dist[i] == Integer.MAX_VALUE) {
						System.out.println(-1);
					} else {
						System.out.println(dist[i]);
					}
				}
				return;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int start = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			list.add(new Info(a, b, c));
		}

		for (int i = 1; i <= n; i++) {
			if (i == start) {
				dist[i] = 0;
			} else {
				dist[i] = Integer.MAX_VALUE;
			}
		}

		bellman();

		for (int i = 1; i <= n; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}

	}

}
