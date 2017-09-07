package dong.thread.queue;

public class Test {
	public static void main(String[] args) {
		test();
	}

	private static void test() {
		BQueue queue = new BQueue();
		queue.setNum(0);
		Procedure procedure = new Procedure(queue);
		new Thread(procedure).start();
		new Thread(procedure).start();
		new Thread(procedure).start();
	}
}
