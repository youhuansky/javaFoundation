package javatest.dynaticProxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * @author youhuan
 * @date 创建时间：2017年6月6日 下午11:11:48
 * @describe:
 * @version 1.0
 */
public class MyClassLoader extends ClassLoader {

	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		MyClassLoader mcl = new MyClassLoader();
		byte[] loadClass = mcl.loadClass();
		Class class1 = mcl.getClass(loadClass);
		Object newInstance = class1.newInstance();
		Class<? extends Object> class2 = newInstance.getClass();
		System.out.println(class2);
		Method method = class2.getMethod("sayHello", new Class[]{});
		Object invoke = method.invoke(newInstance, null);
		System.out.println(invoke);
//		System.out.println(newInstance);
	}

	public Class getClass(byte[] buff) {

		return defineClass(null,buff, 0, buff.length);
	}

	public byte[] loadClass() throws IOException {
		// D:\mywork\javacode\WorkSpace\myday19\bin\com\atguigu\javase\test\DogTest.class
		
		
		File file = new File("C:\\Users\\Administrator\\Desktop\\Hello.class");
		FileInputStream fis = new FileInputStream(file);
		byte[] buff = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		int i;
		while ((i=fis.read() )!= -1) {
			bos.write(i);
		}
		buff = bos.toByteArray();
		return buff;
	}

}
