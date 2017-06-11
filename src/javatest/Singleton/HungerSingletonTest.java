package javatest.Singleton;

/**
 * @author youhuan
 * @date 创建时间：2017年5月22日 下午4:42:37
 * @describe:懒汉单例模式练习
 * @version 1.0
 */
public class HungerSingletonTest {
	private static HungerSingletonTest singletonTest = new HungerSingletonTest();

	private HungerSingletonTest() {

	}

	public static HungerSingletonTest getSingletonTest() {
		return singletonTest;
	}

//	public static void setSingletonTest(HungerSingletonTest singletonTest) {
//		HungerSingletonTest.singletonTest = singletonTest;
//	}


}
