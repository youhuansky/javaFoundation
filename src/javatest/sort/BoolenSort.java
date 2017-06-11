package javatest.sort;

/**
 * @author youhuan
 * @date 创建时间：2017年6月5日 下午10:22:40
 * @describe:冒泡排序模拟
 * @version 1.0
 */
public class BoolenSort {
	
	
	public static void main(String args[]) {
//		int[] intArr=new int[]{5,9,2,4,1};
//		int[] intArr=new int[]{1,  2 , 4 , 5 , 9 };
		int[] intArr=new int[]{4,  2 , 4 , 2, 9 };
		int[] boolenSort = boolenSort(intArr);
		for (int i : boolenSort) {
			System.out.print(i+"  ");
		}
		
	}

	public static int[] boolenSort(int[] intArr) {

		int length = intArr.length;
		int tmp = 0;
		for (int i = 0; i < length - 1; i++) {

			for (int j = 0; j < length - 1 - i; j++) {

				if (intArr[j] > intArr[j + 1]) {
					tmp = intArr[j];
					intArr[j] = intArr[j + 1];
					intArr[j + 1] = tmp;
				}

			}

		}
		return intArr;
	}
}
