package javatest.sort;

/**
 * @author youhuan
 * @date 创建时间：2017年6月5日 下午9:32:14
 * @describe:插入排序模拟
 * @version 1.0
 */
public class insertSort {
	public static void main(String[] args) {
//		int[] intArr=new int[]{5,9,2,4,1};
//		int[] intArr=new int[]{1,  2 , 4 , 5 , 9 };
		int[] intArr=new int[]{4,  2 , 4 , 2, 9 };
		int[] insertSort = insertSort(intArr);
		for (int i : insertSort) {
			
			System.out.print(i+"  ");
		}
	}

	public static int[] insertSort(int[] intArr) {
		int length = intArr.length;

		int tmp = 0;
		for (int i = 1; i < length; i++) {

			l1: for (int j = i; j >= 1; j--) {

				if (intArr[j - 1] >= intArr[j]) {

					tmp = intArr[j - 1];
					intArr[j - 1] = intArr[j];
					intArr[j] = tmp;

				} else {
					break l1;
				}
			}
		}

		return intArr;
	}

}
