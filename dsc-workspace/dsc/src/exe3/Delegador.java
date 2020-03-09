package exe3;

public class Delegador {

	private int qtThreads = 1;
	private int qtdPontos = 0;
	private int tamanhoQuadrado;
	
	public Delegador(int qtThreads, int qtdPontos, int tamanhoQuadrado) {
		this.qtThreads = qtThreads;
		this.qtdPontos = qtdPontos;
		this.tamanhoQuadrado = tamanhoQuadrado;
	}
	
	public int executar() {
		
		int pontosRazao = this.qtdPontos/this.qtThreads;
		CalculoPI threads[] = new CalculoPI[qtThreads];
		
		for(int i=0;i<this.qtThreads;i++){
			CalculoPI cpi = new CalculoPI(pontosRazao, this.tamanhoQuadrado);
			threads[i] = cpi;
			cpi.start();
		}
		
		int somaPontosCirculo = 0;
		for(int i=0;i<threads.length;i++) {
			try {
				threads[i].join();
				somaPontosCirculo+=threads[i].getQtPontosCirculo();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return somaPontosCirculo;
	}
	
	
}
