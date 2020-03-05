package exe1;

public class ArquivoB extends Thread{
	public void ler() {
		System.out.println("LENDO B...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("TERMINOU DE LER B.");
	}
	
	public void processar() {
		System.out.println("PROCESSANDO B...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("TERMINOU DE PROCESSAR B.");
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
