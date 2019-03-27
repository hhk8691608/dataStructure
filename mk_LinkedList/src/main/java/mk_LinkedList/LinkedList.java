package mk_LinkedList;

/**
 * 
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 * 
 * @ClassName: LinkedList.java
 * @Description: ����Ĺ������� Ľ���� ���ݽṹ�γ� ���� ��������ṹ
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2019��3��10�� ����11:25:39
 *
 */
public class LinkedList<E> {

	private int size;
	private Node head;

	public LinkedList() {
		head = null;
		size = 0;
	}

	public int getSize() {
		return size;
	}

	// ���������Ƿ�Ϊ��
	public boolean isEmpty() {
		return size == 0;
	}

	public void addFirst(E e) {
		Node node = new Node(e);
		node.next = head;
		head = node;
		size++;
	}

	public void add(int index, E e) {
		if (index < 0 || index > size) {
			throw new RuntimeException("�±�Խ��");
		}

		if (index == 0) {
			addFirst(e);
		} else {

			Node prev = head;
			for (int i = 0; i < index - 1; i++) {
				prev = prev.next;
			}
			Node node = new Node(e);
			node.next = prev.next;
			prev.next = node;
			size++;
		}
	}

	public void addLast(E e) {
		add(size, e);
	}

	public void remove(int index) {
		if (index < 0 || index > size) {
			throw new RuntimeException("�±�Խ��");
		}

	}

	private class Node {

		public E e;
		public Node next;

		public Node(E e, Node next) {
			this.e = e;
			this.next = next;
		}

		public Node(E e) {
			this(e, null);
		}

		public Node() {
			this(null, null);
		}

		@Override
		public String toString() {
			return e.toString();
		}
	}

}
