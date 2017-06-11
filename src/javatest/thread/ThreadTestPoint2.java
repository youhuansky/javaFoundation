package javatest.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author youhuan
 * @date 创建时间：2017年5月19日 下午9:09:56
 * @describe:callable学习
 * @version 1.0
 */
public class ThreadTestPoint2 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

//		FutureTask<String> ft = new FutureTask(new CallableTest());
//		new Thread(ft, "ftTest").start();

		new Thread(new FutureTask(new Callable<String>() {

			@Override
			public String call() throws Exception {
				System.out.println("hhahah");
				return null;
			}

		})).start();

		// String string = ft.get();
		// System.out.println(string);
	}

}

class CallableTest implements Callable<String> {

	@Override
	public String call() throws Exception {
		System.out.println("haha");
		return "CallableTest成功!";
	}
}
