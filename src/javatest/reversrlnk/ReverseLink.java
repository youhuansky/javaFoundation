package javatest.reversrlnk;

import java.util.HashMap;

/**
 * @author youhuan
 * @date 创建时间：2017年6月7日 下午12:11:00
 * @describe:反转单项链表
 * @version 1.0
 */
public class ReverseLink {
	public static void main(String[] args) {
		LinkNode n1 = new LinkNode("A");
		LinkNode n2 = new LinkNode("B");
		LinkNode n3 = new LinkNode("C");
		LinkNode n4 = new LinkNode("D");
		LinkNode n5 = new LinkNode("E");
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		LinkNode stand = n1;
		Integer num = 0;
		HashMap<Integer, Object> hashMap = new HashMap<>();

		while (stand.getNext() != null) {

			hashMap.put(num, stand.getObj());
			stand = stand.getNext();
			num++;
		}
		hashMap.put(num, stand.getObj());
		System.out.println(hashMap);
		stand = n1;

		while (stand.getNext() != null) {

			stand.setObj(hashMap.get(num));
			stand = stand.getNext();
			num--;
		}
		stand.setObj(hashMap.get(num));
		
		System.out.println(n1);
	}

}

class LinkNode {
	private Object obj;
	private LinkNode next;

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public LinkNode getNext() {
		return next;
	}

	public void setNext(LinkNode next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "LinkNode [obj=" + obj + ", next=" + next + "]";
	}

	public LinkNode(Object obj, LinkNode next) {
		super();
		this.obj = obj;
		this.next = next;
	}

	public LinkNode() {
		super();
	}

	public LinkNode(Object obj) {
		super();
		this.obj = obj;
	}

}