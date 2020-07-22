package exe3;

public class Delegador {

	private int qtdThreads = 1;
	private int tamanhoQuadrado;
	private int qtdPontos;
	
	public Delegador(int qtdThreads, int tamanhoQuadrado, int qtdPontos) {
		
		this.qtdThreads = qtdThreads;
		this.tamanhoQuadrado = tamanhoQuadrado;
		this.qtdPontos = qtdPontos;
	}
	
	public int executar() {
		int soma = 0;
		int pontosRazao = this.qtdPontos/this.qtdThreads;
		CalculoPI cpis[] = new CalculoPI[this.qtdThreads];
		
		for(int i=0;i<this.qtdThreads;i++) {
			CalculoPI cpi = new CalculoPI(this.tamanhoQuadrado, pontosRazao);
			cpis[i]=cpi;
			cpi.start();
		}
		
		for(int i=0;i<this.qtdThreads;i++) {
			try {
				cpis[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			soma+=cpis[i].getQtPontosCirculo();
		}
		
		return soma;
	}
	
}
