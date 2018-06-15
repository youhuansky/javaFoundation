package javatest.testpack;

import java.util.ArrayList;
import java.util.List;

public class RefTest {
	
	
	public static void main(String[] args) {
		TestBean testBean = new TestBean();
		TestBean testBean1 = new TestBean();
		testBean.setName("123123");
		testBean1.setName("456789");
		List<TestBean> arrayList = new ArrayList<TestBean>();
		arrayList.add(testBean);
		testBean=testBean1;
		arrayList.add(testBean);
		System.out.println(arrayList);
		
		
	}
}
