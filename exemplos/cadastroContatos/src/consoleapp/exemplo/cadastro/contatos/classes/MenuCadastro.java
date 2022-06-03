package consoleapp.exemplo.cadastro.contatos.classes;

import br.com.consoleapp.framework.abstracts.AbstractApp;
import br.com.consoleapp.framework.annotations.AppConfig;
import br.com.consoleapp.framework.annotations.AppMenu;
import br.com.consoleapp.framework.exception.AlgoritmException;
import br.com.consoleapp.framework.exception.BusinessException;

@AppMenu
@AppConfig(
	titulo = "CONSOLE APPLICATION - CADASTRO DE CONTATOS",
	menu = {
		"1 - Novo Contato",
		"2 - Listar Contatos",
		"3 - Atualizar Contato",
		"4 - Deletar Contato",
		"5 - Sair"
	}
)
public class MenuCadastro extends AbstractApp {

	@Override
	public void processar() throws AlgoritmException, BusinessException {
		
		super.setClassesMenu(
			new RegistroContato(),
			new ListaContatos(),
			new AtualizaContato(),
			new DeletaContato()
		);
		
		super.processar();
		
	}
	
}
