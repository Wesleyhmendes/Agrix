# `Projeto Agrix`

Boas-vindas ao repositório do projeto `Agrix`

<details>
  <summary>👨‍💻 O que deverá ser desenvolvido</summary><br />

Maria e João são pessoas empreendedoras que estão muito preocupadas com os impactos ambientais e
sociais dos nossos processos agrícolas. Por isso, decidiram criar a AgroTech, uma empresa
especializada em tecnologias para melhorar a eficiência no cultivo de plantações. Isso visa reduzir
o desperdício de recursos em geral e de alimentos em específico, fazendo um uso mais responsável da
terra disponível para plantio.

O primeiro produto dessa empresa será o Agrix, um sistema que permitirá a gestão e o monitoramento
das fazendas participantes.
</details>

<details>
  <summary><strong>📝 Habilidades a serem trabalhadas</strong></summary>

Neste projeto, verificamos se você é capaz de:

- Aplicar o conhecimento do ecossistema Spring para criar rotas da API.
- Aplicar a injeção de dependência para conectar as camadas de controle, serviço e persistência.
- Utilizar o Spring Data JPA para implementar entidades e repositórios para a persistência em banco
  de dados.
- Implementar gerenciamento de erros no Spring Web.
- Criar o Dockerfile para configurar a aplicação para execução no Docker.
- Aplicar o conhecimento do ecossistema Spring para criar rotas da API.
- Aplicar a injeção de dependência para conectar as camadas de controle, serviço e persistência.
- Utilizar o Spring Data JPA para implementar entidades e repositórios para a persistência em banco
  de dados, bem como implementar buscas customizadas.
- Utilizar campos de data nas rotas da API e no banco de dados
- Criar testes unitários para garantir a qualidade e funcionamento correto da implementação, com
  cobertura de código adequada. 
- Aplicar o conhecimento sobre Spring Security para adicionar autenticação ao projeto.
- Garantir que diferentes rotas atenda a regras específicas de autorização. 

</details>

## Especificações do projeto

<details>
<summary>🗄️ Descrição do banco de dados</summary><br>

O banco de dados continua com o diagrama como estava na Fase B:

![Modelo de tabelas](images/agrix-tabelas-fase-b.png)

Nesse modelos, temos as seguintes tabelas:
- `farm`: representa uma fazenda
- `crop`: representa uma plantação, e está em relacionamento `n:1` ("muitos para um") com a tabela `farm`
- `fertilizer`: esta nova tabela representa um fertilizante, e está em um relacionamento `n:n` ("muitos para muitos") com a tabela `crop`. Esse relacionamento é realizado através da tabela `crop_fertilizer`.

A diferença agora é que precisamos integrar o código para controle de pessoas ao restante da nossa aplicação.

Alguns elementos importantes a considerar sobre a implementação da camada de persistência e do banco de dados:
- Apesar do nome das tabelas e colunas (com seus tipos) não precisarem ser exatamente esses, os testes do projeto chamarão sua API usando requisições e esperam respostas baseados nesse modelo.
- Os testes do projeto não esperam um banco de dados específico. No entanto, sugerimos que você utilize o MySQL como banco de dados.
- Os testes do projeto utilizam um banco "mockado" em memória do tipo H2. Isso não deve afetar sua implementação, mas tome cuidado ao utilizar funcionalidades muito específicas de um determinado tipo de banco de dados e que não sejam compatíveis com os testes.
</details>

## Requisitos

### 1. Migre seu código da Fase B para este projeto (Fase C)

<details>
  <summary>Migre seu código que implementou no "Agrix - Fase B" para este projeto (Fase C)</summary><br />

Neste requisito, você deverá trazer todo o código que você implementou durante o "Agrix - Fase B" para este projeto (Agrix - Fase C).

Tome cuidado especial com:
 - `pom.xml`: o `pom.xml` inicial das Fase C não é igual ao `pom.xml` da Fase B, então você não pode simplesmente substituílo. Cuide para transferir apenas as dependências que você incluiu, sem alterar as outras configurações do projeto.
 
Durante os testes deste requisito, serão validadas as seguintes rotas:
 - GET `/farms`
 - GET `/crops`
 - GET `/fertilizers`

Você precisará trazer todo o código que você implementou na fase anterior para conseguir finalizar esta fase.

</details>

### 2. Crie a rota POST /persons

<details>
  <summary>Crie a rota POST /persons para salvar novas pessoas no banco</summary><br />

Neste requisito você vai criar uma rota para integrar a API com o código que foi adquirido e testado na fase anterior, localizado no pacote `com.betrybe.agrix.ebytr.staff`.

Se quiser, nesta fase você já pode refatorar o código desse pacote e mover ele para seguir a organização do restante da sua aplicação.

A definição da rota é:
- `/persons` (`POST`)
    - deve receber no corpo da requisição:
      - `username`
      - `password`
      - `roles` (conforme definido no enum `Role`, disponibilizado com o código)
    - deve criar a pessoa com os dados passados
    - deve responder com os campos `id`, `username` e `role` (mas não `password`)

</details>

### 3. Adicione autenticação no projeto

<details>
  <summary>Adicione autenticação no projeto, incluindo uma rota para login que retorna um JWT</summary><br />

Neste requisito você deverá configurar o Spring Security e implementar no seu projeto a autenticação por usuário e senha.

Você deverá:
1. Garantir acesso público (ou seja, desprotegido) aos endpoints:
    - POST `/persons` (criado acima, para permitir cadastro de novas pessoas)
    - POST `/auth/login` (será criado abaixo, para permitir login) 
2. Criar a rota POST `/auth/login`:
    - deve receber o `username` e `password` no corpo da requisição
    - deve validar os dados passados utilizando as pessoas que foram criadas pela rota `/persons`
    - caso os dados estejam incorretos, deve retornar status 403
    - caso os dados estejam corretos, deve retornar um campo `token` contendo um JWT gerado

</details>

### 4. Limitar acesso à rota GET /farms

### 5. Limitar acesso à rota GET /crops

### 6. Limitar acesso à rota GET /fertilizers

</details>
