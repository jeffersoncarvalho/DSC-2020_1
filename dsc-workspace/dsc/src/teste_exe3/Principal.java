package teste_exe3;

public class Principal {

	public static void main(String[] args) {
		
		int qtdPontos = 100000000;
		int tamanhoQuadrado = 1000;
		
		//SERIAL
		/*CalculoPI calculoPI = new CalculoPI(qtdPontos, tamanhoQuadrado);
		long inicio = System.currentTimeMillis();
		calculoPI.run();
		long fim = System.currentTimeMillis();
		double pi = 4*calculoPI.getQtPontosCirculo()/(float)qtdPontos;
		System.out.println("PI: " + pi);
		System.out.println("TEMPO: "+(fim-inicio));*/
		
		long inicio = System.currentTimeMillis();
		Delegador delegador = new Delegador(2, qtdPontos, tamanhoQuadrado);
		int qtdPontosCirculo = delegador.executar(); 
		double pi = 4*qtdPontosCirculo/(float)qtdPontos;
		long fim = System.currentTimeMillis();
		System.out.println("PI: " + pi);
		System.out.println("TEMPO: "+(fim-inicio));
	}
}
