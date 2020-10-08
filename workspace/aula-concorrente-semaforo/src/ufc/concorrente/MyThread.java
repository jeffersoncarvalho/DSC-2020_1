package ufc.concorrente;

import java.util.concurrent.Semaphore;

public class MyThread extends Thread{

	private String name;
	private CriticalSection cs;
	private Semaphore s;
	
	public MyThread(String name, CriticalSection cs, Semaphore s) {
		this.name = name;
		this.cs = cs;
		this.s = s;
	}
	
	@Override
	public void run() {
		System.out.println(this.name + " started.");
		
		try {
			Thread.sleep(50);
			//1 - ASK FOR PERMISSION
			//-----------------------------------------------------------
			System.out.println(this.name + " is waiting for a permit...");
			this.s.acquire(); //BLOCANTE //WAIT
			System.out.println(this.name + " gets a permit!");
			
			//2 - CRITICAL SECTION ACESS
			//-----------------------------------------------------------
			this.cs.add(this.name);
			System.out.println(this.name +" wrote.");
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//3 - RELEASE PERMISSION
		//-----------------------------------------------------------
		System.out.println(this.name + " releases the permit.");
		this.s.release(); //SIGNAL
		
		System.out.println(this.name + " finished.");
	}
}
