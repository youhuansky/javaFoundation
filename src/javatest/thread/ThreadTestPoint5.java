package javatest.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author youhuan
 * @date 创建时间：2017年5月19日 下午9:09:56
 * @describe:线程池
 * @version 1.0
 */
public class ThreadTestPoint5 {

	private static Future<?> submit;

	public static void main(String[] args) throws InterruptedException, ExecutionException {
	
	}

	public static void FixedThreadPoolTest() {
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
		newFixedThreadPool.submit(new Runnable() {
			public void run() {
				for (int i = 0; i < 20; i++) {
					System.out.println(Thread.currentThread().getName() + "   ThreadPoolTest");
				}
			}
		});
		newFixedThreadPool.submit(new Runnable() {
			public void run() {
				for (int i = 0; i < 20; i++) {

					System.out.println(Thread.currentThread().getName() + "   ThreadPoolTest");
				}

			}
		});
		newFixedThreadPool.submit(new Runnable() {
			public void run() {
				for (int i = 0; i < 20; i++) {

					System.out.println(Thread.currentThread().getName() + "   ThreadPoolTest");
				}

			}
		});
		newFixedThreadPool.shutdown();
	}

	public static void threadTest() throws InterruptedException, ExecutionException {
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
		Future<?> submit = newFixedThreadPool.submit(new Runnable() {
			public void run() {
				for (int i = 0; i < 20; i++) {

					System.out.println(Thread.currentThread().getName() + "   ThreadPoolTest");
				}

			}
		});
		System.out.println(submit.get());
		newFixedThreadPool.submit(new Runnable() {
			public void run() {
				for (int i = 0; i < 20; i++) {

					System.out.println(Thread.currentThread().getName() + "   ThreadPoolTest");
				}

			}
		});
		newFixedThreadPool.submit(new Runnable() {
			public void run() {
				for (int i = 0; i < 20; i++) {

					System.out.println(Thread.currentThread().getName() + "   ThreadPoolTest");
				}

			}
		});
		newFixedThreadPool.shutdown();
	}

	public static void cachePoolTest() throws InterruptedException, ExecutionException {
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		Future<Integer> submit = newCachedThreadPool.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				for (int i = 0; i < 20; i++) {

					System.out.println(Thread.currentThread().getName() + "   cachePoolTest");
				}
				return 15;
			}

		});
		Future<Integer> submit3 = newCachedThreadPool.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				for (int i = 0; i < 20; i++) {

					System.out.println(Thread.currentThread().getName() + "   cachePoolTest");
				}
				return 15;
			}

		});
		Future<Integer> submit2 = newCachedThreadPool.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				for (int i = 0; i < 20; i++) {

					System.out.println(Thread.currentThread().getName() + "   cachePoolTest");
				}
				return 15;
			}

		});
		Integer integer = submit.get();
		System.out.println("result:   " + integer);
		newCachedThreadPool.shutdown();
	}

	public static void delayPool() {
		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(5);
		newScheduledThreadPool.schedule(new Runnable() {
			public void run() {
				for (int i = 0; i < 20; i++) {

					System.out.println(Thread.currentThread().getName() + "   test1");
				}
			}
		}, 3, TimeUnit.SECONDS);
		newScheduledThreadPool.schedule(new Runnable() {
			public void run() {
				for (int i = 0; i < 20; i++) {

					System.out.println(Thread.currentThread().getName() + "   test1");
				}
			}
		}, 3, TimeUnit.SECONDS);
		newScheduledThreadPool.shutdown();
	}

	public static void poolTest1() {
		ExecutorService threadPool = new ScheduledThreadPoolExecutor(5);
		threadPool.submit(new Runnable() {
			public void run() {
				for (int i = 0; i < 20; i++) {

					System.out.println(Thread.currentThread().getName() + "   test1");
				}
			}
		});
		threadPool.submit(new Runnable() {
			public void run() {
				for (int i = 0; i < 20; i++) {

					System.out.println(Thread.currentThread().getName() + "   test2");
				}
			}
		});
		threadPool.shutdown();
	}
}
