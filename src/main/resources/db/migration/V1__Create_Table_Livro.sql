CREATE TABLE `livros` (
  `id` bigint NOT NULL,
  `autor` varchar(255) NOT NULL,
  `categoria` varchar(255) NOT NULL,
  `colecao` varchar(255) DEFAULT NULL,
  `compra` datetime DEFAULT NULL,
  `editora` varchar(255) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `notas` varchar(255) DEFAULT NULL,
  `registro` datetime DEFAULT NULL,
  `sub_categoria` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) NOT NULL,
  `isbn` varchar(13) NOT NULL,
  `paginas` int DEFAULT NULL,
  PRIMARY KEY (`id`)
)