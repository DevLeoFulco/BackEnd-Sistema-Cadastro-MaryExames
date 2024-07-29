### BackEnd do Sistema de Cadastro de Pacientes

## Contexto do Projeto

Este projeto faz parte do desenvolvimento de um sistema de cadastro de pacientes, que visa a facilitar a gestão de informações pessoais e biométricas dos pacientes. O sistema é projetado para ser utilizado em clínicas, hospitais e outras instituições de saúde, proporcionando um armazenamento seguro e eficiente dos dados dos pacientes.

## Arquitetura do BackEnd

A arquitetura escolhida para este projeto é baseada no padrão de microserviços. Optamos por microserviços devido à sua capacidade de proporcionar escalabilidade, manutenção e desenvolvimento independentes. Cada serviço pode ser atualizado, escalado e implantado independentemente, permitindo uma maior flexibilidade e resiliência do sistema.

### Modelo de Arquitetura do Backend

#### Descrição Geral
CCada componente da aplicação está sendo containerizado usando Docker e gerenciado pelo Kubernetes. A comunicação entre os serviços é feita através de APIs RESTful. A segurança é garantida com a utilização de autenticação JWT.

#### Componentes

1. **Gateway API**: 
   - **Responsabilidade**: Atua como ponto de entrada único para todas as requisições do cliente. Gerencia a autenticação, roteamento de requisições e balanceamento de carga.
   - **Tecnologia**: Spring Cloud Gateway.

2. **Serviço de Autenticação**: 
   - **Responsabilidade**: Gerencia a autenticação e autorização dos usuários, gerando tokens JWT para as sessões autenticadas.
   - **Tecnologia**: Spring Security, JWT.

3. **Serviço de Cadastro de Pacientes**: 
   - **Responsabilidade**: Gerencia as operações de CRUD relacionadas aos pacientes, incluindo dados pessoais e biométricos.
   - **Tecnologia**: Spring Boot, PostgreSQL.

4. **Serviço de Gerenciamento de Biometria**:
   - **Responsabilidade**: Gerencia o armazenamento e processamento dos dados biométricos dos pacientes.
   - **Tecnologia**: Spring Boot, armazenamento de arquivos (pode ser AWS S3 ou similar).

5. **Serviço de Notificações**:
   - **Responsabilidade**: Envia notificações aos usuários sobre o status do cadastro e outras ações relevantes.
   - **Tecnologia**: Spring Boot, serviço de mensageria (Kafka).

6. **Banco de Dados**: 
   - **Responsabilidade**: Armazenamento persistente dos dados dos pacientes.
   - **Tecnologia**: PostgreSQL.

7. **Gerenciamento de Configurações**:
   - **Responsabilidade**: Armazena e distribui as configurações dos microserviços.
   - **Tecnologia**: Spring Cloud Config.

#### Fluxo de Dados

1. **Requisição do Cliente**:
   - O cliente envia uma requisição ao Gateway API.

2. **Autenticação**:
   - O Gateway API encaminha a requisição para o Serviço de Autenticação, que valida o token JWT.

3. **Processamento da Requisição**:
   - Após a autenticação, o Gateway API roteia a requisição para o serviço apropriado (Cadastro de Pacientes, Gerenciamento de Biometria, etc.).

4. **Acesso ao Banco de Dados**:
   - O serviço realiza operações de leitura/escrita no banco de dados PostgreSQL conforme necessário.

5. **Resposta ao Cliente**:
   - A resposta é encaminhada de volta ao cliente através do Gateway API.

#### Diagrama de Arquitetura

Esse é um diagrama simplificado da arquitetura descrita acima:

```
                 +----------------------+
                 |       Cliente        |
                 +----------------------+
                           |
                           v
                 +----------------------+
                 |     Gateway API      | -------------------------
                 +----------------------+                          |
                    /         |                                    v  
                   v          v        
  +---------------------+  +----------------------+      +-----------------------+
  | Serviço de Cadastro |  | Serviço de Gerenciamento |  | Serviço de Notificações |
  |     de Pacientes    |  |        de Biometria      |  +-----------------------+
  +---------------------+  +----------------------+                |
            |                      |                               v
            v                      v                        +----------------------+
  +----------------------+  +----------------------+        |         Push         |
  |      PostgreSQL      |  |      MongoDb         |        +----------------------+
  +----------------------+  +----------------------+
```

Esse diagrama representa uma visão geral de alto nível da arquitetura do backend. Cada componente pode ter subcomponentes adicionais para manusear tarefas específicas, como validação de dados, caching, logging, etc.

## Tecnologias Utilizadas

- **Java 17:** A escolha do Java se deve à sua robustez, segurança e ampla adoção na indústria. Java oferece uma excelente performance e uma vasta quantidade de bibliotecas e frameworks que facilitam o desenvolvimento.
- **Spring Boot:** Escolhemos o Spring Boot por sua capacidade de simplificar a configuração e o desenvolvimento de aplicações Java, proporcionando uma rápida inicialização de projetos e integração com diversas ferramentas e tecnologias.
- **PostgreSQL:** Optamos pelo PostgreSQL como banco de dados relacional devido à sua confiabilidade, desempenho e suporte a transações complexas e integrações.
- **Docker:** Utilizamos Docker para containerizar a aplicação, garantindo que ela possa ser executada em qualquer ambiente de forma consistente e sem conflitos de dependências.
- **Kubernetes:** Kubernetes foi escolhido para orquestrar e gerenciar os contêineres, proporcionando escalabilidade e alta disponibilidade da aplicação.

## Estado Atual do Sistema

Atualmente, o sistema está em uma fase funcional onde os usuários podem cadastrar pacientes, incluindo dados pessoais e biométricos. O backend está totalmente integrado com o frontend, permitindo uma comunicação fluida entre as camadas.

Para a escalabilidade, planejamos implementar a divisão dos microserviços em diferentes clusters, utilizando balanceamento de carga para distribuir o tráfego de forma eficiente e assegurar a alta disponibilidade e resiliência do sistema.

## Integração com o FrontEnd

O backend foi desenvolvido com APIs RESTful que se comunicam com o frontend, desenvolvido em React 18.2.0. Utilizamos JWT para autenticação e segurança, garantindo que apenas usuários autorizados possam acessar os dados.

## Configuração e Execução Local

Para configurar e rodar o backend em sua máquina local, siga os passos abaixo:

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio/backend
   ```

2. **Configure o banco de dados:**
   Certifique-se de ter o PostgreSQL instalado e configure um banco de dados:
   ```sql
   CREATE DATABASE nome_do_banco;
   ```

3. **Configure as variáveis de ambiente:**
   Crie um arquivo `.env` na raiz do projeto e adicione as variáveis necessárias:
   ```env
   DB_URL=jdbc:postgresql://localhost:5432/nome_do_banco
   DB_USERNAME=seu_usuario
   DB_PASSWORD=sua_senha
   ```

4. **Execute o Docker:**
   Certifique-se de ter o Docker instalado e execute os contêineres:
   ```bash
   docker-compose up
   ```

5. **Execute a aplicação:**
   ```bash
   ./mvnw spring-boot:run
   ```

## Como Contribuir

Contribuições são bem-vindas! Para contribuir com o projeto:

1. Faça um fork do repositório.
2. Crie uma nova branch para sua feature ou correção de bug:
   ```bash
   git checkout -b minha-nova-feature
   ```
3. Faça suas alterações e comite-as:
   ```bash
   git commit -m 'Adicionar nova feature'
   ```
4. Envie suas alterações para a branch principal:
   ```bash
   git push origin minha-nova-feature
   ```
5. Abra um Pull Request.

## Aviso

Este projeto, embora esteja público, pertence à rede de clínicas Mary Exames e sua publicação foi autorizada apenas para fins de demonstração de case de sucesso. A reprodução ou utilização deste código em outros projetos deve ter autorização prévia dos responsáveis.
