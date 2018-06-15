package javatest.testpack;

import java.util.ArrayList;
import java.util.List;

import javatest.testpack.TestBean;

public class GenerationTest<T extends TestBean> {

	
	private List<? extends TestBean> list;
	

	public List<? extends TestBean> getList() {
		return list;
	}


	public void setList(List<? extends TestBean> list) {
		this.list = list;
	}

	public T getT() {
		
		T testBean = (T)list.get(0);
		return testBean;
	}

	public static void main(String[] args) {
		
		GenerationTest<TestBeanSon1> gt=	new GenerationTest<TestBeanSon1>();
		List<TestBeanSon1> arrayList = new ArrayList<TestBeanSon1>();
		TestBeanSon1 testBeanSon1 = new TestBeanSon1();
		testBeanSon1.setName("yahaha");
		arrayList.add(testBeanSon1);
		
		gt.setList(arrayList);
		
		TestBeanSon1 t = gt.getT();
		System.out.println(t.getName());
	}
	
	
}
