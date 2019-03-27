package mk_LinkedList;

/**
 * 
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 * 
 * @ClassName: LinkedList.java
 * @Description: 该类的功能描述 慕课网 数据结构课程 链表 基本链表结构
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2019年3月10日 上午11:25:39
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

	// 返回链表是否为空
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
			throw new RuntimeException("下标越界");
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
			throw new RuntimeException("下标越界");
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
