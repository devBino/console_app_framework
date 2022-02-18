# console.app.framework Betha &#129299; &#129299;

<p align="justify">
  Autor: Fernando Bino Machado <br><br>
  O console app framework é um micro framework baseado em Java, em desenvolvimento,
  que auxilia quando necessitamos fazer testes rápidos, ou mesmo 
  programar um algoritmo com entrada de dados, processamento e saída de dados
  de maneira padronizada.
</p>
<br>

<p align="justify">
  Sempre que necessitamos testar um algorítmo e resolver um problema, por mais simples
  que seja, recorremos a criação de um novo projeto, ou uma classe nova em algum lugar
  dentro de um projeto qualquer existente em nosso computador, e de projeto em projeto, 
  poluimos cada vez mais nosso ambiente de trabalho.
</p>
<br>

<p align="justify">
  O console.app.framework fornece um padrão de criação para nossos algoritmos
  rápidos, onde cada classe padronizada extende à classe AbstractApp do micro framework,
  onde a classe padronizada representa uma <b>console app</b>. Dessa forma, anotamos
  as classes criadas com @AppConfig, e nessa anotação, podemos passar alguns valores
  que irão otimizar a captura dos dados. Dessa maneira só nos preocupamos com
  a saída dos dados.
</p>
<br>

<p align="justify">
  Mesmo que o micro framework, aparentemente tenha uma proposta trivial, pode ser uma boa
  ferramenta quando necessitamos padronizar nossos codigos rápidos, de forma que não fiquem 
  espalhados por todo lugar. Além disso, a construção de algo que possa ser reutilizado,
  sempre nos força a revisar o código, versioná-lo e se preocupar em quanto ganho uma ferramenta
  produzida por nós poderá proporcionar.
 </p>
 <br>
 
 <p align="justify">
  Abaixo, um exemplo de como criar uma console app básica utilizando o console.app.framework: <br>
 </p>
 
 ```java
package app;

import br.com.consoleapp.framework.abstracts.AbstractApp;
import br.com.consoleapp.framework.annotations.AppConfig;
import br.com.consoleapp.framework.annotations.AppParams;
import br.com.consoleapp.framework.exception.AlgoritmException;

@AppParams
@AppConfig(
   titulo = "CONSOLE APP TABUADA EXEMPLO",
   mensagens = {
   	"Por favor, informe a tabuada que deseja verificar: "
   },
   tipos = {
   	"INTEGER"
   }
)
public class Tabuada extends AbstractApp {

   @Override
   public void processar() throws AlgoritmException {
   	
   	//entrada de dados
   	super.entradaDados();
   	
   	//processamento de dados
   	StringBuilder saida = new StringBuilder();
   	
   	for(int i=1; i<=10; i++) {
   		Integer n = (Integer) super.getParams().get(0);
   		int r = i * n;
   		saida.append(String.format("%d X %d = %d%n", i,n,r));
   	}
   	
   	//saída de dados
   	super.saidaDados(saida);
   	
   }
   
}


 ```
 
 <br>
 
<p align="justify">Agora, após ter criado uma classe de console app, podemos passá-la para o framework da seguinte forma:</p><br>

```java

package app;

import br.com.consoleapp.framework.processor.AlgoritmProcessor;

public class Start {

	public static void main(String[] args) {
		try {
			
			AlgoritmProcessor.processar(new Tabuada());
			
		}catch(Exception e) {
			//suas tratativas aqui, erro capturado pelo framework
			System.out.println( String.format("ERRO DE EXECUÇÃO: %s", e.getMessage()) );
			
		}

	}

}


```

<br>
	
	
	

