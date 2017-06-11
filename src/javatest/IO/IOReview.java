package javatest.IO;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/**
 * @author youhuan
 * @date 创建时间：2017年5月19日 下午6:28:11
 * @describe:
 * @version 1.0
 */
public class IOReview {
	/**
	 * 
	 * @auther youhuan
	 * @Title: test1
	 * @Description:将两个文件的单词交替打印到第三个文件中
	 * @return void
	 */
	@Test
	public void test1() {
		FileReader fileReader1 = null;
		FileReader fileReader2 = null;
		FileWriter fileWriter1 = null;
		BufferedReader bReader1 = null;
		BufferedReader bReader2 = null;
		BufferedWriter bWriter1 = null;
		try {
			fileReader1 = new FileReader("D:\\mywork\\javacode\\WorkSpace\\javaFoundation\\iofile\\a.txt");
			fileReader2 = new FileReader("D:\\mywork\\javacode\\WorkSpace\\javaFoundation\\iofile\\b.txt");
			fileWriter1 = new FileWriter("D:\\mywork\\javacode\\WorkSpace\\javaFoundation\\iofile\\c.txt");
			bReader1 = new BufferedReader(fileReader1);
			bReader2 = new BufferedReader(fileReader2);
			bWriter1 = new BufferedWriter(fileWriter1);
			String readLine1 = bReader1.readLine();
			String readLine2 = bReader2.readLine();
			// char[] cs1 = new char[8192];
			// char[] cs2 = new char[8192];
			// int read1 = fileReader1.read(cs1);
			// int read2 = fileReader2.read(cs2);
			// 现将a当中的单词打印到c中
			// while (read1 != -1 || read2 != -1) {
			// fileWriter1.write(cs1, 0, read1);
			// read1 = fileReader1.read(cs1);
			// }
			while (readLine1 != null || readLine2 != null) {
				bWriter1.write(readLine1);
				bWriter1.newLine();
				bWriter1.write(readLine2);
				bWriter1.newLine();

				bWriter1.flush();
				readLine1 = bReader1.readLine();
				readLine2 = bReader2.readLine();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			if (fileReader1 != null) {
				try {
					fileReader1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fileReader2 != null) {
				try {
					fileReader2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fileWriter1 != null) {
				try {
					fileWriter1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bReader1 != null) {
				try {
					bReader1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bReader2 != null) {
				try {
					bReader2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bWriter1 != null) {
				try {

					bWriter1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}

	/**
	 * 
	 * @auther youhuan
	 * @Title: test2
	 * @Description:将某个文件夹当中的.java文件复制到另一个文件夹，并且文件后缀改为.jad。
	 * @return void
	 */
	@Test
	public void test2() {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		File file = null;
		try {
			file = new File("E:\\java");
			File[] listFiles = file.listFiles();
			for (File file2 : listFiles) {
				if (file2.getName().contains(".java")) {
					fis = new FileInputStream(file2.getPath());
					byte[] buffer = new byte[8192];
					int read = fis.read(buffer);
					fos = new FileOutputStream("E:\\jad\\" + file2.getName().split("\\.")[0] + ".jad");
					fos.write(buffer, 0, buffer.length);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
