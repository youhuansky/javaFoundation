package javatest.Singleton;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import org.junit.Test;

/**
 * @author youhuan
 * @date 创建时间：2017年5月22日 下午4:45:26
 * @describe:
 * @version 1.0
 */
public class MainTest {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		boolean flag = true;
		while (flag) {
			FutureTask<LazySingletonTest> ft = new FutureTask(new Callable<LazySingletonTest>() {
				@Override
				public LazySingletonTest call() throws Exception {
					LazySingletonTest singletonTest1 = LazySingletonTest.getSingletonTest();
					return singletonTest1;
				}
			});
			FutureTask<LazySingletonTest> ft2 = new FutureTask(new Callable<LazySingletonTest>() {
				@Override
				public LazySingletonTest call() throws Exception {
					LazySingletonTest singletonTest1 = LazySingletonTest.getSingletonTest();
					return singletonTest1;
				}
			});
			FutureTask<LazySingletonTest> ft3 = new FutureTask(new Callable<LazySingletonTest>() {
				@Override
				public LazySingletonTest call() throws Exception {
					LazySingletonTest singletonTest1 = LazySingletonTest.getSingletonTest();
					return singletonTest1;
				}
			});
			new Thread(ft, "").start();
			new Thread(ft2, "").start();
			new Thread(ft3, "").start();
			System.out.println(ft.get());
			System.out.println(ft2.get());
			System.out.println(ft.get() == ft2.get());
			if (ft.get() != ft2.get()||ft.get() != ft3.get()||ft3.get() != ft2.get()) {
				flag = false;
				System.out.println("单例错误");
			}
		}
	}
	@Test
	public void lazyTest() throws InterruptedException, ExecutionException {
		boolean flag = true;
		while (flag) {
			FutureTask<LazySingletonTest> ft = new FutureTask(new Callable<LazySingletonTest>() {
				@Override
				public LazySingletonTest call() throws Exception {
					LazySingletonTest singletonTest1 = LazySingletonTest.getSingletonTest();
					return singletonTest1;
				}
			});
			FutureTask<LazySingletonTest> ft2 = new FutureTask(new Callable<LazySingletonTest>() {
				@Override
				public LazySingletonTest call() throws Exception {
					LazySingletonTest singletonTest1 = LazySingletonTest.getSingletonTest();
					return singletonTest1;
				}
			});
			new Thread(ft, "").start();
			new Thread(ft2, "").start();

			
			System.out.println(ft.get() == ft2.get());
			if (ft.get() != ft2.get()) {
				flag = false;
				System.out.println("单例错误");
			}
		}

	}

	@Test
	public void hungerTest() throws InterruptedException, ExecutionException {

		
		
		boolean flag = true;
		while (flag) {
			FutureTask<HungerSingletonTest> ft = new FutureTask(new Callable<HungerSingletonTest>() {
				@Override
				public HungerSingletonTest call() throws Exception {
					HungerSingletonTest hungerSingletonTest1 = HungerSingletonTest.getSingletonTest();
					return hungerSingletonTest1;
				}
			});
			FutureTask<HungerSingletonTest> ft2 = new FutureTask(new Callable<HungerSingletonTest>() {
				@Override
				public HungerSingletonTest call() throws Exception {
					HungerSingletonTest hungerSingletonTest1 = HungerSingletonTest.getSingletonTest();
					return hungerSingletonTest1;
				}
			});
			new Thread(ft, "").start();
			new Thread(ft2, "").start();

			
			System.out.println(ft.get() == ft2.get());
			if (ft.get() != ft2.get()) {
				flag = false;
				System.out.println("单例错误");
			}
		}
	}
}
