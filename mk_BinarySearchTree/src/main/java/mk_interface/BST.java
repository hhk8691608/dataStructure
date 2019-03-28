package mk_interface;

/**
 * 
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 * 
 * @ClassName: BST.java
 * @Description: ����Ĺ������� ���������������� �����ǿɱȽϵģ��ʲ���Comparable<E> ����˼���ǵݹ��㷨
 * @version: v1.0.0
 * @author: admin
 * @date: 2019��3��27�� ����3:01:18
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2019��3��27��
 *        admin v1.0.0 �޸�ԭ��
 */

public class BST<E extends Comparable<E>> {

	private class Node {
		public E e;
		public Node left, right;

		public Node(E e) {
			this.e = e;
			left = null;
			right = null;
		}

	}

	private int size;
	private Node root;

	public BST() {
		root = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(E e) {
		if (root == null) {
			root = new Node(e);
			size++;
		} else {
			this.add(root, e);
		}
	}

	private void add(Node node, E e) {
		if (node.e.equals(e)) {
			return;
		} else if (e.compareTo(node.e) < 0 && node.left == null) {
			node.left = new Node(e);
			size++;
			return;
		} else if (e.compareTo(node.e) > 0 && node.right == null) {
			node.right = new Node(e);
			size++;
			return;
		}

		if (e.compareTo(node.e) < 0) {
			add(node.left, e);
		} else {
			add(node.right, e);
		}

	}

	public boolean contains(E e) {
		return containsOwn(root, e);
	}

	public boolean containsOwn(Node node, E e) {

		if (node == null)
			return false;

		if (e.equals(node.e)) {
			return true;
		}
		if (e.compareTo(node.e) < 0) {
			return containsOwn(node.left, e);
		} else {
			return containsOwn(node.right, e);
		}
	}

	// ����nodeΪ���Ķ������������Ƿ����Ԫ��e, �ݹ��㷨
	private boolean contains(Node node, E e) {

		if (node == null)
			return false;

		if (e.compareTo(node.e) == 0)
			return true;
		else if (e.compareTo(node.e) < 0)
			return contains(node.left, e);
		else // e.compareTo(node.e) > 0
			return contains(node.right, e);
	}

	// ������������ǰ�����
	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node node) {

		if (node != null) {
			System.out.println(node.e);
			preOrder(node.left);
			preOrder(node.right);
		}

	}

	// �������������������
	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node node) {
		if (node != null) {
			inOrder(node.left);
			System.out.println(node.e);
			inOrder(node.right);
		}
	}

	// �����������ĺ������
	public void postOrder() {
		postOrder(root);
	}

	// ���������nodeΪ���Ķ���������, �ݹ��㷨
	private void postOrder(Node node) {
		if (node == null)
			return;

		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.e);
	}

	// Ѱ�Ҷ�������������СԪ��
	public E minimum() {
		if (size == 0)
			throw new IllegalArgumentException("BST is empty");

		Node minNode = minimum(root);
		return minNode.e;
	}

	// ������nodeΪ���Ķ�������������Сֵ���ڵĽڵ�
	private Node minimum(Node node) {

		if (node.left == null) {
			return node;
		}
		return minimum(node.left);
	}

	// Ѱ�Ҷ��������������Ԫ��
	public E maximum() {
		if (size == 0)
			throw new IllegalArgumentException("BST is empty");

		Node minNode = maximum(root);
		return minNode.e;
	}

	// ������nodeΪ���Ķ��������������ֵ���ڵĽڵ�
	private Node maximum(Node node) {
		if (node.right == null) {
			return node;
		}
		return maximum(node.right);
	}

	// ɾ������nodeΪ���Ķ����������е���С�ڵ�
	// ����ɾ���ڵ���µĶ����������ĸ�
	public E removeMin() {
		E retE = minimum();
		root = removeMin(root);
		return retE;
	}

	// ɾ������nodeΪ���Ķ����������е���С�ڵ�
	// ����ɾ���ڵ���µĶ����������ĸ�
	private Node removeMin(Node node) {
		if (node.left == null) {
			Node nodeRight = node.right;
			size--;
			node.right = null;
			return nodeRight;
		}
		node.left = removeMin(node.left);
		return node;
	}

	// �Ӷ�����������ɾ�����ֵ���ڽڵ�
	public E removeMax() {
		E retE = maximum();
		root = removeMax(root);
		return retE;
	}

	// ɾ������nodeΪ���Ķ����������е����ڵ�
	// ����ɾ���ڵ���µĶ����������ĸ�
	private Node removeMax(Node node) {
		if (node.right == null) {
			Node nodeLeft = node.left;
			node.left = null;
			size--;
			return nodeLeft;
		}
		node.right = removeMax(node.right);
		return node;
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		generateBSTString(root, 0, res);
		return res.toString();
	}

	// ������nodeΪ���ڵ㣬���Ϊdepth���������������ַ���
	private void generateBSTString(Node node, int depth, StringBuilder res) {

		if (node == null) {
			res.append(generateDepthString(depth) + "null\n");
			return;
		}

		res.append(generateDepthString(depth) + node.e + "\n");
		generateBSTString(node.left, depth + 1, res);
		generateBSTString(node.right, depth + 1, res);
	}

	private String generateDepthString(int depth) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < depth; i++)
			res.append("--");
		return res.toString();
	}

}
