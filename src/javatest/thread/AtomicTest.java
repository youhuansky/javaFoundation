package javatest.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author youhuan
 * @date 创建时间：2017年6月2日 上午12:26:20
 * @describe:
 * @version 1.0
 */
public class AtomicTest {
	public static void main(String[] args) {
  
	AtomicInteger atomicInteger = new AtomicInteger(100);
	int andIncrement = atomicInteger.getAndIncrement();
	System.out.println(andIncrement);
	int incrementAndGet = atomicInteger.incrementAndGet();
	System.out.println(incrementAndGet);
	
	}
}
