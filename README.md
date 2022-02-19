# console.app.framework Betha &#129299; &#129299;

<p align="justify">
  Autor: Fernando Bino Machado <br><br>
  O console app framework é um micro framework em desenvolvimento, baseado em Java.
  Seu principal objetivo é auxiliar quando necessitamos fazer testes rápidos, ou mesmo 
  programar um algoritmo com entrada de dados, processamento e saída de dados
  de maneira padronizada.
</p>
<br>

<p align="justify">
  Sempre que necessitamos testar um algorítmo e resolver um problema, por mais simples
  que seja, recorremos a criação de um novo projeto, ou uma classe nova em algum lugar
  dentro de um projeto qualquer existente em nosso computador, e de projeto em projeto, 
  poluímos cada vez mais nosso ambiente de trabalho.
</p>
<br>

<p align="justify">
  O console app framework fornece um padrão de criação para nossos algoritmos
  rápidos, e até mesmo, console applications com opções de menus.
  Cada classe padronizada representa uma <b>console app</b> e extende à classe AbstractApp do micro framework. 
  A primeira coisa que precisamos fazer, é anotar a classe recém criada com as possíveis anotações:
  @AppMenu, @AppParams, @AppFile e @AppTabela.
</p>

<p align="justify">
	@AppMenu é a anotação que indica que a classe console app é do tipo menu, onde é possível criar um menu de console application.<br>
	@AppParams é a anotação que indica que a classe console app é do tipo params, para captura de parâmetros. <br>
	@AppFile é a anotação que indica que a classe console app é do tipo file, e poderá ler e escrever em arquivos. <br>
	@AppTabela é a anotação que indica que a classe console app é do tipo tabela, significa que recebera registros e os 
	exibirá de maneira padronizada. <br>
</p>

<p align="justify">
	Após anotar o tipo da console app, anotamos @AppConfig, e nessa anotação, podemos passar alguns valores
  	referentes às configurações de acordo com tipo escolhido. Por exemplo, se for um menu, é possível passar 
	em @AppConfig no elemento menu, um Array de Strings com cada opção do menu.
</p>

<br>

<p align="justify">
	O console app framework utiliza padrão singleton para gerenciar as instâncias de console app solicitadas
	pelos desenvolvedores, mesmo que o desenvolvedor passe sempre novas instâncias de suas console apps,
	foi implementado um padrão Singleton que garante que cada console app implementada, terá apenas uma 
	instância.
</p>

<p align="justify">
	Além disso o console app framework proporciona uma maneira organizada, profissional e atualizada
	de criarmos aplicações em console, ou seja, não criamos sem padrão, criamos usando um framework pensado
	e criado para esse propósito.
</p>

<p align="justify">
	Por fim, o console app framework tem novas releases liberadas a cada 15 dias, o que garante que 
	o sistema considera a evolução constante, pensando em otimizar o desenvolvimento de aplicações em console.
</p>


<h1>Baixe o arquivo .jar da versão mais recente do console app framework</h1><br>

<p align="justify">
	<a href="https://github.com/devBino/console_app_framework/tree/main/versoes" target="_blank">
	Baixar Versão
	</a>
</p><br>


 <br>
 
 <p align="justify">
  <h1>Abaixo, um exemplo de como criar uma console app básica utilizando o console.app.framework: </h1><br>
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
   public void processar() throws AlgoritmException, BusinessException  {
   	
   	//entrada de dados
   	super.entradaDados();
   	
   	//processamento de dados
   	StringBuilder saida = new StringBuilder();
   	
   	for(int i=1; i<=10; i++) {
   		Integer n = (Integer) params.get(0);
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

<p align="justify">
  <h1>Agora, uma aplicação de menu combinando os tipos de console app @AppMenu e @AppParams</h1><br>

  Lembre-se que além da anotação de tipo de console app, devemos passar anotação @AppConfig, para
  configurar o tipo.
 </p>

<h2>1 - Crie uma console app anotada com @AppMenu e @AppConfig, que será a console app de Menu</h2><br>
	
```java
package app;

import br.com.consoleapp.framework.abstracts.AbstractApp;
import br.com.consoleapp.framework.annotations.AppConfig;
import br.com.consoleapp.framework.annotations.AppMenu;
import br.com.consoleapp.framework.exception.AlgoritmException;
import br.com.consoleapp.framework.exception.BusinessException;
import br.com.consoleapp.framework.processor.AlgoritmProcessor;

@AppMenu
@AppConfig(
	titulo = "TESTE CONCEITO CALCULADORA",
	menu = {
		"[1] - Somar",
		"[2] - Diminuir",
		"[3] - Multiplicar",
		"[4] - Dividir",
		"[5] - Encerrar"
	}
)
public class Menu extends AbstractApp {

	@Override
	public void processar() throws AlgoritmException, BusinessException {

		super.entradaDados();
		
		if( params.get(0).equals("1") ) {
			
			AlgoritmProcessor.processar(new Somar());
			
		}else if( params.get(0).equals("2") ) {
			
			AlgoritmProcessor.processar(new Diminuir());
			
		}else if( params.get(0).equals("3") ) {
			
			AlgoritmProcessor.processar(new Multiplicar());
			
		}else if( params.get(0).equals("4") ) {
			
			AlgoritmProcessor.processar(new Dividir());
			
		}else {
			
			System.out.println("\nEncerrando Console App...");
			System.exit(0);
			
		}
		
	}
	
}

```

<h2>Crie uma console app anotada com @AppParams e @AppConfig para ser a opção de SOMA</h2><br>


```java
package app;

import java.math.BigDecimal;

import br.com.consoleapp.framework.abstracts.AbstractApp;
import br.com.consoleapp.framework.annotations.AppConfig;
import br.com.consoleapp.framework.annotations.AppParams;
import br.com.consoleapp.framework.exception.AlgoritmException;
import br.com.consoleapp.framework.exception.BusinessException;
import br.com.consoleapp.framework.processor.AlgoritmProcessor;

@AppParams
@AppConfig(
		titulo = "Capturando dados para SOMA",
		mensagens = {
				"Por favor informe o valor 1: ",
				"Por favor informe o valor 2: "
		},
		tipos = {
				"big_decimal",
				"big_decimal"
		}
)
public class Somar extends AbstractApp {

	@Override
	public void processar() throws AlgoritmException, BusinessException {
		
		super.entradaDados();
		
		//processa os dados
		BigDecimal valor1 = new BigDecimal(params.get(0).toString());
		BigDecimal valor2 = new BigDecimal(params.get(1).toString());
		BigDecimal resultado = valor1.add(valor2);
		
		//monta mensagem saida
		StringBuilder saida = new StringBuilder();
		saida.append("Resultado cálculo: ");
		saida.append(resultado.toString());
		
		super.saidaDados(saida);
		
		AlgoritmProcessor.processar(new Menu());
		
		
	}
	
}

```

<h2>Crie uma console app anotada com @AppParams e @AppConfig para ser a opção de DIMINUIR</h2><br>

```java
package app;

import java.math.BigDecimal;

import br.com.consoleapp.framework.abstracts.AbstractApp;
import br.com.consoleapp.framework.annotations.AppConfig;
import br.com.consoleapp.framework.annotations.AppParams;
import br.com.consoleapp.framework.exception.AlgoritmException;
import br.com.consoleapp.framework.exception.BusinessException;
import br.com.consoleapp.framework.processor.AlgoritmProcessor;

@AppParams
@AppConfig(
		titulo = "Capturando dados para DIMINUIR",
		mensagens = {
				"Por favor informe o valor 1: ",
				"Por favor informe o valor 2: "
		},
		tipos = {
				"big_decimal",
				"big_decimal"
		}
)
public class Diminuir extends AbstractApp {

	@Override
	public void processar() throws AlgoritmException, BusinessException {
		
		super.entradaDados();
		
		//processa os dados
		BigDecimal valor1 = new BigDecimal(params.get(0).toString());
		BigDecimal valor2 = new BigDecimal(params.get(1).toString());
		BigDecimal resultado = valor1.subtract(valor2);
		
		//monta mensagem saida
		StringBuilder saida = new StringBuilder();
		saida.append("Resultado cálculo: ");
		saida.append(resultado.toString());
		
		super.saidaDados(saida);
		
		AlgoritmProcessor.processar(new Menu());
		
		
	}
	
}

```

<h2>Crie uma console app anotada com @AppParams e @AppConfig para ser a opção de MULTIPLICAR</h2><br>


```java
package app;

import java.math.BigDecimal;

import br.com.consoleapp.framework.abstracts.AbstractApp;
import br.com.consoleapp.framework.annotations.AppConfig;
import br.com.consoleapp.framework.annotations.AppParams;
import br.com.consoleapp.framework.exception.AlgoritmException;
import br.com.consoleapp.framework.exception.BusinessException;
import br.com.consoleapp.framework.processor.AlgoritmProcessor;

@AppParams
@AppConfig(
		titulo = "Capturando dados para MULTIPLICAR",
		mensagens = {
				"Por favor informe o valor 1: ",
				"Por favor informe o valor 2: "
		},
		tipos = {
				"big_decimal",
				"big_decimal"
		}
)
public class Multiplicar extends AbstractApp {

	@Override
	public void processar() throws AlgoritmException, BusinessException {
		
		super.entradaDados();
		
		//processa os dados
		BigDecimal valor1 = new BigDecimal(params.get(0).toString());
		BigDecimal valor2 = new BigDecimal(params.get(1).toString());
		BigDecimal resultado = valor1.multiply(valor2);
		
		//monta mensagem saida
		StringBuilder saida = new StringBuilder();
		saida.append("Resultado cálculo: ");
		saida.append(resultado.toString());
		
		super.saidaDados(saida);
		
		AlgoritmProcessor.processar(new Menu());
		
		
	}
	
}

```

<h2>Crie uma console app anotada com @AppParams e @AppConfig para ser a opção de DIVIDIR</h2><br>


```java
package app;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.consoleapp.framework.abstracts.AbstractApp;
import br.com.consoleapp.framework.annotations.AppConfig;
import br.com.consoleapp.framework.annotations.AppParams;
import br.com.consoleapp.framework.exception.AlgoritmException;
import br.com.consoleapp.framework.exception.BusinessException;
import br.com.consoleapp.framework.processor.AlgoritmProcessor;

@AppParams
@AppConfig(
		titulo = "Capturando dados para DIVIDIR",
		mensagens = {
				"Por favor informe o valor 1: ",
				"Por favor informe o valor 2: "
		},
		tipos = {
				"big_decimal",
				"big_decimal"
		}
)
public class Dividir extends AbstractApp {

	@Override
	public void processar() throws AlgoritmException, BusinessException {
		
		super.entradaDados();
		
		//processa os dados
		BigDecimal valor1 = new BigDecimal(params.get(0).toString());
		BigDecimal valor2 = new BigDecimal(params.get(1).toString());
		BigDecimal resultado = new BigDecimal("0.00");
		
		if( valor1.compareTo(new BigDecimal("0.00")) > 0 
				&& valor2.compareTo(new BigDecimal("0.00")) > 0 ) {
			
			resultado = valor1.divide(valor2,RoundingMode.HALF_DOWN);
			
		}
		
		//monta mensagem saida
		StringBuilder saida = new StringBuilder();
		saida.append("Resultado cálculo: ");
		saida.append(resultado.toString());
		
		super.saidaDados(saida);
		
		AlgoritmProcessor.processar(new Menu());
		
		
	}
	
}

```

<h2>Crie a classe principal da sua aplicação Java, para chamar a primeira console app menu, que poderá chamar as demais</h2><br>

```java
package app;

import br.com.consoleapp.framework.processor.AlgoritmProcessor;

public class Start {

	public static void main(String[] args) {
		try {
			
			AlgoritmProcessor.processar(new Menu());
			
		}catch(Exception e) {
			//suas tratativas aqui, erro capturado pelo framework
			System.out.println( String.format("ERRO DE EXECUÇÃO: %s", e.getMessage()) );
			
		}

	}

}

```
	
	

