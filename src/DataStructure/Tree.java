package DataStructure;

public class Tree {

	static final int MAX_CHILD_NUM = 2;

	class TreeNode {
		int parent;
		int[] child = new int[MAX_CHILD_NUM];

		public TreeNode(int parent) {
			this.parent = parent;
			for (int i = 0; i < MAX_CHILD_NUM; i++) {
				child[i] = -1;
			}
		}
	}

	TreeNode[] treenode;
	int nodeNum;

	public Tree(int nodeNum) {
		this.nodeNum = nodeNum;
		treenode = new TreeNode[nodeNum + 1];
		for (int i = 0; i <= nodeNum; i++) {
			treenode[i] = new TreeNode(-1);
		}
	}

	public void addChild(int parent, int child) {
		int found = -1;
		for (int i = 0; i < MAX_CHILD_NUM; i++) {
			if (treenode[parent].child[i] == -1) {
				found = i;
				break;
			}
		}
		if (found == -1)
			return;

		treenode[parent].child[found] = child;
		treenode[child].parent = parent;
	}

	public int getRoot() {
		for (int i = 1; i < nodeNum; i++) {
			if (treenode[i].parent == -1) {
				return i;
			}
		}
		return -1;
	}

	public void preOrder(int root) {
		System.out.printf("%d ", root);

		for (int i = 0; i < MAX_CHILD_NUM; i++) {
			int child = treenode[root].child[i];
			if (child != -1) {
				preOrder(child);
			}
		}
	}
}
