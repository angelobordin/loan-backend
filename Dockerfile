# Etapa 1: Construção da aplicação
# Use uma imagem base com Maven e JDK 17
FROM maven:3.9.5-eclipse-temurin-17 AS build

# Define o diretório de trabalho no container para a construção
WORKDIR /app

# Copia o arquivo de definição do Maven (pom.xml) e arquivos de configuração
COPY pom.xml .

# Baixa as dependências necessárias (evita baixar novamente se as dependências não mudarem)
RUN mvn dependency:go-offline -B

# Copia o código-fonte do projeto para o diretório de trabalho no container
COPY src ./src

# Empacota a aplicação (gera o JAR)
RUN mvn clean package -DskipTests

# Etapa 2: Criação da imagem de runtime
# Usa uma imagem base com apenas o JRE para executar a aplicação
FROM eclipse-temurin:17-jre-alpine

# Define o diretório de trabalho para o container em tempo de execução
WORKDIR /app

# Copia o JAR construído da etapa anterior para o container
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta em que a aplicação irá rodar
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
