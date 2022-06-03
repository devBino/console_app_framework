package consoleapp.exemplo.cadastro.contatos.classes;

import br.com.consoleapp.framework.abstracts.AbstractApp;
import br.com.consoleapp.framework.annotations.AppConfig;
import br.com.consoleapp.framework.annotations.AppFile;
import br.com.consoleapp.framework.annotations.AppParams;
import br.com.consoleapp.framework.exception.AlgoritmException;
import br.com.consoleapp.framework.exception.BusinessException;
import br.com.consoleapp.framework.processor.AlgoritmProcessor;

@AppFile(path = "dados/contatos.txt")
@AppParams( operacao = "delete" )
@AppConfig(imprimirTitulo = false)
public class DeletaContato extends AbstractApp {

	@Override
	public void processar() throws AlgoritmException, BusinessException {

		super.processar();
		
		AlgoritmProcessor.processar(new MenuCadastro());
	}
	
}
