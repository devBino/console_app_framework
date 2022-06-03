package consoleapp.exemplo.cadastro.contatos.app;

import br.com.consoleapp.framework.processor.AlgoritmProcessor;
import consoleapp.exemplo.cadastro.contatos.classes.MenuCadastro;

public class Start {

	public static void main(String[] args) {
		
		try {
			AlgoritmProcessor.processar(new MenuCadastro());
		}catch(Exception exception) {
			System.out.println(String.format("ERRO: %s", exception.getMessage()));
		}

	}

}
