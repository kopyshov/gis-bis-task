FROM openjdk:17-jdk-slim AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve
COPY /src /src
RUN ./mvnw clean package

FROM openjdk:17-jdk-slim
WORKDIR /
COPY --from=build /target/*.jar render-service.jar
ENTRYPOINT ["java", "--add-opens", "java.base/java.time=ALL-UNNAMED", "-jar", "render-service.jar"]
