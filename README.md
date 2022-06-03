# MyBooksProject


Uma aplicação para fazer o controle e registro de livros em uma biblioteca.


## Tecnologias utilizadas:

- Linguagem java;
- Maven;
- JUnit 4;
- Padrão de projeto VO
- Repository;
- Hateoas;
- Swagger;
- Migrations;

Utilizei o framework swagger para fornecer a documentação de minha aplicação e ajudar na descrição, consumo e vizualização dos serviços.

Para ter acesso a esta documentação, basta executar a classe MyBooksProjectApplication e depois, no seu navegador digitar o endereço http://localhost:8080/swagger-ui.html

Tambem utilizei o Migration para popular o banco de dados.

## Estrutura do projeto:

Caso esteja usando o eclipse, deve-se importar o projeto usando a opção "import maven project".


Nosso projeto tem a estrutura projeto Value objec, que tem como intuito deixar as informaões de nossa classe preservada, como estrutura de nossas tabelas no banco e utilizar uma classe intermediaria que sera responsavel pela exposição de nossos dados. 

No pacote Builder, tem uma classe chamada BuilderLivro, que tem um mock para craição de um livro com dados genericos para teste.

No pacote config, temos as classes que fazem a configuração para receber dados do tipo json e X-yml( na classe Config.java) e  para fornecer a documenmtação via Swagger (na classe SwaggerConfig).

Na pacote controler, temos a Classe LivroControle, que é a versão anterior refatoração para o padrão de projeto VO e a classe LivroControllerVO que é a responsavel por receber as requisições via http e manipular os metodos que estão na classe service, ela tambem esta configurada para receber ou produzer dados no formato json, xml e x-yaml quando necessario.
	Os metodos são:

- create: Salva um novo livro do banco de dados.
- findById: Encontra livro pelo id de registro.
- findByTitulo: Encontra livro pelo titulo.
- findByAutor: Encontra livro pelo autor.
- findAll: Chama todos os livros registrados.
- update: Faz a alteração em algum campo do livro registrado.
- delere: Exclui o livro do registro.

Eu utilizei a anotação @ApiOperation para fazer a identificação dos metodos na interfaçe de vizualização.
	Nos metodos que retornam algum produto, foi implementato do componente HATEOAS da arquitetura Rest, para fornecer o endpoint deste produto.
	No metodo findAll, que tem como objetivo mostrar todos os produtos, foi configurado para mostrar os resultados paginados (com o solicitante definindo a quantidade de itens por pagina e qual pagina sera mostrada) e ordenado (ascendente ou decrescente), caso o usuario nao faça nenhuma seleção, um valor padrao foi estabelecido. 

No pacote converter, temos a classe DozerConverter que é responsavel por converter as classes entity em VO e VO em entity e a classe YanJacksonHttpMessageConverter que fornece as respostas no modelo YAML.

O pacote entity esta minhas entidades, a classe Livro e LivroVO.

No pacote reposisitory encontrasse minha interface LivroRepository, que tem a finalidade de fazer a interação com o banco de dados, e fornecer alguns metodos especificos como o findByTitudo e findByAutor.

No pacote service, encontrasse minhas classes service e a classe LivriServiceVO que é onde esta o meu CRUD,foi nela implementei a interface repository para fazer a interação com o banco de dados.

E por fim, a classe MyBooksProjectApplication é a responsavel de por a palicação no ar.


	

	


