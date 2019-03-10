package mk_LinkedList;

/**
 * 
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: LinkedList.java
* @Description: 该类的功能描述
* 慕课网 数据结构课程	
* 链表
* 链表结构
* @version: v1.0.0
* @author: Administrator
* @date: 2019年3月10日 上午11:25:39 
*
 */
public class DummyHeadLinkedList<E> {
	
	
	private int size ;
	private Node dummyHead;
	
	public DummyHeadLinkedList(){
		dummyHead = new Node();
        size = 0;
    }
	
	public int getSize() {
		return size;
	}
	
	 // 返回链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }
	
	public void addFirst(E e) {
		add(0,e);
	}
	 // 在链表的index(0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作，练习用：）
	public void add(int index,E e) {
		if(index < 0 || index > size) {
			throw new RuntimeException("下标越界");
		}
		Node prev = dummyHead;
		for(int i=0;i<index;i++) {
			prev = prev.next; 
		}
		prev.next = new Node(e,prev.next);
		size++;

	}
	
	public void addLast(E e) {
		add(size,e);
	}
	
	
	
	private class Node{
		
		public E e;
		public Node next;
		
		public Node(E e,Node next) {
			this.e = e;
			this.next = next;
		}
		
		public Node(E e) {
			this(e, null);
		}
		
		public Node() {
			this(null,null);
		}
		
		@Override
			public String toString() {
				return e.toString();
			}
	}

}
