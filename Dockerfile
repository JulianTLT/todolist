FROM openjdk:16-oracle
COPY target/todolist-0.0.1-SNAPSHOT.jar /todolist.jar
CMD ["java", "-jar", "/todolist.jar"]
