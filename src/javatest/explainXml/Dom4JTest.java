package javatest.explainXml;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;
import org.junit.Test;

/**
 * @author youhuan
 * @date 创建时间：2017年6月9日 上午8:01:55
 * @describe:
 * @version 1.0
 */
public class Dom4JTest {
	@Test
	public void test2() throws DocumentException {
		SAXReader saxReader = new SAXReader();
		Document read = saxReader.read(new File("src/stu.xml"));
		List<Element> selectSingleNode = (List<Element>)read.selectNodes("/students/student");
		for (Element element : selectSingleNode) {
			System.out.println(element.elementText("name"));
		}
	}

	@Test
	public void test1() throws DocumentException {
		SAXReader saxReader = new SAXReader();
		Document read = saxReader.read(new File("src/stu.xml"));
		Element rootElement = read.getRootElement();
		List<Element> elements = (List<Element>) rootElement.elements("student");
		for (Element element : elements) {
			System.out.println(element.elementText("name"));

		}
	}
}
