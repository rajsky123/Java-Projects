class AA
{

	public synchronized void aa(BB b)
	{
		System.out.println("BB object lock is aquired");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		
		b.lock();
		
	}
	
	public synchronized void lock() {

		System.out.println("AA lock() executing");
	}
	
}
class BB
{
   
	public synchronized void bb(AA a)
	{
		System.out.println("AA object lock is aquired");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		
		a.lock();
	}

	public synchronized void lock() {

		System.out.println("BB lock() executing");
	}
	
	
}
public class DeadLock{
	
	
	public static void main(String[] args) {
	
		AA a=new AA();
		BB b=new BB();
		 
		 Runnable r1=()->
		 {
			 a.aa(b);
		 };
		
		 Runnable r2=()->
		 {
			 b.bb(a);
		 };
	   new Thread(r1).start();
	   new Thread(r2).start();
	
	}

	
	
}