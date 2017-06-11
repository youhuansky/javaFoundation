package javatest.thread;

import java.util.Scanner;

/**
 * @author youhuan
 * @date 创建时间：2017年5月19日 下午9:09:56
 * @describe:在main方法中创建并启动两个线程。第一个线程循环随机打印100以内的整数，直到第二个线程从键盘读取了“Q”命令。
 * @version 1.0
 */
public class ThreadTest4 {
	public static void main(String[] args) {
		Runnable runnable1 = new ThreadTest4_1();
		Runnable runnable2 = new ThreadTest4_2();
		Thread thread1 = new Thread(runnable1);
		Thread thread2 = new Thread(runnable2);
		thread1.start();
		thread2.start();

	}
}

class ThreadTest4_1 implements Runnable {
	static boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			System.out.println("子线程1: " + (int) (Math.random() * 101));
		}

	}

}

class ThreadTest4_2 implements Runnable {
	static boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			Scanner scanner = new Scanner(System.in);
			String next = scanner.next();
			if("q".equals(next)||"Q".equals(next)){
				flag=false;
				ThreadTest4_1.flag=false;
			}
		}

	}

}
