package DataStructure;

public class Stack {
	static final int MAXS = 10;
	static final int S_EMPTY = MAXS;
	static final int S_FULL = 0;

	static int stack[] = new int[MAXS];
	static int sp = S_EMPTY;

	static int push(int data) {
		if (sp == S_FULL) {
			return -1;
		}
		stack[--sp] = data;
		return 1;
	}

	static int pop() {
		if (sp == S_EMPTY) {
			return -1;
		}
		int res = stack[sp];
		stack[sp++] = 0;
		return res;
	}

	public static void main(String[] args) {
		int arr[] = { -1, 2, 3, 2, 5, 4, 9 };

		for (int i = 0; i < arr.length; i++) {
			push(arr[i]);
			for (int j = 0; j < stack.length; j++) {
				System.out.print(stack[j] + " ");
			}
			System.out.println();
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println("스택에서 뺀 값 : " + pop());
			for (int j = 0; j < stack.length; j++) {
				System.out.print(stack[j] + " ");
			}
			System.out.println();
		}
	}

}
