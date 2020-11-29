package DataStructure;

public class Queue_Circular {
	static final int MAXQ = 10;
	static final int Q_EMPTY = 0;
	static final int Q_FULL = MAXQ;

	static int queue[] = new int[MAXQ + 1];
	static int wr = 0;
	static int rd = 0;

	// 성공하며 1, 실패하면 -1 리턴
	static int push(int data) {
		// wr과 rd 가 원형큐 이기에 어느 것이 앞인지 모르는 경우가 발생한다
		// 이를 위해 한칸을 빈공간으로 둔다.
		// wr 포인터 옆에 rd가 오면 꽉찬 상태
		if ((wr + 1) % MAXQ == rd) {
			return -1;
		}
		queue[wr++] = data;
		wr %= MAXQ;
		return 1;
	}

	// 큐가 비어있따면 -1, 성공하면 그 값을 리턴
	static int pop() {
		// 큐가 비어 있는 상태
		if (rd == wr) {
			return -1;
		}
		int res = queue[rd++];
		rd %= MAXQ;
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
