package exe3;

import java.util.Random;

public class CalculoPI extends Thread implements ICalculoPI{
	
	private int tamanhoQuadrado;
	private int qtdPontos;
	private int qtPontosCirculo;
	
	public CalculoPI(int tamanhoQuadrado, int qtdPontos) {
		
		this.tamanhoQuadrado = tamanhoQuadrado;
		this.qtdPontos = qtdPontos;
	}

	@Override
	public boolean isPontoNoCirculo(int x, int y, int n) {
		float raio = n/2.0f;
		double d = Math.sqrt((x-raio)*(x-raio)+(y-raio)*(y-raio));
		if(d<=raio) return true;
		return false;
	}

	@Override
	public int[] gerarPontoDentroDoQuadrado(int n) {
		Random r = new Random();
		int fim = n;

		int x = r.nextInt(fim);
		int y = r.nextInt(fim);
		int res[] = {x,y};
		
		return res;
	}

	@Override
	public int getQtPontosCirculo() {
		return this.qtPontosCirculo;
	}

	@Override
	public void run() {
		int soma = 0;
		for(int i=0;i<this.qtdPontos;i++) {
			int ponto[] = this.gerarPontoDentroDoQuadrado(this.tamanhoQuadrado);
			if(this.isPontoNoCirculo(ponto[0], ponto[1], this.tamanhoQuadrado))
				soma++;
		}
		this.qtPontosCirculo = soma;
	}

}
