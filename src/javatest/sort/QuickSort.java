package javatest.sort;

import java.util.Date;

/**
 * @author youhuan
 * @date 创建时间：2017年5月18日 下午6:19:05
 * @describe:练习快速排序
 * @version 1.0
 */
public class QuickSort {

	public static void main(String[] args) {
		// Integer[] tmp = new Integer[] { 5, 9, 1, 4, 8, 2 };
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
		System.out.println(time2 - time1);
	}

	public static Integer[] quickSort(Integer[] numberArr) {
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
			tmp1 = quickSort(tmp1);
		}
		if (tmp2.length >= 2) {
			tmp2 = quickSort(tmp2);
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
