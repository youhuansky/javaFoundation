package javatest.interviewTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author youhuan
 * @date 创建时间：2017年5月27日 上午12:48:11
 * @describe:用户输入一个整型的数字，将数字倒序输出
 * @version 1.0
 */
public class IntTest {
	private static Object[] ch1;

	public static void main(String[] args) {

		System.out.println(reverseInt(1234));
	}

	public static int reverseInt(int num) {

		String valueOf = String.valueOf(num);

		char[] charArr = valueOf.toCharArray();
		// char tmp;
		// for (int i = 0; i < charArr.length / 2; i++) {
		// tmp = charArr[i];
		// charArr[i] = charArr[charArr.length - i - 1];
		// charArr[charArr.length - i - 1] = tmp;
		// }
		// System.out.println();

		List list = new ArrayList<Character>();
		for (int i = 0; i < charArr.length; i++) {

			list.add(charArr[i]);
		}
		Collections.reverse(list);
		Character[] ch1 = new Character[] {};
		ch1 = (Character[]) list.toArray(ch1);
		String str1 = "";
		for (Character character : ch1) {
			str1 += character + "";
		}
		return Integer.parseInt(String.valueOf(str1));
	}

}
