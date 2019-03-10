package mk_LinkedList;

/**
 * 
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: LinkedList.java
* @Description: ����Ĺ�������
* Ľ���� ���ݽṹ�γ�	
* ����
* ����ṹ
* @version: v1.0.0
* @author: Administrator
* @date: 2019��3��10�� ����11:25:39 
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
	
	 // ���������Ƿ�Ϊ��
    public boolean isEmpty(){
        return size == 0;
    }
	
	public void addFirst(E e) {
		add(0,e);
	}
	 // �������index(0-based)λ������µ�Ԫ��e
    // �������в���һ�����õĲ�������ϰ�ã���
	public void add(int index,E e) {
		if(index < 0 || index > size) {
			throw new RuntimeException("�±�Խ��");
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
