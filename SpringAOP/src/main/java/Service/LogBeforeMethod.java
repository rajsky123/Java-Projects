/**
 * 
 */
package Service;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

@Component
public class LogBeforeMethod implements MethodBeforeAdvice {

	
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {

		Log l=LogFactory.getLog(LogBeforeMethod.class);
		l.info("deposit method of log");
		
	}

}
