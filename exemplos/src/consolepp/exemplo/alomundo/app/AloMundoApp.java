package consolepp.exemplo.alomundo.app;

import br.com.consoleapp.framework.abstracts.AbstractApp;
import br.com.consoleapp.framework.annotations.AppConfig;
import br.com.consoleapp.framework.annotations.AppParams;
import br.com.consoleapp.framework.exception.AlgoritmException;
import br.com.consoleapp.framework.exception.BusinessException;

@AppParams
@AppConfig(mensagens = {"Digite alo mundo: "}, tipos = {"text"})
public class AloMundoApp extends AbstractApp {

	@Override
	public void processar() throws AlgoritmException, BusinessException {
		
		super.processar();
		
	}
	
}
