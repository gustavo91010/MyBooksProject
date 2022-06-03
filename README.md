logoCorrecao.pt
English
InícioSobrePrivacidadeContacto

Resultado
Tipo e número de erros encontrados:
Ortográficos (62)Outro (3)REGISTER (4)Gramatical (3)Tipográficos (15)Espaçamento (2)
Copy
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

Utilizei o framework swagger para fornecer a documentação de minha aplicação e ajudar na descrição, consumo e visualização dos serviços.

Para ter acesso a esta documentação, basta executar a classe MyBooksProjectApplication e depois, no seu navegador digitar o endereço http://localhost:8080/swagger-ui.html

Também utilizei o Migration para popular o banco de dados.

## Estrutura do projeto:

Caso esteja usando o eclipse, deve-se importar o projeto usando a opção "import maven project".


Nosso projeto tem a estrutura projeto Value objec, que tem como intuito deixar as informações de nossa classe preservada, como estrutura de nossas tabelas no banco e utilizar uma classe intermediaria que sera responsável pela exposição de nossos dados. 

No pacote Builder, tem uma classe chamada BuilderLivro, que tem um mock para criação de um livro com dados genéricos para teste.

No pacote config, temos as classes que fazem a configuração para receber dados do tipo json e X-yml( na classe Config.java) e  para fornecer a documentação via Swagger (na classe SwaggerConfig).

Na pacote controller, temos a Classe LivroControle, sendo a versão anterior a refatoração para o padrão de projeto VO e a classe LivroControllerVO que é a responsável por receber as requisições via http e manipular os métodos que estão na classe service, ela também esta configurada para receber ou produzir dados no formato json, xml e x-yaml quando necessário.
	Os métodos são:

- create. Salvar um novo livro do banco de dados.
- findById. Encontrar livro pelo id de registro.
- findByTitulo. Encontrar livro pelo título.
- findByAutor. Encontrar livro pelo autor.
- findAll. Chamar todos os livros registrados.
- update. Fazer uma alteração em algum campo do livro registrado.
- delere. Excluir o livro do registro.

Eu utilizei a anotação @ApiOperation para fazer a identificação dos métodos na interface de visualização.
	Nos métodos que retornam algum produto, foi implementado do componente HATEOAS da arquitetura Rest, para fornecer o endpoint deste produto.
	No método findAll, que tem como objetivo mostrar todos os produtos, foi configurado para mostrar os resultados paginados (com o solicitante definindo a quantidade de itens por página e qual pagina sera mostrada) e ordenado (ascendente ou decrescente), caso o usuário não faça nenhuma seleção, um valor padrão foi estabelecido. 

No pacote converter, temos a classe DozerConverter que é responsável por converter as classes entity em VO e VO em entity e a classe YanJacksonHttpMessageConverter que fornece as respostas no modelo YAML.

No pacote entity estao as minhas entidades, a classe Livro e LivroVO.

No pacote reposisitory encontrasse minha interface LivroRepository, que tem a finalidade de fazer a interação com o banco de dados, e fornecer alguns métodos específicos como o findByTitudo e findByAutor.

No pacote service, encontrasse minhas classes service e a classe LivriServiceVO que é onde esta o meu CRUD, foi nela que implementei a interface repository para fazer a interação com o banco de dados.

E por fim, a classe MyBooksProjectApplication é a responsável de por apalicação no ar.

