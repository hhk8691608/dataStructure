package mk_HeapAndPriorityQueue.impl;

import mk_HeapAndPriorityQueue.Array;

public class MaxHeap<E extends Comparable<E>> {

	private Array<E> data;

	public MaxHeap(int capacity) {
		data = new Array<>(capacity);
	}

	public MaxHeap() {
		this(10);
	}

	public int size() {
		return data.getSize();
	}

	public boolean isEmpty() {
		return data.isEmpty();
	}

	// ������ȫ�������������ʾ�У�һ����������ʾ��Ԫ�صĸ��׽ڵ������
	public int parent(int index) {
		if (index == 0)
			throw new IllegalArgumentException("index-0 doesn't have parent.");
		return (index - 1) / 2;
	}

	// ������ȫ�������������ʾ�У�һ����������ʾ��Ԫ�ص����ӽڵ������
	private int leftChild(int index) {
		return index * 2 + 1;
	}

	// ������ȫ�������������ʾ�У�һ����������ʾ��Ԫ�ص��Һ��ӽڵ������
	private int rightChild(int index) {
		return index * 2 + 2;
	}

}
