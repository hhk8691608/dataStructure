package mk_interface_impl;

/**
 * 
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 * 
 * @ClassName: Solution.java
 * @Description: ����Ĺ������� ���������� ����Ԫ�� ����˼���ǵݹ��㷨 �Ľ�� 1.�����ֹ�����������޸�
 * @version: v1.0.0
 * @author: admin
 * @param <E>
 * @date: 2019��3��27�� ����3:11:48
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2019��3��27��
 *        admin v1.0.0 �޸�ԭ��
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
//		 * δ�Ľ���ֹ����
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
//		 * δ�Ľ���ֹ����
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
		 * �Ľ���ֹ����
		 * 
		 * @param node
		 * @param e
		 */
		private void add(E e) {
			root = add(root, e);
		}

		/**
		 * �Ľ���ֹ����
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

	}

}
