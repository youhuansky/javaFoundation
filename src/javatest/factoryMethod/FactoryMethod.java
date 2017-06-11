package javatest.factoryMethod;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author youhuan
 * @date 创建时间：2017年6月5日 下午10:52:00
 * @describe:
 * @version 1.0
 */

class Dog{
	private int age;
	private String name;
	@Override
	public String toString() {
		return "Dog [age=" + age + ", name=" + name + "]";
	}
	public Dog(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	
	
}

public class FactoryMethod {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		Dog bean = getBean(Dog.class);
		System.out.println(bean);
	
	
	
	}

	public static <T> T getBean(Class<T> t) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		Constructor<T> constructor = t.getConstructor(int.class,String.class);
		T newInstance = constructor.newInstance(1,"asd");
		return newInstance;
	}

}
