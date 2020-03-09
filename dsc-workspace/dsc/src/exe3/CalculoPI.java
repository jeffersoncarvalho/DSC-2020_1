package exe3;

import java.util.Random;

public class CalculoPI extends Thread{
	
	private int qtdPontosQuadrado;
	private int tamanhoQuadrado; // começando da coordenada (0,0)
	private int qtPontosCirculo; 
	
	public CalculoPI(int qtdPontos, int tamanhoQuadrado) {
		this.qtdPontosQuadrado = qtdPontos;
		this.tamanhoQuadrado = tamanhoQuadrado;
	}
	
	public boolean isPontoNoCirculo(int x, int y, int n) {
		
		double raio = n/2.0;
		double d = Math.sqrt((x-raio)*(x-raio)+(y-raio)*(y-raio));
		if(d<=raio) return true;
		return false;
	}
	
	public int[] gerarPontoDentroDoQuadrado(int n){
		
		int low = 0;
		int high = n;
		
		Random r = new Random();
		int x = r.nextInt(high-low) + low;
		int y = r.nextInt(high-low) + low;
		int[] res = {x,y};
		return res;
	}
	
	public int getQtPontosCirculo() {
		return qtPontosCirculo;
	}
	
	public void run() {
		int qtdPontosCirculo = 0;
		for(int i=0;i<this.qtdPontosQuadrado;i++) {
			int pontoGerado[] = this.gerarPontoDentroDoQuadrado(this.tamanhoQuadrado);
			if(this.isPontoNoCirculo(pontoGerado[0], pontoGerado[1], this.tamanhoQuadrado))
					qtdPontosCirculo++;
		}
		this.qtPontosCirculo = qtdPontosCirculo;
	}
}
