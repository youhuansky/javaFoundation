package javatest.equalandhashcode;

import org.junit.internal.runners.TestMethod;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

/**
 * @author youhuan
 * @date 创建时间：2017年6月1日 上午8:15:02
 * @describe:
 * @version 1.0
 */
 class EqualAndHashcode {
	private int num;
	private String name;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void TestMethod(int testNum){
		
		System.out.println(testNum);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + num;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EqualAndHashcode other = (EqualAndHashcode) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (num != other.num)
			return false;
		return true;
	}

}

public class EqualAndHashcodeTest {
	public static void main(String[] args) {
		EqualAndHashcodeTest equalAndHashcode = new EqualAndHashcodeTest();
		int hashCode = equalAndHashcode.hashCode();
		System.out.println(hashCode);
	}
}
