package javatest.treeSimulation;

import org.junit.Test;

/**
 * @author youhuan
 * @date 创建时间：2017年5月15日 上午8:15:11
 * @describe:
 * @version 1.0
 */
public class TreeTest {

	@Test
	public void test1() {
		Integer[] consts = new Integer[] { 1,2,3,4,5 };
		// Integer[] consts=new Integer[]{5,3,6};
		// Integer[] consts=new Integer[]{5};
		System.out.println(consts.length);
		TreeNode treeNode = new TreeNode();
		for (Integer integer : consts) {
			treeNode.addNode(integer);
		}
		System.out.println(treeNode);
	}

	public static void main(String[] args) {
		
//		Integer[] consts = new Integer[] {5,3,6,4,1};
		Integer[] consts = new Integer[] {5,3,7,6,8};
		// Integer[] consts=new Integer[]{5,3,6};
		// Integer[] consts=new Integer[]{5};
		System.out.println(consts.length);
		TreeNode treeNode = new TreeNode();
		for (Integer integer : consts) {
			treeNode.addNode(integer);
		}
		System.out.println(treeNode);
//		treeNode.preOrder(treeNode);
//		treeNode.inOrder(treeNode);
		treeNode.postOrder(treeNode);
	}
}
