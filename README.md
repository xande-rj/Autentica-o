Autenticação - Validação de Token (Spring Boot)

Serviço simples que valida um token de acesso recebido no header Authorization e protege endpoints usando um filtro HTTP (token mock por padrão).

Descrição

Este repositório contém uma implementação em Java + Spring Boot para um serviço que valida tokens de acesso. O objetivo do projeto é demonstrar:

Como interceptar requisições HTTP antes que cheguem aos controllers (filtro/Filter).

Como retornar respostas apropriadas quando o token estiver ausente ou inválido.

Uma estrutura que permite trocar facilmente o mock de validação por uma validação real (JWT, introspecção OAuth2, consulta a banco/cache etc.).

O endpoint exemplo do desafio é:

[GET] /foo-bar

Header esperado:

Authorization: Bearer <token>

Comportamento esperado:

Token válido → 204 No Content (controller responde).

Token inválido/ausente → 401 Unauthorized com JSON descrevendo o erro (filtro responde).

Tecnologias

Java 17 (ou superior)

Spring Boot

Maven (ou Gradle — ajustar scripts se preferir)

Pré-requisitos

JDK 17+

Maven (ou usar o wrapper mvnw incluído)

Git

Executando localmente

Clone o repositório:

git clone https://github.com/xande-rj/Autentica-o.git
cd Autentica-o

Build e run usando Maven:

./mvnw clean package
./mvnw spring-boot:run

ou

mvn clean package
mvn spring-boot:run

O servidor vai iniciar em http://localhost:8080 por padrão.

Executando localmente

Clone o repositório:

git clone https://github.com/xande-rj/Autentica-o.git
cd Autentica-o

Build e run usando Maven:

./mvnw clean package
./mvnw spring-boot:run

ou

mvn clean package
mvn spring-boot:run

O servidor vai iniciar em http://localhost:8080 por padrão.

Estrutura do projeto

src/
main/
java/
com.example.auth/
filter/ # filtro que valida o token (ex: AuthenticationFilter)
service/ # TokenValidationService (mock ou implementação real)
controller/ # controllers (ex: FooController)
config/ # beans / configuração do filtro
resources/
application.yml
tests/
README.md
pom.xml
