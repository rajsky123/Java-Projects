package Service;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

@Component
public class LogAfterMethod implements AfterReturningAdvice {

	public void afterReturning(Object ret, Method arg1, Object[] arg2, Object arg3) throws Throwable {

		Log l=LogFactory.getLog(LogAfterMethod.class);
		l.info("deposit method of log "+ret);
	
	}

}
