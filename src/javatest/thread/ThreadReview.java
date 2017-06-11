package javatest.thread;

/**
 * @author youhuan
 * @date 创建时间：2017年5月19日 下午8:10:13
 * @describe:
 * @version 1.0
 */
public class ThreadReview {
	public static void main(String[] args) throws InterruptedException {

		Runnable runnable = new Thread2();
		Thread thread1 = new Thread(runnable);
		Thread thread2 = new Thread(runnable);
		thread1.start();
		thread1.interrupt();
//		System.out.println(thread1.isInterrupted());
		
//		thread2.start();
	}
}

class Thread2 implements Runnable {


	@Override
	public void run() {
		try {
			Thread.sleep(5000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		System.out.println("线程测试");
	}
}
