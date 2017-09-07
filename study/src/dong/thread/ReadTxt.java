package dong.thread;


public class ReadTxt implements Runnable{

	private volatile Integer i = 1;
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
			read();
		}
	}
	
	private synchronized void read(){
		try {
			int n = 1;
			while(i<=1750 && n<=5){
				System.out.println(Thread.currentThread().getName()+" i:"+i+++"  n:"+n++);
			}
			i.notify();
			i.wait();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
