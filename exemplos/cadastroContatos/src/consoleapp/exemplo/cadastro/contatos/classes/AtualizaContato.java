package consoleapp.exemplo.cadastro.contatos.classes;

import br.com.consoleapp.framework.abstracts.AbstractApp;
import br.com.consoleapp.framework.annotations.AppConfig;
import br.com.consoleapp.framework.annotations.AppFile;
import br.com.consoleapp.framework.annotations.AppParams;
import br.com.consoleapp.framework.exception.AlgoritmException;
import br.com.consoleapp.framework.exception.BusinessException;
import br.com.consoleapp.framework.processor.AlgoritmProcessor;

@AppFile(path = "dados/contatos.txt")
@AppParams(operacao = "update")
@AppConfig(
	imprimirTitulo = false,
	mensagens = {
		"Por favor, informe o nome do contato: ",
		"Agora informe o telefone do contato: ",
		"Por fim, informe o email do contato: "
	},
	tipos = {"text","text","text"}
)
public class AtualizaContato extends AbstractApp {

	@Override
	public void processar() throws AlgoritmException, BusinessException {
		
		super.processar();
		
		AlgoritmProcessor.processar(new MenuCadastro());
		
	}
	
}
