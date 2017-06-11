package javatest.thread;

/**
 * @author youhuan
 * @date 创建时间：2017年5月19日 下午9:09:56
 * @describe:使用两个线程交替打印1-100
 * @version 1.0
 */
public class ThreadTest6 {
	public static void main(String[] args) {
		Runnable runnable = new ThreadTest6_1();
		Thread thread = new Thread(runnable);
		Thread thread2 = new Thread(runnable);
		thread.start();
		// thread.run();
		 thread2.start();
	}

//	public void run() {
//		if (runnable != null) {
//			runnable.run();
//		}
//	}
}

class ThreadTest6_1 implements Runnable {
	private int i = 1;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	@Override
	public void run() {
		while (i <= 100) {
			synchronized (this) {
				this.notify();
				System.out.println(Thread.currentThread().getName() + ": " + i);
				i++;
				try {
					if (i <= 100) {
						this.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}