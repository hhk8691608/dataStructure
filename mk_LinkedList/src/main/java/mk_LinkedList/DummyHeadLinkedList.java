package mk_LinkedList;

/**
 * 
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 * 
 * @ClassName: LinkedList.java
 * @Description: ����Ĺ������� Ľ���� ���ݽṹ�γ� ���� ����ṹ
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2019��3��10�� ����11:25:39
 *
 */
public class DummyHeadLinkedList<E> {

	private int size;
	private Node dummyHead;

	public DummyHeadLinkedList() {
		dummyHead = new Node();
		size = 0;
	}

	public int getSize() {
		return size;
	}

	// ���������Ƿ�Ϊ��
	public boolean isEmpty() {
		return size == 0;
	}

	// �������index(0-based)λ������µ�Ԫ��e
	// �������в���һ�����õĲ�������ϰ�ã���
	public void add(int index, E e) {
		if (index < 0 || index > size) {
			throw new RuntimeException("�±�Խ��");
		}
		Node prev = dummyHead.next;
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}
		prev.next = new Node(e, prev.next);
		size++;

	}

	public void addFirst(E e) {
		add(0, e);
	}

	public void addLast(E e) {
		add(size, e);
	}

	public E get(int index) {

		if (index < 0 || index > size) {
			throw new RuntimeException("�±�Խ��");
		}

		Node prev = dummyHead.next;

		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}
		return prev.e;
	}

	public E getFirst() {
		return get(0);
	}

	public E getLast() {
		return get(size);
	}

	public void set(int index, E e) {

		if (index < 0 || index > size) {
			throw new RuntimeException("�±�Խ��");
		}
		Node prev = dummyHead.next;
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}
		prev.e = e;
	}

	public boolean contains(E e) throws Exception {

		if (e == null) {
			throw new Exception("�Ƿ���ֵ");
		}
		Node prev = dummyHead.next;
		for (int i = 0; i < size; i++) {
			prev = prev.next;
			if (prev.e.equals(e)) {
				return true;
			}
		}
		return false;
	}

	public E remove(int index) {
		if (index < 0 || index >= size)
			throw new IllegalArgumentException("Remove failed. Index is illegal.");

		// E ret = findNode(index).e; // ���α���

		Node prev = dummyHead;
		for (int i = 0; i < index; i++)
			prev = prev.next;

		Node retNode = prev.next;
		prev.next = retNode.next;
		retNode.next = null;
		size--;

		return retNode.e;
	}

	public E removeLast() {
		return remove(size - 1);
	}

	public E removeFirst() {
		return remove(0);
	}

	// ��������ɾ��Ԫ��e
	public void removeElement(E e) {

		Node prev = dummyHead;
		while (prev.next != null) {
			if (prev.next.e.equals(e))
				break;
			prev = prev.next;
		}

		if (prev.next != null) {
			Node delNode = prev.next;
			prev.next = delNode.next;
			delNode.next = null;
			size--;
		}
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();

		Node cur = dummyHead.next;
		while (cur != null) {
			res.append(cur + "->");
			cur = cur.next;
		}
		res.append("NULL");

		return res.toString();
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
