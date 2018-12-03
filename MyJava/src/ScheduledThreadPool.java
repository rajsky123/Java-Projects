import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class SJobs implements Runnable{

	String name;
	
	public SJobs(String n) {
		name=n;
	}
	
	@Override
	public void run() {

		System.out.println(name+" started "+Thread.currentThread());
	}
	
	
}
public class ScheduledThreadPool {

	public static void main(String[] args) {

		SJobs list[]=
			{
				new SJobs("dhoni"),
				new SJobs("virat"),
				new SJobs("raina"),
				new SJobs("dhawan"),
				new SJobs("yuvraj"),
				new SJobs("sehwag"),
				
			};
		
		
		ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
		for (SJobs sJobs : list) {
			
			service.scheduleAtFixedRate(sJobs, 0, 5, TimeUnit.SECONDS);
		}
		
	}

}
