package javatest.log4j;

import org.apache.log4j.Logger;

/**
 * @author youhuan
 * @date 创建时间：2017年6月8日 下午9:18:26
 * @describe:
 * @version 1.0
 */
public class Log4jTest {
	private static final Logger logger = Logger.getLogger(Log4jTest.class);
	
	public static void main(String[] args) {
		if (logger.isDebugEnabled()) {
			logger.debug("main(String[]) - start");
		}

		
		if (logger.isDebugEnabled()) {
			logger.debug("main(String[]) - end");
		}
	}
}
