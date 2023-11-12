FROM openjdk:11-ea-11-jdk-slim
COPY ../target/*.jar student.jar
EXPOSE 9091
ENTRYPOINT ["java","-jar","/student.jar"]