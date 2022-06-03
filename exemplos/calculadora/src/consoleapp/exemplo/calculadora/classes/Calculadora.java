package consoleapp.exemplo.calculadora.classes;

import br.com.consoleapp.framework.abstracts.AbstractApp;
import br.com.consoleapp.framework.annotations.AppConfig;
import br.com.consoleapp.framework.annotations.AppMenu;
import br.com.consoleapp.framework.exception.AlgoritmException;
import br.com.consoleapp.framework.exception.BusinessException;

@AppMenu
@AppConfig(
	titulo = "CALCULADORA CONSOLE APP",
	menu = {
		"1 - SOMAR",
		"2 - SUBTRAIR",
		"3 - SAIR"
	}
)
public class Calculadora extends AbstractApp {

	@Override
	public void processar() throws AlgoritmException, BusinessException {
		
		super.setClassesMenu(
			new Somar(),
			new Subtrair()
		);
		
		super.processar();
		
	}
	
}
