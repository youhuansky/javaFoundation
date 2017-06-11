package javatest.treeSimulation;

/**
 * @author youhuan
 * @date 创建时间：2017年5月15日 上午8:01:10
 * @describe:对二叉树进行模拟
 * @version 1.0
 */
public class TreeNode {

	private Integer root;
	private TreeNode leftNode;
	private TreeNode rightNode;

	public TreeNode(Integer root) {
		this.root = root;
	}

	public TreeNode() {
	}

	public Integer getRoot() {
		return root;
	}

	public void setRoot(Integer root) {
		this.root = root;
	}

	public TreeNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}

	public TreeNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}

	public void addNode(Integer number) {
		if (root == null) {
			root = number;
		} else {

			if (number < root) {
				if (leftNode == null) {
					leftNode = new TreeNode();
					leftNode.addNode(number);
				} else {
					leftNode.addNode(number);

				}
			} else {
				if (rightNode == null) {
					rightNode = new TreeNode();
					rightNode.addNode(number);
				} else {
					rightNode.addNode(number);

				}
			}

		}

	}

	/**
	 * 
	 * @auther youhuan
	 * @Title: preOrder
	 * @Description:前序遍历
	 * @param treeNode
	 * @return void
	 */
	public void preOrder(TreeNode treeNode) {
		System.out.print(treeNode.root + " ");
		if (treeNode.leftNode != null) {
			preOrder(treeNode.leftNode);
		}
		if (treeNode.rightNode != null) {
			preOrder(treeNode.rightNode);
		}

	}

	/**
	 * 
	 * @auther youhuan
	 * @Title: inOrder
	 * @Description:中序遍历
	 * @param treeNode
	 * @return void
	 */
	public void inOrder(TreeNode treeNode) {
		if (treeNode.leftNode != null) {
			inOrder(treeNode.leftNode);

		}
		System.out.print(treeNode.root + " ");

		if (treeNode.rightNode != null) {
			inOrder(treeNode.rightNode);
		}
	}

	public void postOrder(TreeNode treeNode) {
		if (treeNode.leftNode != null) {
			postOrder(treeNode.leftNode);

		}

		if (treeNode.rightNode != null) {
			postOrder(treeNode.rightNode);
		}
		System.out.print(treeNode.root + " ");
	}

	@Override
	public String toString() {
		return "TreeNode [根节点=" + root + ", 左节点=" + leftNode + ", 右节点=" + rightNode + "]";
	}

}
