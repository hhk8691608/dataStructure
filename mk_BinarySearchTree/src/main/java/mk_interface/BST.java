package mk_interface;

/**
 * 
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 * 
 * @ClassName: BST.java
 * @Description: ����Ĺ������� ���������������� �����ǿɱȽϵģ��ʲ���Comparable<E>
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

}
