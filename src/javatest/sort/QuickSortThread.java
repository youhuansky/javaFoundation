package javatest.sort;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author youhuan
 * @date 创建时间：2017年5月18日 下午6:19:05
 * @describe:快速排序，在换位后，启用多线程完成递归调用quickSort，问题：匿名内部类的变量必须用final修饰。
 * @version 1.0
 */
public class QuickSortThread {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// Integer[] tmp = new Integer[] { 5, 9, 1, 4, 8, 2 };
//		Integer[] tmp = new Integer[] { 5, 9, 5, 4, 8, 2, 8, 10, 5, 4, 9, 7, 8 };
		Integer[] tmp = new Integer[] { 5, 9, 5, 4, 8, 2, 8, 10, 5, 4, 9, 7, 8 ,1,3,2,6456,52342,12312,564562,23423,123,123};
		// Integer[] tmp = new Integer[] { 67, 435, 78, 657, 34, 2, 68, 79, 90
		// };
		// Integer[] tmp = new Integer[] { 2, 4, 1 };
		// Integer[] tmp = new Integer[] { 8, 9 };
		long time1 = System.nanoTime();
		Integer[] quickSort = quickSort(tmp);
		long time2 = System.nanoTime();
		for (int i = 0; i < quickSort.length; i++) {
			System.out.print(quickSort[i] + " ");
		}
		
		System.out.println();
		System.out.println(time2-time1);
	}

	public static Integer[] quickSort(Integer[] numberArr) throws InterruptedException, ExecutionException {
		Integer stand = numberArr[0];
		Integer[] tmp = null;
		for (int j = 1; j < numberArr.length; j++) {
			tmp = new Integer[numberArr.length];
			if (stand >= numberArr[j]) {
				tmp[0] = numberArr[j];
				for (int z = 1; z <= j; z++) {
					tmp[z] = numberArr[z - 1];
				}
				for (int x = j + 1; x < numberArr.length; x++) {
					tmp[x] = numberArr[x];
				}
				numberArr = tmp;

			}

		}
		tmp = numberArr;
		Integer[] tmp1 = new Integer[0];
		Integer[] tmp2 = new Integer[0];

		for (int i = 0; i < tmp.length; i++) {
			if (tmp[i] == stand) {
				tmp1 = new Integer[i];
				for (int z = 0; z < i; z++) {
					tmp1[z] = tmp[z];
				}
				tmp2 = new Integer[tmp.length - i - 1];
				for (int x = 0; x < tmp.length - i - 1; x++) {
					tmp2[x] = tmp[x + i + 1];
				}

			}
		}

		if (tmp1.length >= 2) {

			final Integer[] tmp11 = tmp1;

			FutureTask<Integer[]> ft = new FutureTask<Integer[]>(new Callable<Integer[]>() {

				@Override
				public Integer[] call() throws Exception {

					return quickSort(tmp11);
				}
			});
			new Thread(ft, "").start();
			tmp1 = ft.get();
		}
		
		if (tmp2.length >= 2) {

			final Integer[] tmp11 = tmp2;

			FutureTask<Integer[]> ft = new FutureTask<Integer[]>(new Callable<Integer[]>() {

				@Override
				public Integer[] call() throws Exception {

					return quickSort(tmp11);
				}
			});
			new Thread(ft, "").start();
			tmp2 = ft.get();

		}

		for (int i = 0; i < tmp1.length; i++) {
			tmp[i] = tmp1[i];
		}
		tmp[tmp1.length] = stand;
		for (int i = 0; i < tmp2.length; i++) {
			tmp[tmp1.length + i + 1] = tmp2[i];
		}

		return tmp;

	}

}
