class Stock
{
	static int item; 
	private static Stock stock;
	
	public final static Stock getInstance()
	{
		if(stock==null)
		stock=new Stock();
		
		return stock;
	}
	
	public synchronized void consume(int n) throws InterruptedException
	{
		if(n>Stock.item)
			this.wait();
		Stock.item-=n;
		System.out.println(+n+" items consumed");
		
	}
	
	public synchronized void produce(int n) throws InterruptedException
	{
		Stock.item+=n;
		System.out.println(n+" items produced");
		this.notify();
		
	}
}

class Consumer extends Thread
{
	
	public void run()
	{
		try {
			Stock.getInstance().consume(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Producer extends Thread
{
	
	
	public void run()
	{
		try {
			Stock.getInstance().produce(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}




public class WaitNotify {

	public static void main(String[] args) throws InterruptedException {

		
		Consumer c=new Consumer();
		c.start();
		Producer p=new Producer();
		p.start();
	}

}
