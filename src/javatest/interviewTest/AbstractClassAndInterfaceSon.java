package javatest.interviewTest;

/**
 * @author youhuan
 * @date 创建时间：2017年5月31日 下午5:32:45
 * @describe:
 * @version 1.0
 */
public class AbstractClassAndInterfaceSon extends AbstractClassAndInterface implements Test1 {

	public static void main(String[] args) {
		AbstractClassAndInterfaceSon abstractClassAndInterfaceSon = new AbstractClassAndInterfaceSon();
		abstractClassAndInterfaceSon.b = 250;
		// abstractClassAndInterfaceSon.a=130;
		System.out.println(abstractClassAndInterfaceSon.b);
		System.out.println(abstractClassAndInterfaceSon.a);
	}

	@Override
	public void test() {
	}
}

class Test2 {

	
}