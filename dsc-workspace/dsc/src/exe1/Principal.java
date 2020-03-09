package exe1;

public class Principal {

	public static void main(String[] args) {
		
		ArquivoA a = new ArquivoA();
		ArquivoB b = new ArquivoB();
		
		long inicio = System.currentTimeMillis();
		a.start();
		b.start();
		
		try {
			a.join();
			b.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		long fim = System.currentTimeMillis();
		System.out.println("TEMPO DECORRIDO: "+(fim-inicio)/1000+"s" );
	}
}
