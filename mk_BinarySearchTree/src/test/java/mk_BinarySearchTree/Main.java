package mk_BinarySearchTree;

import mk_interface.BST;

/***
 * 
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 * 
 * @ClassName: Main.java
 * @Description: ����Ĺ������� ���������� ������
 * @version: v1.0.0
 * @author: admin
 * @date: 2019��3��27�� ����5:18:36
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2019��3��27��
 *        admin v1.0.0 �޸�ԭ��
 */
public class Main {

	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		int[] nums = { 5, 13, 6, 88, 4, -2 };
		for (int num : nums)
			bst.add(num);

		/////////////////
		// 5 //
		// / \ //
		// 3 6 //
		// / \ \ //
		// 2 4 8 //
		/////////////////
//		bst.preOrder();
//		System.out.println();

//		bst.inOrder();
//		System.out.println();
//
//		bst.postOrder();
//		System.out.println();

//		System.out.println(bst.maximum());
//		System.out.println(bst.minimum());
//		System.out.println();

		System.out.println(bst);
		System.out.println("before ..............................");

		System.out.println(bst.removeMax());
		System.out.println(bst.removeMin());
		System.out.println();

		System.out.println("after ..............................");
		System.out.println(bst);
		System.out.println();

	}

}
