package dong.thread.pool;

public interface Threadpool<Job extends Runnable> {
	void addWorks(int num);
	void removeWorks(int num);
	void stop();
	int getJobSize();
	void execute(Job job);
}
