package dong.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class R2 implements Runnable{

	public volatile AtomicInteger i = new AtomicInteger(1);
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(i){
				int n = 1;
				try {
					while(i.intValue()<=1750 && n<=5){
						System.out.println(Thread.currentThread().getName()+" i:"+i.getAndIncrement()+"  n:"+n++);
					}
					i.notify();
					i.wait();

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
	
	

}
