package study;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import dong.thread.R2;
import dong.thread.pool.SimpleThreadPool;

public class Test {
	public static void main(String[] args) {
		//testThread();
		//testThreadPool();
		//testJavaExecuter();
		//testENUM();
		//testObj();
		//testBsearch();
		testInteger();
	}
	
	private static void testInteger() {
		Integer a1 = -129;
		Integer a2 = -129;
		Integer a3 = Integer.valueOf(123);
		Integer a4 = Integer.valueOf(123);
		
		
		System.out.println(a1==a2);
		System.out.println(a3==a4);
	}

	private static void testBsearch() {
		int[] a = {1,2,3,4,5,6,7,9,11,12,15,17,19,22,23,25,45,88,99,101,105,111,112,113};
		
		int num = 11;
		int val = 0;
		int idx = 0;
		
		int idx1 = 0;
		int idx2 = a.length-1;
		
		int i = 1;
		while(val == 0){
			idx = (idx1 + idx2)/2;
			System.out.println("��"+i+++"�β���,idx1 = "+idx1+",idx2 = "+idx2+",idx="+idx);
			if(a[idx] == num){
				val = idx;
			}else if(a[idx] > num){
				idx2 = idx;
			}else if(a[idx] < num){
				idx1 = idx;
			}
			if(idx2 - idx1 <=1){
				val = -1;
			}
		}
		System.out.println(val);
		
	}

	private static void testObj() {
        Object obj = new Object();
        System.out.println(obj.hashCode());
        Map map = new HashMap();
        for(int i = 0; i < 1700;i++){
        	map.put(i, i);
        }
        map.put(null,null);
        ConcurrentHashMap cmap = new ConcurrentHashMap<>();
        System.out.println(map.size());
	}

	private static void testENUM() {
		
		System.out.println(Color.BLACK);
		System.out.println(Color.YELLOW);
	}

	private static void testJavaExecuter() {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();  
		R2 r2 = new R2();
		  for (int i = 0; i < 10; i++) {  
		   final int index = i;  
		   try {  
		    Thread.sleep(index * 100);  
		   } catch (InterruptedException e) {  
		    e.printStackTrace();  
		   }  
		   cachedThreadPool.execute(r2);  
		  }
	}

	private static void testThreadPool() {
		SimpleThreadPool<Runnable> pool = new SimpleThreadPool<>(4);
		R2 r1 = new R2();
		R2 r2 = new R2();
		R2 r3 = new R2();
		pool.execute(r1);
		pool.execute(r1);
		pool.execute(r1);
		pool.execute(r1);
		pool.execute(r1);
	}

	public static void testThread(){
		//ReadTxt r = new ReadTxt();
		R2 r = new R2();
		Thread t1 = new Thread(r,"�߳�һ");
		Thread t2 = new Thread(r,"�̶߳�");
		Thread t3 = new Thread(r,"�߳���");
		t1.start();
		
		t2.start();
		t3.start();
	}
	
	
}


