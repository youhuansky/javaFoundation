package javatest.Singleton;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author youhuan
 * @date 创建时间：2017年5月22日 下午4:42:37
 * @describe:懒汉单例模式练习
 * @version 1.0
 */
public class LazySingletonTest {
	private static LazySingletonTest singletonTest = null;
	private static Lock lock = new ReentrantLock();

	private LazySingletonTest() {

	}

//	public static LazySingletonTest getSingletonTest() {
//		try {
//			lock.lock();
//			if (singletonTest == null) {
//
//				singletonTest = new LazySingletonTest();
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			lock.unlock();
//		}
//
//		return singletonTest;
//	}

	public static LazySingletonTest getSingletonTest() {
		synchronized (Runtime.getRuntime()) {
			if (singletonTest == null) {

				// synchronized (Thread.currentThread()) {
				singletonTest = new LazySingletonTest();
			}

		}
		return singletonTest;
	}

}
