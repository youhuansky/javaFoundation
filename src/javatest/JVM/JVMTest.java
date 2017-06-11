package javatest.JVM;

import java.util.Random;

/**
 * @author youhuan
 * @date 创建时间：2017年5月25日 上午11:56:30
 * @describe:java虚拟机调优
 * @version 1.0
 */
public class JVMTest {
	public static void main(String[] args) {

		 Runtime runtime = Runtime.getRuntime();
		 long maxMemory = Runtime.getRuntime().maxMemory();
		 System.out.println(maxMemory+"字节, "+maxMemory/1024/1024+"MB");
		 long totalMemory = Runtime.getRuntime().totalMemory();
		 System.out.println(totalMemory+"字节, "+totalMemory/1024/1024+"MB");
		String str = "www.atguigu.com";
		while (true) {
			str += str + new Random().nextInt(88888888) + new Random().nextInt(999999999);
		}

	}

}
