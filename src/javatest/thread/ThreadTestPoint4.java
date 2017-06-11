package javatest.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author youhuan
 * @date 创建时间：2017年5月19日 下午9:09:56
 * @describe:三个线程，顺序访问进行协作配合 A打印5次，B打印10次，C打印15次,共计20轮
 * @version 1.0
 */
public class ThreadTestPoint4 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		final ShareResource shareResource = new ShareResource();

		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					try {
						shareResource.loopA();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}, "AA").start();

		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					try {
						shareResource.loopB();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}, "BB").start();

		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					try {
						shareResource.loopC();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}, "CC").start();

	}

}

class ShareResource {
	private String threadName = "AA";
	private Lock lock = new ReentrantLock();
	Condition condition1 = lock.newCondition();
	Condition condition2 = lock.newCondition();
	Condition condition3 = lock.newCondition();

	public void loopA() {

		try {
			lock.lock();

			while (!"AA".equals(threadName)) {
				condition1.await();

			}
			for (int i = 1; i <= 5; i++) {
				System.out.println(Thread.currentThread().getName() + "   打印" + i);
			}
			threadName = "BB";
			condition2.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

	public void loopB() {

		try {
			lock.lock();

			while (!"BB".equals(threadName)) {

				condition2.await();
			}
			for (int i = 1; i <= 10; i++) {
				System.out.println(Thread.currentThread().getName() + "   打印" + i);

			}
			threadName = "CC";
			condition3.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

	public void loopC() {

		try {
			lock.lock();

			while (!"CC".equals(threadName)) {
				condition3.await();

			}
			for (int i = 1; i <= 15; i++) {
				System.out.println(Thread.currentThread().getName() + "   打印" + i);
			}

			threadName = "AA";
			condition1.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}
}
// public void loop() throws InterruptedException {
//
// try {
// lock.lock();
//
// while ("AA".equals(threadName)) {
// for (int i = 1; i <= 5; i++) {
// System.out.println(Thread.currentThread().getName() + " 打印" + i);
//
// }
// threadName = "BB";
// condition1.await();
// condition2.signal();
// }
//
// while ("BB".equals(threadName)) {
// for (int i = 1; i <= 10; i++) {
// System.out.println(Thread.currentThread().getName() + " 打印" + i);
//
// }
// threadName = "CC";
// condition2.await();
// condition3.signal();
// }
//
// while ("CC".equals(threadName)) {
//
// for (int i = 1; i <= 15; i++) {
// System.out.println(Thread.currentThread().getName() + " 打印" + i);
//
// }
// threadName = "AA";
// condition3.await();
// condition1.signal();
// }
//
// } finally {
// lock.unlock();
// }
//
// }
