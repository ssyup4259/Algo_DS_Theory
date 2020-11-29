package DataStructure;

public class Queue_Linear {
	static final int MAXQ = 10;
	static final int Q_EMPTY = 0;
	static final int Q_FULL = MAXQ;

	static int queue[] = new int[MAXQ];
	static int wr = 0;
	static int rd = 0;

	// 성공하며 1, 실패하면 -1 리턴
	static int push(int data) {
		// wr포인터가 꽉찬 상태이면
		if (wr == Q_FULL) {
			// rd포인터가 맨 첫칸이면 wr, rd 사이에 모든 공간에 데이터가 있는 것이고
			// 꽉찬상태이다.
			if (rd == Q_EMPTY) {
				return -1;
			}

			// rd 포인터를 가장 앞으로 땡겨오고 그만큼 데이터과 wr포인터를 땡겨온다
			// 비어진 앞공간을 채우는 것이다.
			for (int i = 0; i < (wr - rd); i++) {
				queue[i] = queue[rd + i];
			}

			wr -= rd;
			rd = Q_EMPTY;
		}
		queue[wr++] = data;
		return 1;
	}

	// 큐가 비어있따면 -1, 성공하면 그 값을 리턴
	static int pop() {
		// 큐가 비어 있는 상태
		if (rd == wr) {
			return -1;
		}
		int res = queue[rd];
		queue[rd++] = 0;
		return res;
	}

	public static void main(String[] args) {
		int arr[] = { -1, 2, 3, 2, 5, 4, 9 };

		for (int i = 0; i < arr.length; i++) {
			push(arr[i]);
			for (int j = 0; j < queue.length; j++) {
				System.out.print(queue[j] + " ");
			}
			System.out.println();
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println("큐에서 뺀 값 : " + pop());
			System.out.println("wr : " + wr + " rd  : " + rd);
		}

	}

}
