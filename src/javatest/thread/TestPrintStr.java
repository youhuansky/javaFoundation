package javatest.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.net.ssl.SSLException;

/**
 * @author youhuan
 * @date 创建时间：2017年5月27日 上午1:47:26
 * @describe:写两个线程，一个打印123...52,另一个打印ABCD...Z。最后12A34B56C...5152Z。实现线程之间的通讯
 * @version 1.0
 */
public class TestPrintStr {

	public static void main(String[] args) throws InterruptedException {

		final PrintStr printStr = new PrintStr();

		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 26; i++) {

					try {
						printStr.printNum();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}

			}

		}).start();

		// Thread.sleep(1000);
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 26; i++) {

					try {
						printStr.printChar();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}

			}

		}).start();

	}

}

class PrintStr {

	private int num = 1;
	private char ch = 'A';
	private int order = 1;

	private Lock lock = new ReentrantLock();
	private Condition c1 = lock.newCondition();
	private Condition c2 = lock.newCondition();

	public void printNum() throws InterruptedException {

		try {
			lock.lock();

			while (order != 1) {

				c1.await();
			}
			for (int i = 0; i < 2; i++) {
				System.out.print(num);
				num++;// 1,2,3,4,5,6
			}
			order = 2;
			c2.signal();
		} finally {
			lock.unlock();
		}

	}

	public void printChar() throws InterruptedException {

		try {
			lock.lock();

			while (order != 2) {

				c2.await();
			}
			for (int i = 0; i < 1; i++) {
				System.out.print((char) ch);
				ch++;
			}
			order = 1;
			c1.signal();
		} finally {
			lock.unlock();
		}
	}
}