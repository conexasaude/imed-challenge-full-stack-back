# Desafio iMedicina Backend

Este projeto foi construído utilizando Spring Boot, versão 2.7.7 (SNAPSHOT) e Java 11.

As dependências do projeto estão listadas no arquivo `pom.xml` dentro deste diretório.

Para executar este projeto, é preciso ter instalado uma versão do JDK 11. Eu utilizei a da RedHat, por ser open source, mas qualquer uma que fosse a 11 serviria.

Após isso, basta usar o maven incuído neste projeto ou um que esteja instalado na máquina e executar `clean` e `install`. Isso criará o banco de dados e também carregará as tabelas com algumas informações.

Para complementar o banco, basta listar os novos inserts no arquivo `imports.sql`, na pasta `./src/main/resources`.

### Dependências retiradas do build
As dependências de segurança foram retiradas do build pois elas não foram utilizadas. Quando as coloquei, imaginei fazer um servidor simples de autenticação e autorização, usando o protocolo OAuth2.

Após perceber que seria mais simples utilizar um servidor pronto para isso, retirei as dependências e comentei o código que estava escrevendo, mas ainda é possível ver a que passo estava a implementação olhando dentro da pasta `./src/main/java/com/imedicina/auth` e também nas configurações da aplicação em `properties.yml`.

## API
O modelo de API implementado é RESTful, utilizando protocolo HTTP.

### Entidades
Foram criadas três entidades para o projeto:
- Patient
- Professional
- Appointement

A persistência delas é feita utilizando JPA, Hibernate e H2.

## Endpoints
As três entidades têm seus próprios controladores, serviços e repositórios.

Dentre as três, Appointment (agendamento) é a entidade que tem a maior quantidade de endpoints, praticamente todos sendo consumidos pelo frontend e podendo ser validados com Postman ou Insomnia, por exemplo.

### /api/appointments/patient/{id}
Resgata todos os agendamentos de um paciente a partir do seu id.

### /api/appointments/professional/{id}
Resgata todos os agendamentos de um profissional a partir do seu id.

### /api/appointments/professional
Resgata todos os profissionais da base. Como melhoria, poderiam existir mais dois endpoints que resgatassem os profissionais baseados em filtros, como status (disponível ou indisponível).

### /api/appointments/professional/verifyTimeBox
Verifica se existe um agendamento para um profissional dentro de uma janela de tempo. Todas as janelas de tempo foram pensadas para serem fixas (30 minutos de atendimento). Como melhoria, a verificação poderia olhar dentro de intervalos, para consultas de tempo variável.

### /api/appointments/patient/create-appointment
Recebe um agendamento e salva na base de dados.

### /api/appointments/patient/create-appointment/{id}
Remove um agendamento da base de dados pelo id.

## O que não foi implementado
Como não houve implementação de segurança, esta API não contém métodos de decodificação de tokens JWT.

Existiu, porém, um esforço para fazer isso. Isso pode ser visto pelas dependências retiradas e pela tentativa de configuração de Beans de CORS e Web Security.

A aplicação receberia o token embutido nas requisições, validaria as permissões e assinaturas a cada chamada e retornaria. Se estivesse validade corretamente, o endipoint solicitado seria ativado. Se não, retornaria um erro HTTP 401 Unauthorized.

Infelizmente, essa implementação não pode acontecer em tempo hábil devido a diversos fatores pessoais até o momento.
