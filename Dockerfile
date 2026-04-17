# 1. Estágio de Build (Java 21)
FROM maven:3.9.6-eclipse-temurin-21-jammy AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# 2. Estágio de Execução (Java 21)
FROM eclipse-temurin:21-jr-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]