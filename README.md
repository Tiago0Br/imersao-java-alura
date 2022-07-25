# Alura Stickers

## Descrição

Projeto desenvolvido no evento **Imersão Java** ⚡ da [Alura](https://www.alura.com.br).

O programa consome APIs, copiando imagens e gerando figurinhas a partir dessas imagens.
Atualmente, o projeto usa duas APIs: [Melhores filmes segundo o IMDB](https://alura-imdb-api.herokuapp.com/movies) e [Imagens da NASA](https://api.mocki.io/v2/549a5d8b/NASA-APOD)
O programa pede para o usuário selecionar qual das APIs será usada para a geração das figurinhas e também pede para o usuário digitar a quantidade de figurinhas que ele deseja gerar, exibindo o total de imagens obtidas pela API. Após o usuário informar a quantidade, as figurinhas são geradas na pasta stickers. Até o momento as figurinhas possuem apenas o texto "Topzera" abaixo das imagens.
  

## 🚀 Desafios propostos

 - [ ] Consumir o endpoint de filmes mais populares da API do IMDB. Procure também, na documentação da API do IMDB, o endpoint que retorna as melhores séries e o que retorna as séries mais populares.
 - [ ] Usar sua criatividade para deixar a saída dos dados mais bonitinha: usar emojis com código UTF-8, mostrar a nota do filme como estrelinhas, decorar o terminal com cores, negrito e itálico usando códigos ANSI, e mais!
 - [ ] Colocar a chave da API do IMDB em algum lugar fora do código como um arquivo de configuração (p. ex, um arquivo .properties) ou uma variável de ambiente
 - [ ] Mudar o JsonParser para usar uma biblioteca de parsing de JSON como Jackson ou GSON
 - [ ] Desafio supremo: criar alguma maneira para você dar uma avaliação ao filme, puxando de algum arquivo de configuração OU pedindo a avaliação para o usuário digitar no terminal.
 - [ ] Centralizar o texto na figurinha.
 - [X] Criar diretório de saída das imagens, se ainda não existir.
 - [ ] Colocar outra fonte como a Comic Sans ou a Impact, a fonte usada em memes.
 - [ ] Colocar contorno (outline) no texto da imagem.
 - [X] Tratar as imagens retornadas pela API do IMDB para pegar uma imagem maior ao invés dos thumbnails. Opções: pegar a URL da imagem e remover o trecho mostrado durante a aula ou consumir o endpoint de posters da API do IMDB (mais trabalhoso), tratando o JSON retornado.
 - [ ] Fazer com que o texto da figurinha seja personalizado de acordo com as classificações do IMDB.
 - [ ] Desafio supremo: usar alguma biblioteca de manipulação de imagens como OpenCV pra extrair imagem principal e contorná-la.
 - [ ] Transformar a classe que representa os conteúdos em um Record, disponível a partir do Java 16
 - [ ] Criar as suas próprias exceções e usá-las na classe que implementa o cliente HTTP
 - [ ] Usar recursos do Java 8 e posterior, como Streams e Lambdas, para mapear uma lista em uma outra
 - [ ] Criar uma Enum que une, como configurações, a URL da API e o extrator utilizado
 - [ ] Desafio supremo: consumir outras APIs que contém imagens, como a da Marvel, que é bem diferente. Repositório com APIs públicas: clique aqui.
  

## 👨🏻‍💻 Como executar o projeto

 **Pré-requisitos**: [Git](https://git-scm.com) e [Java](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) (foi utilizada a versão 17.0) instalados no computador.
 - Fazer o clone do projeto.

	    git clone git@github.com:<seu usuário>/imersao-java-alura.git 

 - Abrir o projeto no editor de sua preferência.
 - Executar o arquivo App.java

---

  
Feito com 💜 &nbsp;por Tiago Lopes 👋 &nbsp;[Meu Github](https://github.com/Tiago0Br)