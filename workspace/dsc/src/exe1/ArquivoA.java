package exe1;

public class ArquivoA extends Thread{

	public void ler() {
		System.out.println("LENDO A...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("TERMINOU DE LER A.");
	}
	
	public void processar() {
		System.out.println("PROCESSANDO A...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("TERMINOU DE PROCESSAR A.");
	}
	
	public void executar() {
		this.ler();
		this.processar();
	}
	
	@Override
	public void run() {
		this.executar();
	}
}
