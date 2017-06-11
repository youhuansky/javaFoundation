package javatest.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import sun.reflect.generics.tree.VoidDescriptor;

/**
 * @author youhuan
 * @date 创建时间：2017年5月19日 下午9:09:56
 * @describe:两个线程，交替操作一个变量，该变量初始值为0，一个加一，一个减一。来十轮
 * @version 1.0
 */
public class ThreadTestPoint3 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		final Account2 account = new Account2();

		
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					account.addOne();

				}
			}
		}, "添加").start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {

					account.subOne();
				}

			}
		}, "减少").start();

	}

}

class Account {
	private static int account = 0;

	public static int getAccount() {
		return account;
	}

	public static void setAccount(int account) {
		Account.account = account;
	}

	public void addOne() {
		if (account != 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("添加帐户前" + account);
		account++;
		System.out.println("添加帐户前后" + account);
		System.out.println("--------------------------------");
		this.notify();
	}

	public synchronized void subOne() {
		if (account == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("减少帐户前" + account);
		account--;
		System.out.println("减少帐户后" + account);
		System.out.println("--------------------------------");
		this.notify();
	}

}

class Account2 {
	private static int account = 0;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public static int getAccount() {
		return account;
	}

	public static void setAccount(int account) {
		Account2.account = account;
	}

	public  void addOne() {
		try {
			lock.lock();

			if (account != 0) {
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			System.out.println("添加帐户前" + account);
			account++;
			System.out.println("添加帐户前后" + account);
			System.out.println("--------------------------------");
			condition.signalAll();
		} finally {
			lock.unlock();
		}

	}

	public  void subOne() {
		try {
			lock.lock();
			if (account == 0) {
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("减少帐户前" + account);
			account--;
			System.out.println("减少帐户后" + account);
			System.out.println("--------------------------------");
			condition.signalAll();
		} finally {
			lock.unlock();
		}

	}

}