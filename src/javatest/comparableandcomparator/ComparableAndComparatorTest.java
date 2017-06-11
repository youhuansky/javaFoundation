package javatest.comparableandcomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

/**
 * @author youhuan
 * @date 创建时间：2017年6月9日 上午10:17:12
 * @describe:
 * @version 1.0
 */
public class ComparableAndComparatorTest {

	@Test
	public void test2() {
		Dog d1 = new Dog("yh", 23);
		Dog d2 = new Dog("lj", 33);
		int compareTo = d1.compareTo(d2);
		System.out.println(compareTo);
		List<Dog> l1=new ArrayList<>();
		l1.add(d2);
		l1.add(d1);
		System.out.println(l1);
		Collections.sort(l1);
		System.out.println(l1);
	}

	@Test
	public void test1() {
		Dog d1 = new Dog("yh", 23);
		Dog d2 = new Dog("lj", 33);
		int compareTo = d1.compareTo(d2);
		System.out.println(compareTo);
	}
}

class Dog implements Comparable<Dog> {

	private String name;
	private int age;

	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Dog() {
		super();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Dog o) {
		return this.getAge() - o.getAge();
	}

}

class DogComparator implements Comparator<Dog> {

	@Override
	public int compare(Dog o1, Dog o2) {
		return o1.getAge() - o2.getAge();
	}
}