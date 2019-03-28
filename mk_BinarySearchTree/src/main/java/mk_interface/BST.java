package mk_interface;

/**
 * 
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 * 
 * @ClassName: BST.java
 * @Description: 该类的功能描述 二分搜索树基本类 必须是可比较的，故采用Comparable<E> 核心思想是递归算法
 * @version: v1.0.0
 * @author: admin
 * @date: 2019年3月27日 下午3:01:18
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2019年3月27日
 *        admin v1.0.0 修改原因
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

	// 看以node为根的二分搜索树中是否包含元素e, 递归算法
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

	// 二分搜索树的前序遍历
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

	// 二分搜索树的中序遍历
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

	// 二分搜索树的后序遍历
	public void postOrder() {
		postOrder(root);
	}

	// 后序遍历以node为根的二分搜索树, 递归算法
	private void postOrder(Node node) {
		if (node == null)
			return;

		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.e);
	}

	// 寻找二分搜索树的最小元素
	public E minimum() {
		if (size == 0)
			throw new IllegalArgumentException("BST is empty");

		Node minNode = minimum(root);
		return minNode.e;
	}

	// 返回以node为根的二分搜索树的最小值所在的节点
	private Node minimum(Node node) {

		if (node.left == null) {
			return node;
		}
		return minimum(node.left);
	}

	// 寻找二分搜索树的最大元素
	public E maximum() {
		if (size == 0)
			throw new IllegalArgumentException("BST is empty");

		Node minNode = maximum(root);
		return minNode.e;
	}

	// 返回以node为根的二分搜索树的最大值所在的节点
	private Node maximum(Node node) {
		if (node.right == null) {
			return node;
		}
		return maximum(node.right);
	}

	// 删除掉以node为根的二分搜索树中的最小节点
	// 返回删除节点后新的二分搜索树的根
	public E removeMin() {
		E retE = minimum();
		root = removeMin(root);
		return retE;
	}

	// 删除掉以node为根的二分搜索树中的最小节点
	// 返回删除节点后新的二分搜索树的根
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

	// 从二分搜索树中删除最大值所在节点
	public E removeMax() {
		E retE = maximum();
		root = removeMax(root);
		return retE;
	}

	// 删除掉以node为根的二分搜索树中的最大节点
	// 返回删除节点后新的二分搜索树的根
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

	// 生成以node为根节点，深度为depth的描述二叉树的字符串
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
