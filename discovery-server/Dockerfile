FROM eclipse-temurin:17-jdk AS builder

WORKDIR /app

COPY  .mvn/ .mvn
COPY  mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw","spring-boot:run"]