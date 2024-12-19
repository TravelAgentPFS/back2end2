FROM openjdk:17-oracle
WORKDIR /app
COPY target/*.jar  app.jar
EXPOSE 8099
ENTRYPOINT ["java","-jar", "app.jar"]
