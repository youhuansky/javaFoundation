package javatest.interviewTest;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * @author youhuan
 * @date 创建时间：2017年5月31日 下午6:40:36
 * @describe:
 * @version 1.0
 */
public class HashSetAndTreeSet {

	public static void main(String[] args) {
		HashSet  hashSet=new HashSet();
		hashSet.add(3);
		hashSet.add(1);
		hashSet.add(2);
		hashSet.add(4);
		hashSet.add(5);
		hashSet.add(100);
		System.out.println(hashSet);
		
		TreeSet treeSet=new TreeSet();
		treeSet.add(2);
		treeSet.add(8);
		treeSet.add(5);
		treeSet.add(6);
		treeSet.add(7);
		treeSet.add(0);
		treeSet.add(111110);
		System.out.println(treeSet);
		Object first = treeSet.first();
	
		
	}
}
