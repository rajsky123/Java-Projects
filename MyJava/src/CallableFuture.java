import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CJobs implements Callable<Object>{

	String name;
	public CJobs(String n) {
     name=n;
	}
	@Override
	public Object call() throws Exception {
     
		System.out.println(name+" started "+Thread.currentThread().getName());
		 Thread.sleep(5000);
	   return name+" completed "+Thread.currentThread().getName();
	}

	
}

public class CallableFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService service = Executors.newFixedThreadPool(2);
		
		CJobs list[]= {
				new CJobs("virat"),
				new CJobs("dhoni"),
				new CJobs("manna"),
				new CJobs("raina"),
				new CJobs("dhawan"),
				new CJobs("yuvraj"),
				
		};
		
		for (CJobs cJobs : list) {
			Future<Object> f= service.submit(cJobs);
			System.out.println(f.get());
		}
		service.shutdown();
		
	}

}
