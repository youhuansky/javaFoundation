package javatest.thread;

/**
 * @author youhuan
 * @date 创建时间：2017年5月19日 下午9:09:56
 * @describe:创建一个子线程，在线程中输出1-100之间的偶数，主线程输出1-100之间的奇数。
 * @version 1.0
 */
public class ThreadTest1 {
	public static void main(String[] args) {
		Runnable runnable = new ThreadTest1_1();
		Thread thread = new Thread(runnable);
		thread.start();
		for (int i = 1; i < 100; i++) {

			if (i % 2 == 1) {
				System.out.println("主线程: " + i);
			}
		}
	}
}

class ThreadTest1_1 implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				System.out.println("子线程: " + i);
			}

		}
	}

}