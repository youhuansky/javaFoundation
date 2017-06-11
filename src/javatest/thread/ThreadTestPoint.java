package javatest.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author youhuan
 * @date 创建时间：2017年5月19日 下午9:09:56
 * @describe:三个售票员卖30张票
 * @version 1.0
 */
public class ThreadTestPoint {

	public static void main(String[] args) {
		final SaleTicket saleTicket = new SaleTicket();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (saleTicket.getTicketCount() > 0) {
					saleTicket.saleTicket();
				}
			}
		}, "售票员1号");

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (saleTicket.getTicketCount() > 0) {
					saleTicket.saleTicket();
				}
			}
		}, "售票员2号");

		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (saleTicket.getTicketCount() > 0) {
					saleTicket.saleTicket();
				}
			}
		}, "售票员3号");

		t1.start();
		t2.start();
		t3.start();
	}

}

class SaleTicket {
	private int ticketCount = 30;
	private Lock lock = new ReentrantLock();

	public int getTicketCount() {
		return ticketCount;
	}

	public void setTicketCount(int ticketCount) {
		this.ticketCount = ticketCount;
	}

	public void saleTicket() {
		try {
			lock.lock();
			if (ticketCount > 0) {
				ticketCount--;

				System.out.println(Thread.currentThread().getName() + "   卖出了一张票!还剩" + ticketCount + "张票");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

}

// class SaleTicket {
// private int ticketCount = 30;
//
// public int getTicketCount() {
// return ticketCount;
// }
//
// public void setTicketCount(int ticketCount) {
// this.ticketCount = ticketCount;
// }
//
// public void saleTicket() {
// synchronized (Runtime.getRuntime()) {
// Runtime.getRuntime().notify();
// if (ticketCount > 0) {
// ticketCount--;
// System.out.println(Thread.currentThread().getName() + " 卖出了一张票!还剩" +
// ticketCount + "张票");
// try {
// if (ticketCount > 0) {
// Runtime.getRuntime().wait();
// }
// } catch (InterruptedException e) {
// e.printStackTrace();
// }
// }
// }
// }
//
// }