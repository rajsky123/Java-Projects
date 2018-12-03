import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Jobs implements Runnable
{   String name;
	public Jobs(String n) {
		name=n;
	}
	
	@Override
	public void run() {
		System.out.println(name+" started the job with thread "+Thread.currentThread().getName());
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
	    System.out.println(name+" completed the job with thread "+Thread.currentThread().getName());
	}
	
	
}
public class ExecuterService {

	public static void main(String[] args) {
 
		ExecutorService service = Executors.newFixedThreadPool(2);		
		Jobs list[]= {new Jobs("virat"),
					  new Jobs("rohit"),
			          new Jobs("dhawan"),
			          new Jobs("raina"),
			          new Jobs("azaz"),
			          new Jobs("dhoni")   
		};
		
		for (Jobs jobs : list) {
			service.submit(jobs);
		}
		
		service.shutdown();
		
		
	
	
	}

}
