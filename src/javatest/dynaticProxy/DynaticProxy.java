package javatest.dynaticProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.experimental.theories.Theories;

/**
 * @author youhuan
 * @date 创建时间：2017年6月5日 下午11:19:14
 * @describe:JDK动态代理
 * @version 1.0
 */

interface Work {

	public String doWork(String name, int age);
}

interface Play {
	public String playGame(String name);
}

class Student implements Play {

	@Override
	public String playGame(String name) {

		return name + "正在玩游戏！";
	}

}

class Teacher implements Work {

	@Override
	public String doWork(String name, int age) {

		return name + "老师，今年" + age + "岁，正在工作！";
	}

}

class MyInvocationHandler implements InvocationHandler {
	private Object obj;

	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		// 第一个Object是代理对象
		// Class clazz = (Class) arg0;
		// System.out.println(arg0);
		// Object newInstance = clazz.newInstance();
		// Object invoke = arg1.invoke(newInstance, arg2);

		return arg1.invoke(obj, arg2);
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

}

public class DynaticProxy {

	public static void main(String[] args) throws Throwable {
		InvocationHandler iHandler = new MyInvocationHandler();
		// ((MyInvocationHandler) iHandler).setObj(new Teacher());
		((MyInvocationHandler) iHandler).setObj(new Student());

		Object newProxyInstance = Proxy.newProxyInstance(Teacher.class.getClassLoader(),
				new Class[] { Work.class, Play.class }, iHandler);
		// String doWork = ((Work) newProxyInstance).doWork("11", 123);
		String doWork = ((Play) newProxyInstance).playGame("11");
		System.out.println(doWork);
	}

}