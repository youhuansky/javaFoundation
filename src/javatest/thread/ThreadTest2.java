package javatest.thread;

/**
 * @author youhuan
 * @date 创建时间：2017年5月19日 下午9:09:56
 * @describe:创建两个子线程，让其中一个输出1-100之间的偶数，另一个输出1-100之间的奇数。
 * @version 1.0
 */
public class ThreadTest2 {
	public static void main(String[] args) {
		Runnable runnable1 = new ThreadTest2_1();
		Runnable runnable2 = new ThreadTest2_2();
		Thread thread1= new Thread(runnable1);
		Thread thread2 = new Thread(runnable2);
		thread1.start();
		thread2.start();

	}
}

class ThreadTest2_1 implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				System.out.println("子线程1: " + i);
			}

		}
	}

}
class ThreadTest2_2 implements Runnable {
	
	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 1) {
				System.out.println("子线程2: " + i);
			}
			
		}
	}
	
}