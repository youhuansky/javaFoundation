package javatest.JVM;

/**
 * @author youhuan
 * @date 创建时间：2017年6月2日 下午8:48:46
 * @describe:
 * @version 1.0
 */
public class PollTest {
	private static int Count = 5;
	private static int window = 0;
	private static Integer[] bankWorker = new Integer[] { 19, 29, 39, 49, 59 };

	public static Integer pollStart(int clientNum) {
		window += 1;
		Integer service=0;
		
		for (int i = 0; i < Count; i++) {
			if (bankWorker[i] !=null) {
				service=bankWorker[i];
			}else{
				
			}
		}

		return service;
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 15; i++) {

			Integer pollStart = pollStart(i);
			System.out.println("当前客户是：" + i + "    银行职员是：" + pollStart);
		}
	}
}
