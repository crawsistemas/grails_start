# Projeto Grails START - Gestão de Vendas 
![GitHub repo size](https://img.shields.io/github/repo-size/iuricode/README-template?style=for-the-badge)

## Sobre o projeto

Este é um projeto piloto mantido pela <a href="https://crawsistemas.com">Craw Sistemas</a> para estimular a iniciação e aprendizagem do Framework GRAILS(<a href="https://grails.org/">https://grails.org/</a>). Este projeto está descrito e documentado utilizando os padrões projetos aplicados nos produtos da empresa. As ferramentas e versões utilizadas serão:
* Grails 3.3.11
* Banco de dados Postgres 9.4

> **Se deseja trabalhar conosco, mostre seu diferencial estudando e implementando este projeto**. Estamos a disposição para ajudar no que precisar!

<!--### Porque GRAILS?
Ainda esta na dúvida porque iniciar este estudo no framework Grails, vai aí alguns motivos: -->

### 💻 Pré-requisitos
Antes de começar, verifique se você atendeu aos seguintes requisitos:
* Disposição e vontade em adquirir novos conhecimentos.
* Conhecimentos básicos em Teoria de Orientação a Objetos.
* Conhecimentos básicos em Banco de dados.
* Tem uma máquina com `<Windows / Linux / Mac>`. O framework é multiplataforma e pode ser instalado em qualquer sistema operacional que rode a plataforma `Java`.
* JDK 1.8 instalado. Download para `Windows` disponível na pasta `requisitos`.

## Configuração Java

No `Windows` acesse as configurações de variáveis de ambiente do sistema e realize as alterações abaixo ou utilize os seguintes comandos para `Linux`:

- Criar variável de ambiente chamada JAVA_HOME:
```
export JAVA_HOME=<PATH DA INSTALAÇÃO JDK 1.8>
```

- Adicionar JAVA_HOME ao path do dispositivo:
```
export PATH="$PATH:$JAVA_HOME/bin
```

## Instalando o Grails

Download do framework:
```
https://objects.githubusercontent.com/github-production-release-asset-2e65be/512295/8a84e000-ef8a-11e9-8a56-9e869421dbd8?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAIWNJYAX4CSVEH53A%2F20211126%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20211126T130926Z&X-Amz-Expires=300&X-Amz-Signature=e16ac77985e8843cef602f3809d70705df81b09319a03df9642db4959413e7a7&X-Amz-SignedHeaders=host&actor_id=34774584&key_id=0&repo_id=512295&response-content-disposition=attachment%3B%20filename%3Dgrails-3.3.11.zip&response-content-type=application%2Foctet-stream
```
* Extraia o conteúdo do download realizado e defina uma nova variável de ambiente chamada GRAILS_HOME para o local onde você extraiu o `zip`.
  - Em sistemas Linux, isso normalmente é feito da seguinte maneira: 
  ```
  export GRAILS_HOME=<PATH DA DESCOMPACTAÇÃO GRAILS>
  ```
  - No Windows, basta definir uma variável de ambiente em `My Computer/Advanced/Environment Variables`

* Em seguida, adicione a pasta `bin` à sua variável `PATH`:
  - Em sistemas Linux, isso pode ser feito adicionando 
  ```
  export PATH="$PATH:$GRAILS_HOME/bin'
  ```
  - No Windows, isso é feito modificando a variável de ambiente `PATH`

Com estas etapas realizadas o framework já esta instalado e pronto para uso :clap:. Para testar seu funcionamento, execute o comando `grails -version` em seu terminal e a resposta esperada deverá ser:
```
Grails version: 3.3.11
```
Para mais informações acesse a documentação oficial <a href="http://docs.grails.org/3.3.11/guide/single.html#gettingStarted">clicando aqui</a>.

# Definições do projeto
Criar um sistema WEB para gestão de Vendas, utilizando o framework Grails e salvando os registros em um banco de dados Postgres. 

Nos próximos itens serão apresentados alguns diagramas para ajudar no entendimento do projeto. Os diagramas foram desenvolvidos utilizando a ferraments <a herf="https://staruml.io/">StartUML</a>. Uma <a href="https://github.com/alisonweber/grails_start/blob/01959c20fd48eb34e522ff3eab7e3b9c5b477a0f/ModeloStarUML.mdj">cópia do modelo</a> esta presente neste projeto.

### Use Case Diagram
O diagrama abaixo apresenta o usuário do sistema (também conhecidos como ator) e as interações dele com o sistema. Nele poderá ver os cenários que devem ser desenvolvidos e o escopo geral do sistema.

![image](https://user-images.githubusercontent.com/34774584/143625127-33866ed8-0179-4ad7-98c8-9e572c1ac3f1.png)

### Class Diagram
O diagrama abaixo ilustra os modelos de dados para o sistema a ser desenvolvido, apresentando uma visão geral dos esquemas e necessidades da aplicação.

![image](https://user-images.githubusercontent.com/34774584/143627093-eef14618-4a28-4278-ac60-55fd07f299ce.png)

### Regras para os Modelos
	Usuário
	- nome: obrigatório, tamanho máximo de 255
	- usuario: obrigatório, tamanho máximo de 50 //Atributo utilizado para realizar o login no sitema
	- senha: obrigatório, tamanho máximo de 50, deve possuir letras e números

	Produto
	- nome: obrigatório, tamanho máximo de 255
	- valorPadrao: facultativo //Atributo utilizado para carregar o valor padrão do produto durante a digitação de uma Venda
	
	Cliente
	- nome: obrigatório, tamanho máximo de 255
	- cpfCnpj: obrigatório, validar se preenchimento é de tamanho 11 ou 14 digitos compostos apenas de números;
	- email: facultivo, validar se é e-mail valido;
	
	Venda
	- cliente: obrigatório
	- valorTotal: obrigatório, maior que 0.00 //somatório de todos os itens da venda
	- itensVenda: obrigatóroo, deve possuir ao menos 1 item
	
	VendaItem
	- produto: obrigatório
	- valorUnitario: obrigatório //carregar automaticamente ao selecionar um produto cadastrado do atributo valorPadrao
	- quantidade: obrigatório, maior que 0.00
	- desconto: facultativo
	- valorTotalItem: obrigatóroo, maior que 0.00 // valorTotalItem = (valorUnitario * quantidade) - desconto
	
## Criando o projeto

Para criar um novo projeto ou executar qualquer comando utilizando o framework é necessário conhecer o comando `grails`. Com este comando é possível criar aplicações, executar o projeto, criar controladores, criar domínios, etc.
```
grails <<command name>>
```
Executando o comando `create-app` uma nova aplicação será criada na pasta onde o comando foi executado, com toda estruturação do framework ponta para execução.
```
grails create-app gestao_vendas
```
Logo após o comando esta presente o nome da aplicação "gestao_vendas". É importante que este nome não possua caracteres especiais ou espaço.

#### O que temos no projeto e quais são as pastas:
Para conseguir desempenhar um bom trabalho no framework, você precisa se familiarizar com a estrutura de diretórios fornecida pelo Grails. Aqui está uma análise e links para as seções relevantes:
- gestao_vendas - Raiz do projeto
	- gradle - Sistema de compilação, diretório padrão/automático criado
	- grails-app - Diretório de nível superior para fontes Groovy
		- <a href="https://gsp.grails.org/latest/guide/resources.html">assets</a> - Local de recursos como CSS, JavaScript e imagens
		- <a href="http://docs.grails.org/3.3.11/guide/conf.html">conf</a> - Fontes de configuração
		- <a href="http://docs.grails.org/3.3.11/guide/theWebLayer.html#controllers">controllers</a>- Controladores da Web - O C em MVC
		- <a href="http://docs.grails.org/3.3.11/guide/GORM.html">domain</a>- O domínio do aplicativo. - O M em MVC
		- <a href="http://docs.grails.org/3.3.11/guide/i18n.html">i18n</a>- Suporte para internacionalização (i18n)
		- services- A camada de serviço (NÃO SERÁ UTILIZADA)
		- <a href="http://docs.grails.org/3.3.11/guide/theWebLayer.html#taglibs">taglib</a>- Bibliotecas de tags
		- utils - Utilitários específicos do Grails
		- views - <a href="http://docs.grails.org/3.3.11/guide/theWebLayer.html#gsp">Groovy Server Pages</a> ou <a href="http://views.grails.org/latest">JSON Views</a> (HTML + Tags Grails) - The V em MVC
	- src/main/groovy - Fontes de apoio
	- src/test/groovy - Testes de unidade e integração

Se deseja executar sua aplicação, execute na pasta do projeto:
```
grails run-app
```
Isso iniciará um servidor integrado na porta 8080 que hospeda seu aplicativo. Conseguirá acessar seu aplicativo na URL:
```
http://localhost:8080/
```

#### Existe uma IDE?
Não existe uma IDE oficial para Grails, mas existem vários editores de texto excelentes que funcionam bem com Groovy e Grails. Veja abaixo alguns: 
- Visual Studio Code (Utilizado por nós) - Plugins disponíveis para imporação.
- NetBeans - Plugin grails disponível e muito útil quando o projeto possui combinção com códigos Java.
- IntelliJ IDEA - Versão gratuita com menos recursos e uma versão paga completa.
- Existe um pacote TextMate com suporte Groovy/Grails no Textmate.
- Um plug-in de texto Sublime pode ser instalado por meio do Controle de pacotes.
- Um pacote Atom está disponível para uso com o editor.

### Primeiro CRUD

Uma classe de domínio representa o modelo principal por trás de seu aplicativo e é normalmente mapeada em tabelas de banco de dados. Para obter mais informações sobre modelos de domínio em Grails <a href="https://docs.grails.org/latest/ref/Command%20Line/create-domain-class.html">cliquei aqui</a>.

Para criar uma classe de dominio, digite o comando abaixo, especificando o nome do domínio a ser criado:
```
grails create-domain-class Produto
```
Para mais informações sobre o controle de domínios, acesse <a href="https://docs.grails.org/latest/ref/Domain%20Classes/Usage.html">documentação oficial</a>.

### CRUD de Exemplo

A base padrão do framework é o pradão <a href="https://pt.wikipedia.org/wiki/MVC">MVC</a> e todo código pode ser construido manualmente neste padrão. Para otimizar a construção das classes de controladores e telas, podemos executar o seguinte comando:

```
grails generate-all Produto
```

Isso irá criar um controlador, telas e um teste de unidade para a classe de domínio fornecida.

> Templates:
> 
> A criação deste código pelo comando `generate-all` é feita utilizando o padrão de templates do grails, que pode ser estilizado. Cada versão do framework possui uma estrutura de código diferente e nós utilizamos o padrão encontrado na versão 2.2.5. No diretorio `gestao_vendas\src\main\templates` estão os arquivos que são utilizados pelo Grails para gerar os CRUDs a partir dos modelos. Para mais informações acesse: <a href="https://docs.grails.org/latest/ref/Command%20Line/install-templates.html">Grails Templates</a>.

Estes códigos gerados precisam de ajustes para criar a pesonalização necessária para o projeto, e é aí que o programador vai atuar principalmente, fazendo as modificações para chegar a versão final.

Nas templates de "_form" geradas, perceberá o uso do plugin <a href="https://plugins.grails.org/plugin/grails/fields">Fields</a>. Este plugin não é utilizado por nós, então o conteudo dos forms deve ser substituido por <a href="https://gsp.grails.org/latest/guide/index.html#formsAndFields">Forms and Fields</a> seguindo o exemplo já construido na gestão de produtos.

### Banco de dados

O banco de dados já foi configurado na aplicação de exemplo, basta criar um banco de dados com as seguintes configurações:

- Database name: gestao_vendas_db
- user: postgres
- password: pgsql

Procure entender como foi realizado esta configuração, pois ela será muito util. Se precisar alterar os dados da configuração para rodar em seu dispositivo, sem problemas, desde que seja utilizando um banco de dados Postgres.

# AGORA É COM VOCÊ

Realize um fork do projeto. A gestão de Produtos já esta pronta, tome como base para desenvolver o restante.

Objetivo é finalizar este projeto com a sua cara, contendo as mesmas funcionalidades deste finalizado:

[** EM PROCESSO DE CONSTRUÇÃO **]

- <a href="http://gvexemplo.crawsistemas.com">http://gvexemplo.crawsistemas.com</a> 
- Usuário: vendedor
- Senha: bonsEstudos123

Se precisar de ajuda, pode entrar em contato conosco utilizando as seguintes opções:

- Utilize o Wiki
- E-mail: desenvolvimento@crawsistemas.com

## Para nos enviar seu código, você pode:

- Mandar uma pull-request com o fork desse repositório.

ou

- Dar acesso ao seu repositório privado no Gitlab para o usuário <definir>.
	
### Avaliação
	
- Iremos verificar o código do projeto e como foi solucionado. Não hesite em nos surpreender positivamente.
- Gostariamos de uma explicação da solução e do aprendizado que teve. Poderá ser oral ou em arquivo de texto separado em Markdown/Plain Text.
