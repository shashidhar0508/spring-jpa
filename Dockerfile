FROM openjdk:11
EXPOSE 8080
COPY build/libs/spring-jpa-0.0.1-SNAPSHOT.jar spring-jpa.jar
ENTRYPOINT ["java","-jar","/spring-jpa.jar"]