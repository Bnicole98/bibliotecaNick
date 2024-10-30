1.Visão Geral do Projeto
1.1. Descrição
        O projeto foca em criação de um sistema de biblioteca com funcionalidades de cadastramento
    de acervo, usuário, empréstimo e devolução de livros.

1.2. Arquitetura do Sistema
        No projeto utilizou da linguagem de programação Java e MAVEN para controle de dependências (SPARK, MYSQL CONNECTOR, GSON).

2. Configuração do Ambiente
2.1. Requisitos do Sistema
    Versão: JDK 8 ou superior (JDK 11 recomendado)
    Versão: 3.6.3 ou superior
    Versão: MySQL 5.7 ou superior (MySQL 8.0 recomendado)

2.2. Instalação
2.2.1. Configuração do Projeto
git clone git@github.com:Bnicole98/bibliotecaNick.git
cd backend

mvn clean install
mvn exec:java

2.2.2. Configuração do Banco de Dados
   CREATE TABLE Usuario
   (
    ID_RGM INT  AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(30),
    Email VARCHAR(20),
    Telefone VARCHAR(15),
    Endereco VARCHAR(50)
   );

   CREATE TABLE Emprestimo
   (
    ID_Emprestimo INT AUTO_INCREMENT PRIMARY KEY,
    Data_Emprestimo DATE,
    Data_Prevista_Devolucao DATE,
    ID_RGM INT,
    ID_Livro INT
   );

   CREATE TABLE Livro
   (
    ID_Livro INT AUTO_INCREMENT PRIMARY KEY,
    Data_Publicacao DATE,
    ISBN CHAR(8),
    Autor VARCHAR(20),
    Editor VARCHAR(20),
    Titulo VARCHAR(20)
   );

   CREATE TABLE Devolucao
   (
    Data_Devolucao DATE,
    ID_Devolucao INT AUTO_INCREMENT PRIMARY KEY,
    ID_Emprestimo INT
   );

   ALTER TABLE Emprestimo ADD FOREIGN KEY(ID_RGM) REFERENCES Usuario (ID_RGM);
   ALTER TABLE Emprestimo ADD FOREIGN KEY(ID_Livro) REFERENCES Livro (ID_Livro);
   ALTER TABLE Devolucao ADD FOREIGN KEY(ID_Emprestimo) REFERENCES Emprestimo (ID_Emprestimo);

3. Endpoints REST
3.1. Endpoints de Usuários

    *   GET /bibliotecaNick/usuario/list - >Obtém uma lista de todos os usuários.

    *   GET /bibliotecaNick/usuario/:id - >Obtém um usuário pelo ID.

3.2. Endpoints de Livros

3.3. Endpoints de Emprestimo

3.4. Endpoints de Devolucao


