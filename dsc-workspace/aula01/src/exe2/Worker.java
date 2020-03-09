package exe2;

import java.util.List;

public class Worker extends Thread{
	
	private List<Integer> vetor1,vetor2,res;
	
	public Worker(List<Integer> vetor1,
				  List<Integer> vetor2,
				  List<Integer> res) {
		this.vetor1 = vetor1;
		this.vetor2 = vetor2;
		this.res = res;
	}
	
	@Override
	public void run() {
		Integer escalar = 0;
		for(int i=0;i<this.vetor1.size();i++) {
			escalar += this.vetor1.get(i)*this.vetor2.get(i);
		}
		this.res.add(escalar);
	}

}
