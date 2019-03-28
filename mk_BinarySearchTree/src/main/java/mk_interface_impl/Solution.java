package mk_interface_impl;

/**
 * 
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 * 
 * @ClassName: Solution.java
 * @Description: 该类的功能描述 二分搜索树 操作元素 核心思想是递归算法 改进项： 1.针对终止项条件进行修改
 * @version: v1.0.0
 * @author: admin
 * @param <E>
 * @date: 2019年3月27日 下午3:11:48
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2019年3月27日
 *        admin v1.0.0 修改原因
 */
public class Solution {

	private class BST<E extends Comparable<E>> {

		private class Node {
			public E e;
			public Node left, right;

			public Node(E e) {
				this.e = e;
				left = null;
				right = null;
			}
		}

		private Node root;
		private int size;

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
//		/**
//		 * 未改进终止条件
//		 * 
//		 * @param node
//		 * @param e
//		 */
//		private void add(E e) {
//			if (root == null) {
//				root = new Node(e);
//				size++;
//			} else {
//				this.add(root, e);
//			}
//		}
//
//		/**
//		 * 未改进终止条件
//		 * 
//		 * @param node
//		 * @param e
//		 */
//		private void add(Node node, E e) {
//			if (node.e.equals(e)) {
//				return;
//			} else if (e.compareTo(node.e) < 0 && node.left == null) {
//				node.left = new Node(e);
//				size++;
//				return;
//			} else if (e.compareTo(node.e) > 0 && node.right == null) {
//				node.right = new Node(e);
//				size++;
//				return;
//			}
//
//			if (e.compareTo(node.e) < 0) {
//				add(node.left, e);
//			} else {
//				add(node.right, e);
//			}
//
//		}

		/**
		 * 改进终止条件
		 * 
		 * @param node
		 * @param e
		 */
		private void add(E e) {
			root = add(root, e);
		}

		/**
		 * 改进终止条件
		 * 
		 * @param node
		 * @param e
		 */
		private Node add(Node node, E e) {
			if (node == null) {
				node = new Node(e);
				size++;
				return node;
			}
			if (e.compareTo(node.e) < 0) {
				node.left = add(node.left, e);
			} else if (e.compareTo(node.e) > 0) {
				node.right = add(node.right, e);
			}
			return node;
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

	}

}
