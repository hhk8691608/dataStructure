package avl_tree_inter;

import java.util.ArrayList;

public class AVLTree<K extends Comparable<K>, V> {

	private class Node {
		public K key;
		public V value;
		public Node left, right;
		public int height;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			left = null;
			right = null;
			height = 1;
		}

	}

	private Node root;
	private int size;

	public AVLTree() {
		root = null;
		size = 0;
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	// �жϸö������Ƿ���һ�ö���������
	public boolean isBST() {

		ArrayList<K> keys = new ArrayList<>();
		inOrder(root, keys);
		for (int i = 1; i < keys.size(); i++)
			if (keys.get(i - 1).compareTo(keys.get(i)) > 0)
				return false;
		return true;

	}

	private void inOrder(Node node, ArrayList<K> keys) {

		if (node == null)
			return;

		inOrder(node.left, keys);
		keys.add(node.key);
		inOrder(node.right, keys);
	}

	// ��ýڵ�node��ƽ������
	private int getBalanceFactor(Node node) {
		if (node == null) {
			return 0;
		}
		return getHeight(node.left) - getHeight(node.right);
	}

	// �жϸö������Ƿ���һ��ƽ�������
	public boolean isBalanced() {
		return isBalanced(root);
	}

	// �ж���NodeΪ���Ķ������Ƿ���һ��ƽ����������ݹ��㷨
	private boolean isBalanced(Node node) {

		if (node == null)
			return true;

		int balanceFactor = getBalanceFactor(node);
		if (Math.abs(balanceFactor) > 1)
			return false;
		return isBalanced(node.left) && isBalanced(node.right);
	}

	private int getHeight(Node node) {
		if (node == null)
			return 0;
		return node.height;
	}

	public void add(K key, V value) {
		root = add(root, key, value);
	}

	private Node add(Node node, K key, V value) {

		if (node == null) {
			size++;
			return new Node(key, value);
		}

		if (key.compareTo(node.key) < 0) {
			node.left = add(node.left, key, value);
		} else if (key.compareTo(node.key) > 0) {
			node.right = add(node.right, key, value);
		} else {
			node.value = value;
		}

		// ����height
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

		// ����ƽ������
		int balanceFactor = getBalanceFactor(node);
		if (Math.abs(balanceFactor) > 1)
			System.out.println("unbalanced : " + balanceFactor);

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

	// ������nodeΪ���Ķ�������������Сֵ���ڵĽڵ�
	private Node minimum(Node node) {
		if (node.left == null)
			return node;
		return minimum(node.left);
	}

	// ɾ������nodeΪ���Ķ����������е���С�ڵ�
	// ����ɾ���ڵ���µĶ����������ĸ�
	private Node removeMin(Node node) {

		if (node.left == null) {
			Node rightNode = node.right;
			node.right = null;
			size--;
			return rightNode;
		}

		node.left = removeMin(node.left);
		return node;
	}

	// �Ӷ�����������ɾ����Ϊkey�Ľڵ�
	public V remove(K key) {

		Node node = getNode(root, key);
		if (node != null) {
			root = remove(root, key);
			return node.value;
		}
		return null;
	}

	private Node remove(Node node, K key) {

		if (node == null)
			return null;

		if (key.compareTo(node.key) < 0) {
			node.left = remove(node.left, key);
			return node;
		} else if (key.compareTo(node.key) > 0) {
			node.right = remove(node.right, key);
			return node;
		} else { // key.compareTo(node.key) == 0

			// ��ɾ���ڵ�������Ϊ�յ����
			if (node.left == null) {
				Node rightNode = node.right;
				node.right = null;
				size--;
				return rightNode;
			}

			// ��ɾ���ڵ�������Ϊ�յ����
			if (node.right == null) {
				Node leftNode = node.left;
				node.left = null;
				size--;
				return leftNode;
			}

			// ��ɾ���ڵ�������������Ϊ�յ����

			// �ҵ��ȴ�ɾ���ڵ�����С�ڵ�, ����ɾ���ڵ�����������С�ڵ�
			// ������ڵ㶥���ɾ���ڵ��λ��
			Node successor = minimum(node.right);
			successor.right = removeMin(node.right);
			successor.left = node.left;

			node.left = node.right = null;

			return successor;
		}
	}

	public static void main(String[] args) {

		System.out.println("Pride and Prejudice");

		ArrayList<String> words = new ArrayList<>();
//		if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
//			System.out.println("Total words: " + words.size());
//
//			AVLTree<String, Integer> map = new AVLTree<>();
//			for (String word : words) {
//				if (map.contains(word))
//					map.set(word, map.get(word) + 1);
//				else
//					map.add(word, 1);
//			}
//
//			System.out.println("Total different words: " + map.getSize());
//			System.out.println("Frequency of PRIDE: " + map.get("pride"));
//			System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
//		}

		System.out.println();
	}

}
