package exe3;

public class PrincipalCalculo {
	
	public static void main(String[] args) {
		
		int tamanhoQuadrado = 1000;
		int qtdPontos = 1000000000;
		
		/*
		CalculoPI cpi = new CalculoPI(tamanhoQuadrado, qtdPontos);
		long inicio = System.currentTimeMillis();
		System.out.println("EXECUTANDO SERIAL...");
		cpi.run();
		long fim = System.currentTimeMillis();
		int qtdCirculo = cpi.getQtPontosCirculo();
		System.out.println("PI: " + 4*(qtdCirculo/(double)qtdPontos));
		System.out.println("TEMPO: " + (fim-inicio));*/
		
		Delegador delegador = new Delegador(2, tamanhoQuadrado, qtdPontos);
		long inicio = System.currentTimeMillis();
		System.out.println("EXECUTANDO PARALELO...");
		int qtdCirculo = delegador.executar();
		long fim = System.currentTimeMillis();
		System.out.println("PI: " + 4*(qtdCirculo/(double)qtdPontos));
		System.out.println("TEMPO: " + (fim-inicio));
		
		
	}
}
