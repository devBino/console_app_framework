package consoleapp.exemplo.calculadora.classes;

import br.com.consoleapp.framework.abstracts.AbstractApp;
import br.com.consoleapp.framework.annotations.AppConfig;
import br.com.consoleapp.framework.annotations.AppParams;
import br.com.consoleapp.framework.exception.AlgoritmException;
import br.com.consoleapp.framework.exception.BusinessException;
import br.com.consoleapp.framework.processor.AlgoritmProcessor;

@AppParams
@AppConfig(
	titulo = "Realizando uma soma...",
	mensagens = {"Informe o valor 1: ", "Agora, informe o valor 2:"},
	tipos = {"integer","integer"}
)
public class Somar extends AbstractApp {

	@Override
	public void processar() throws AlgoritmException, BusinessException {
		
		super.processar();
		
		int valor1 = (Integer) params.get(0)[0];
		int valor2 = (Integer) params.get(0)[1];
		
		int resultado = valor1 + valor2; 
		
		StringBuilder saidaProcessamento = new StringBuilder()
				.append("Resultado = ")
				.append(resultado);
		
		super.saidaDados(saidaProcessamento);
		
		AlgoritmProcessor.processar(new Calculadora());
		
	}
	
}
