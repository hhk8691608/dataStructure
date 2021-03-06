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

	// 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
	public int parent(int index) {
		if (index == 0)
			throw new IllegalArgumentException("index-0 doesn't have parent.");
		return (index - 1) / 2;
	}

	// 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
	private int leftChild(int index) {
		return index * 2 + 1;
	}

	// 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
	private int rightChild(int index) {
		return index * 2 + 2;
	}

}
