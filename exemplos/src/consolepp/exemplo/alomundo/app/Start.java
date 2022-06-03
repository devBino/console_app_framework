package consolepp.exemplo.alomundo.app;

import br.com.consoleapp.framework.processor.AlgoritmProcessor;

public class Start {

	public static void main(String[] args) {
		
		try {
			AlgoritmProcessor.processar(new AloMundoApp());
		}catch(Exception exception) {
			System.out.println( String.format("ERRO: %s", exception.getMessage()) );
		}
		
	}
	
}
