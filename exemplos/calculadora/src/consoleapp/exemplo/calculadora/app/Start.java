package consoleapp.exemplo.calculadora.app;

import br.com.consoleapp.framework.processor.AlgoritmProcessor;
import consoleapp.exemplo.calculadora.classes.Calculadora;

public class Start {

	public static void main(String[] args) {
		
		try {
			AlgoritmProcessor.processar(new Calculadora());
		}catch(Exception exception) {
			System.out.println( String.format("ERRO: %s", exception.getMessage()) );
		}
		
	}
	
}
