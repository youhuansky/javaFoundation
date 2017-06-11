package javatest.sort;

import java.util.LinkedList;

/**
 * @author youhuan
 * @date 创建时间：2017年6月5日 下午8:43:12
 * @describe:两个有序的LinkedList的合并，合并之后的LinkedList还是有序的
 * @version 1.0
 */
public class TwoSortedLinkedListCombination {
	public static void main(String[] args) {
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		l1.add(1);
		l1.add(2);
		l1.add(5);
		l1.add(7);
		l1.add(9);
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		l2.add(2);
		l2.add(3);
		l2.add(4);
		l2.add(5);
		l2.add(99);
		l2.add(100);
		l2.add(122);
		l2.add(133);
		LinkedList<Integer> linkCombination = LinkCombination(l1, l2);
		System.out.println(linkCombination);
	}

	public static LinkedList<Integer> LinkCombination(LinkedList<Integer> l1, LinkedList<Integer> l2) {
		int length1 = l1.size();
		int length2 = l2.size();
		LinkedList<Integer> l3 = new LinkedList<Integer>();
		int i = 0;
		int j = 0;
		for (; i < length1;) {
			for (; j < length2;) {
				if (i == length1) {
					l3.add(l2.get(j));
					j++;
				} else {
					if (l1.get(i) > l2.get(j)) {
						l3.add(l2.get(j));
						j++;
					} else {
						l3.add(l1.get(i));
						i++;
					}
				}
			}
			if (j == length2 && i != length1) {
				l3.add(l1.get(i));
				i++;
			}
		}
		return l3;
	}
}
