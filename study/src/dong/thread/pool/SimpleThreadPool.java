package dong.thread.pool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SimpleThreadPool<Job extends Runnable> implements Threadpool<Job>{

	private static int INIT_THREAD_NUM ;
	private static int MAX_THREAD_NUM = 100;
	private static int MIN_THREAD_NUM = 1;
	private final  LinkedList<Job> currentJobs = new LinkedList<Job>();
	private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());
	public SimpleThreadPool(int initThreadNum){
		if(initThreadNum<MAX_THREAD_NUM){
			SimpleThreadPool.INIT_THREAD_NUM = initThreadNum;
		}else{
			SimpleThreadPool.INIT_THREAD_NUM = MAX_THREAD_NUM;
		}
		initThreads(SimpleThreadPool.INIT_THREAD_NUM);
	}
	private void initThreads(int num) {
		for(int i = 0;i<num;i++){
			Worker worker = new Worker(currentJobs);
			workers.add(worker);
			Thread t = new Thread(worker);
			t.start();
		}
		
	}
	@Override
	public void execute(Job job) {
		if(job!=null){
			synchronized (currentJobs) {
				currentJobs.addLast(job);
				currentJobs.notify();
			}
		}

		
	}

	@Override
	public void addWorks(int num) {
		synchronized (workers) {
			Worker worker = new Worker(currentJobs);
			workers.add(worker);
		}
		
	}

	@Override
	public void removeWorks(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getJobSize() {
		// TODO Auto-generated method stub
		return 0;
	}

}
