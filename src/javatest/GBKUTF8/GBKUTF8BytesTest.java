package javatest.GBKUTF8;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

/**
 * @author youhuan
 * @date 创建时间：2017年5月16日 上午8:51:31
 * @describe:学习GBK编码
 * @version 1.0
 */
public class GBKUTF8BytesTest {

	public static void main(String[] args) throws UnsupportedEncodingException {

		String gbkStr = "我";
		byte[] bytes = gbkStr.getBytes("GBK");
		for (byte b : bytes) {
			System.out.print(b + " ");

		}
	}

	@Test
	public void test1() throws UnsupportedEncodingException {
		String gbkStr = "我b";
		byte[] bytes = gbkStr.getBytes("GBK");
		for (byte b : bytes) {
			System.out.print(b + " ");
		}
	}
	@Test
	public void test2() throws UnsupportedEncodingException {
		String gbkStr = "我B";
		byte[] bytes = gbkStr.getBytes("UTF-8");
		for (byte b : bytes) {
			System.out.print(b + " ");
		}
	}

	
	
}
