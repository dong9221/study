package dong.thread.pool;

import java.util.LinkedList;

public class Worker<Job extends Runnable> implements Runnable{

	private LinkedList<Job> jobs ;
	public Worker(LinkedList<Job> jobs){
		this.jobs = jobs;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Job job = null;
		try {
			while(true){
				synchronized(jobs){
					if(jobs.isEmpty()){
						jobs.wait();
					}else{
						job = jobs.removeFirst();
					}
				}
				if(job!=null){
					job.run();
				}
				
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
