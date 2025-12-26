FROM eclipse-temurin:17-jdk-alpine
WORKDIR /bhisma
COPY target/springboot-mysql-app.jar app.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]