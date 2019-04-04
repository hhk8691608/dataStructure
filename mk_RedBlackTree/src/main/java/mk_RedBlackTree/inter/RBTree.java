package mk_RedBlackTree.inter;

public class RBTree<K extends Comparable<K>, V> {

	private static final boolean RED = true;
	private static final boolean BLACK = false;

	private class Node {
		public K key;
		public V value;
		public Node left, right;
		public boolean color;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			left = null;
			right = null;
			color = RED;
		}
	}

	private Node root;
	private int size;

	public RBTree() {
		root = null;
		size = 0;
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	// �жϽڵ�node����ɫ
	private boolean isRed(Node node) {
		if (node == null)
			return BLACK;
		return node.color;
	}

	// �����������������µ�Ԫ��(key, value)
	public void add(K key, V value) {
		root = add(root, key, value);
	}

	// ����nodeΪ���Ķ����������в���Ԫ��(key, value)���ݹ��㷨
	// ���ز����½ڵ������������ĸ�
	private Node add(Node node, K key, V value) {

		if (node == null) {
			size++;
			return new Node(key, value);
		}

		if (key.compareTo(node.key) < 0)
			node.left = add(node.left, key, value);
		else if (key.compareTo(node.key) > 0)
			node.right = add(node.right, key, value);
		else // key.compareTo(node.key) == 0
			node.value = value;

		if (isRed(node.right) && !isRed(node.left))
			node = leftRotate(node);

		if (isRed(node.left) && isRed(node.left.left))
			node = rightRotate(node);

		if (isRed(node.left) && isRed(node.right))
			flipColors(node);

		return node;
	}

	// ������nodeΪ���ڵ�Ķ����������У�key���ڵĽڵ�
	private Node getNode(Node node, K key) {

		if (node == null)
			return null;

		if (key.equals(node.key))
			return node;
		else if (key.compareTo(node.key) < 0)
			return getNode(node.left, key);
		else // if(key.compareTo(node.key) > 0)
			return getNode(node.right, key);
	}

	public boolean contains(K key) {
		return getNode(root, key) != null;
	}

	public V get(K key) {

		Node node = getNode(root, key);
		return node == null ? null : node.value;
	}

	public void set(K key, V newValue) {
		Node node = getNode(root, key);
		if (node == null)
			throw new IllegalArgumentException(key + " doesn't exist!");

		node.value = newValue;
	}

	// node x
	// / \ ����ת / \
	// T1 x ---------> node T3
	// / \ / \
	// T2 T3 T1 T2
	private Node leftRotate(Node node) {

		Node x = node.right;

		// ����ת
		node.right = x.left;
		x.left = node;

		x.color = node.color;
		node.color = RED;

		return x;
	}

	// node x
	// / \ ����ת / \
	// x T2 -------> y node
	// / \ / \
	// y T1 T1 T2
	private Node rightRotate(Node node) {

		Node x = node.left;

		// ����ת
		node.left = x.right;
		x.right = node;

		x.color = node.color;
		node.color = RED;

		return x;
	}

	// ��ɫ��ת
	private void flipColors(Node node) {

		node.color = RED;
		node.left.color = BLACK;
		node.right.color = BLACK;
	}

}
