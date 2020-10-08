package ufc.concorrente;

import java.util.concurrent.Semaphore;

public class MainProgram {

	public static void main(String[] args) {
		
		Semaphore s = new Semaphore(1); //MUTEX
		
		CriticalSection cs = new CriticalSection();
		
		MyThread A = new MyThread("Thread A", cs, s);
		MyThread B = new MyThread("Thread B", cs, s);
		MyThread C = new MyThread("Thread C", cs, s);
		
		long start = System.currentTimeMillis();
		
		A.start();
		B.start();
		C.start();
		
		try {
			A.join();
			B.join();
			C.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		System.out.println("Elapsed: " + (end-start)/1000.0 + "s");
		System.out.println(cs.getMyList());
	}
}
