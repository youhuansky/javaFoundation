package javatest.treeSimulation;

/**
 * @author youhuan
 * @date 创建时间：2017年6月7日 下午1:00:45
 * @describe:
 * @version 1.0
 */
public class ThreeTreeNode {
	public static void main(String[] args) {
		ThreeTreeNode t1 = new ThreeTreeNode(1);
		ThreeTreeNode t2 = new ThreeTreeNode(2);
		ThreeTreeNode t3 = new ThreeTreeNode(3);
		ThreeTreeNode t4 = new ThreeTreeNode(4);
		ThreeTreeNode t5 = new ThreeTreeNode(5);
//		ThreeTreeNode t6 = new ThreeTreeNode(6);
		ThreeTreeNode t7 = new ThreeTreeNode(7);
		t1.setLeftNode(t2);
		t1.setRightNode(t3);
		t2.setLeftNode(t4);
		t2.setRightNode(t5);
//		t3.setLeftNode(t6);
		t3.setRightNode(t7);
		System.out.println(t1);

		reverseLeftNode(t1);
		// reverseRightNode(t1);
		System.out.println(t1);

	}

	private Integer root;
	private ThreeTreeNode leftNode;
	private ThreeTreeNode middleNode;
	private ThreeTreeNode rightNode;
	private static Object tmpNode;

	public static void reverseLeftNode(ThreeTreeNode ttn) {
		if (ttn.leftNode != null) {
			reverseLeftNode(ttn.leftNode);
			tmpNode = ttn.leftNode;
			ttn.leftNode = ttn.rightNode;
			ttn.rightNode = (ThreeTreeNode) tmpNode;
		} else if (ttn.rightNode != null) {
			reverseLeftNode(ttn.rightNode);
			tmpNode = ttn.rightNode;
			ttn.rightNode = ttn.leftNode;
			ttn.leftNode = (ThreeTreeNode) tmpNode;
		}

	}

	// public static void reverseRightNode(ThreeTreeNode ttn) {
	// if (ttn.rightNode != null) {
	//
	// reverseRightNode(ttn.rightNode);
	// }
	// tmpNode = ttn.rightNode;
	// ttn.rightNode = ttn.leftNode;
	// ttn.leftNode = (ThreeTreeNode) tmpNode;
	// }

	public Integer getRoot() {
		return root;
	}

	public void setRoot(Integer root) {
		this.root = root;
	}

	public ThreeTreeNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(ThreeTreeNode leftNode) {
		this.leftNode = leftNode;
	}

	public ThreeTreeNode getMiddleNode() {
		return middleNode;
	}

	public void setMiddleNode(ThreeTreeNode middleNode) {
		this.middleNode = middleNode;
	}

	public ThreeTreeNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(ThreeTreeNode rightNode) {
		this.rightNode = rightNode;
	}

	public ThreeTreeNode(Integer root) {
		super();
		this.root = root;
	}

	public ThreeTreeNode() {
		super();
	}

	@Override
	public String toString() {
		return "ThreeTreeNode [root=" + root + ", leftNode=" + leftNode + ", rightNode=" + rightNode + "]";
	}

}
