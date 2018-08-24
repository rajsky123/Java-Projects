/**
 * 
 */
package Service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogBeforeMethod  {

	
	@Before("execution(* Business.Bank.deposit(..))")
	public void before() throws Throwable {

		Log l=LogFactory.getLog(LogBeforeMethod.class);
		l.info("deposit method of log");
		
	}

}
