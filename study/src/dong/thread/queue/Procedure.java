package dong.thread.queue;

public class Procedure implements Runnable{

	private BQueue queue ;
	public Procedure(BQueue queue) {
		this.queue = queue;
	}
	@Override
	public void run() {
		while(true){
			synchronized (this) {
			
				while(queue.getNum()>=queue.Maxnum){
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				queue.setNum(queue.getNum()+1);
				System.out.println(Thread.currentThread()+": num = "+queue.getNum());
				notifyAll();
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
		
	}
	
}
