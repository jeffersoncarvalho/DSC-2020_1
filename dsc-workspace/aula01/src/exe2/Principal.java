package exe2;

import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
		
		List<Integer> v1 = new ArrayList<Integer>();
		List<Integer> v2 = new ArrayList<Integer>();
		v1.add(1);v1.add(2);v1.add(3);
		v2.add(1);v2.add(2);v2.add(3);
		
		List<Integer> res = new ArrayList<Integer>();
		
		Worker workers[] = new Worker[3];
		
		for(int i=0;i<3;i++) {
			Worker w = new Worker(v1, v2, res);
			workers[i] = w;
			w.start();
		}
		
		for(int i=0;i<3;i++) {
			try {
				workers[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(res);
		
		
	}
}
