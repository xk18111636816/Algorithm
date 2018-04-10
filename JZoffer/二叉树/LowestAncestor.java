public class LowestAncestor {

	//在二叉树中找到两个节点的最近公共祖先
	public Node lowestAncestor(Node head, Node o1, Node o2) {
		if (head == null || head == o1 || head == o2) {
			return head;
		}
		Node left = lowestAncestor(head.left, o1, o2);
		Node right = lowestAncestor(head.right, o1, o2);
		if (left != null && right != null) {
			return head;
		}
		return left != null ? left : right;
	}

	class Record1 {
		private HashMap<Node, Node> map;

		public Record1(Node head) {
			map = new HashMap<Node, Node>();
			if (head != null) {
				map.put(head, null);
			}
			setMap(head);
		}

		public void setMap(Node head) {
			if (head == null) {
				return;
			}
			if (head.left != null) {
				map.put(head.left, head);
			}
			if (head.right != null) {
				map.put(head.right, head);
			}
			setMap(head.left);
			setMap(head.right);
		}

		public Node query(Node o1, Node o2) {
			HashSet<Node> path = new HashSet<Node>();
			//将o1到根节点的路径全部保存
			while (map.containsKey(o1)) {
				path.add(o1);
				o1 = map.get(o1);
			}
			while (!path.contains(o2)) {
				o2 = map.get(o2);
			}
			return o2;
		}
	}

}