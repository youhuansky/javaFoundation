package javatest.thread;


/**
 * @author youhuan
 * @date 创建时间：2017年5月19日 下午9:09:56
 * @describe:在main方法中创建并启动两个线程。第一个线程循环随机打印100以内的整数，直到第二个线程从键盘读取了“Q”命令。
 * @version 1.0
 */
public class ThreadTest5 {
	public static void main(String[] args) {
		Runnable runnable1 = new ThreadTest5_1();
		// Runnable runnable2 = new ThreadTest5_2();
		Thread thread1 = new Thread(runnable1, "1号");
		Thread thread2 = new Thread(runnable1, "2号");
		thread1.setPriority(5);
		thread2.setPriority(10);
		thread1.start();
		thread2.start();
		int flag=0;
		while(flag!=100){
			flag=(int) (Math.random() * 10001);
			System.out.println("主线程   :  "+flag);
		}
		//不施放锁，容易造成死锁
//		thread1.suspend();
		//让出锁
//		thread1.yield();
		while(flag!=100){
			flag=(int) (Math.random() * 10001);
			System.out.println("主线程   :  "+flag);
		}
//		thread2.yield();
		
//		try {
//			thread1.wait();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

	}
}

class ThreadTest5_1 implements Runnable {
	static boolean flag = true;
	@Override
	public  void run() {
		 while (flag) {
			 synchronized (this) {
				System.out.println(Thread.currentThread().getName() + "    :  " + (int) (Math.random() * 101));
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}